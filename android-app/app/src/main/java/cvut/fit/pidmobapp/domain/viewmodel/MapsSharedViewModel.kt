package cvut.fit.pidmobapp.domain.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.Polyline
import com.google.android.gms.maps.model.PolylineOptions
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.maps.android.clustering.ClusterItem
import com.google.maps.android.clustering.ClusterManager
import cvut.fit.pidmobapp.R
import cvut.fit.pidmobapp.model.response.RouteShapeVehicles
import cvut.fit.pidmobapp.domain.actions.*
import cvut.fit.pidmobapp.model.Route
import cvut.fit.pidmobapp.model.Stop
import cvut.fit.pidmobapp.model.Trip
import cvut.fit.pidmobapp.model.dto.StopRouteNextTripTimeDto
import cvut.fit.pidmobapp.model.response.TripResponse
import cvut.fit.pidmobapp.model.Vehicle
import cvut.fit.pidmobapp.utils.BaseClusterItem
import cvut.fit.pidmobapp.utils.IconRenderer
import cvut.fit.pidmobapp.config.Config.SERVER_QUERY_TIME
import kotlinx.coroutines.*
import org.koin.core.component.inject

class MapsSharedViewModel(application: Application)
    : BaseViewModel(application), GoogleMap.OnPolylineClickListener {

    private val getRouteByNameLikeAction: GetRouteByNameLikeAction by inject()
    private val getRouteNextArriveAction: GetRouteNextArriveAction by inject()
    private val mGetRouteShapeVehiclesByRouteIdAction: GetRouteShapeVehiclesByRouteIdAction by inject()
    private val getClosesTripAction: GetClosesTripAction by inject()
    private val getTripAction: GetTripAction by inject()
    private val getVehicleAction: GetVehicleAction by inject()
    private val getAllStopsAction: GetAllStopsAction by inject()
    private val getFavouriteRoutesAction: GetFavouriteRoutesAction by inject()
    private val getFavouriteTrips: GetFavouriteTripsAction by inject()
    private lateinit var mMap: GoogleMap

    private lateinit var clusterManagerVehicle: ClusterManager<BaseClusterItem>
    private lateinit var clusterManagerStop: ClusterManager<BaseClusterItem>

    private val _liveDataPolyline = MutableLiveData<Polyline>()
    private val _liveDataBottomSheetState = MutableLiveData<Int>()

    private val _liveDataStop = MutableLiveData<Stop>()
    private val _liveDataRouteShapeVehicles = MutableLiveData<RouteShapeVehicles>()
    private val _liveDataRoute = MutableLiveData<Route>()
    private val _liveDataTripVehicle = MutableLiveData<TripResponse>()
    private val _liveDataTrip = MutableLiveData<Trip>()
    private val _liveDataStopRoutes = MutableLiveData<List<StopRouteNextTripTimeDto>>()

    private val _liveDataSearchRoute = MutableLiveData<List<Route>>()
    private val _liveDataVehicle = MutableLiveData<Vehicle>()
    private val _liveDataFavouriteRoutes = MutableLiveData<List<Route>>()
    private val _liveDataFavouriteTrips = MutableLiveData<List<Trip>>()

    val liveDataBottomSheetState: LiveData<Int> = _liveDataBottomSheetState
    val liveDataStop: LiveData<Stop> = _liveDataStop
    val liveDataRouteShapeVehicles: LiveData<RouteShapeVehicles> = _liveDataRouteShapeVehicles
    val liveDataRoute: LiveData<Route> = _liveDataRoute
    val liveDataStopRoutesDto: LiveData<List<StopRouteNextTripTimeDto>> = _liveDataStopRoutes
    val liveDataSearchRoute: LiveData<List<Route>> = _liveDataSearchRoute
    val liveDataVehicle: LiveData<Vehicle> = _liveDataVehicle
    val liveDataTrip: LiveData<Trip> = _liveDataTrip
    val liveDataTripVehicle: LiveData<TripResponse> = _liveDataTripVehicle
    val liveDataFavouriteRoutes: LiveData<List<Route>> = _liveDataFavouriteRoutes
    val liveDataFavouriteTrips: LiveData<List<Trip>> = _liveDataFavouriteTrips

    fun onRouteSelect(route: Route) {
        CoroutineScope(Dispatchers.Default).launch {
            Log.e("route uid", route.uid)

            stopUpdateVehicles()

            val routeShapeTrips = mGetRouteShapeVehiclesByRouteIdAction.execute(route.uid)

            routeShapeTrips?.let {
                _liveDataRouteShapeVehicles.postValue(
                    it
                )

                _liveDataRoute.postValue(
                    it.route
                )

                val vehicles = it.vehicles

                vehicles?.let {
                    if (vehicles.isNotEmpty()) {
                        CoroutineScope(Dispatchers.Main).launch {

                            addPoints(clusterManagerVehicle, vehicles)
                            startUpdateVehicles(routeUid = route.uid)

                        }
                    }
                }

                val shapes = it.routeShape

                shapes?.let {

                    val polylineOptions = PolylineOptions().clickable(true)
                    for (shape in shapes) {
                        polylineOptions.add(LatLng(shape.lat, shape.lon))
                    }

                    CoroutineScope(Dispatchers.Main).launch {
                        _liveDataPolyline.value?.remove()
                        val polyline = mMap.addPolyline(polylineOptions)
                        polyline.tag = "route"
                        polyline.color = -0x1000000
                        polyline.width = 12.toFloat()
                        _liveDataPolyline.setValue(polyline)
                    }
                }
            }
        }
    }

    fun onTripSelect(trip: Trip) {
        CoroutineScope(Dispatchers.Default).launch {
            stopUpdateVehicles()

            val tripShape = getTripAction.execute(trip.uid)

            tripShape?.let {
                _liveDataTripVehicle.postValue(
                    it
                )

                _liveDataTrip.postValue(
                    it.trip
                )

                _liveDataVehicle.postValue(
                    it.vehicle
                )

                val vehicle = it.vehicle

                vehicle.let {
                    CoroutineScope(Dispatchers.Main).launch {
                        addPoints(clusterManagerVehicle, listOf(vehicle) )
                        startUpdateVehicle(vehicle.id)
                    }
                }

                val shapes = it.shapes

                shapes?.let {
                    val polylineOptions = PolylineOptions().clickable(true)
                    for (shape in shapes) {
                        polylineOptions.add(LatLng(shape.lat, shape.lon))
                    }

                    CoroutineScope(Dispatchers.Main).launch {
                        _liveDataPolyline.value?.remove()
                        val polyline = mMap.addPolyline(polylineOptions)
                        polyline.tag = "route"
                        polyline.color = -0x1000000
                        polyline.width = 12.toFloat()
                        _liveDataPolyline.setValue(polyline)
                    }
                }
            }
        }
    }

    fun onClosestTrip(stopId: String, route: Route) {
        CoroutineScope(Dispatchers.Default).launch {
            stopUpdateVehicles()

            val closestTrip = getClosesTripAction.execute(stopId, route.uid)

            closestTrip?.let {
                _liveDataTripVehicle.postValue(
                    it
                )

                _liveDataTrip.postValue(
                    it.trip
                )

                _liveDataVehicle.postValue(
                    it.vehicle
                )

                val vehicle = it.vehicle

                vehicle.let {
                    CoroutineScope(Dispatchers.Main).launch {
                        addPoints(clusterManagerVehicle, listOf(vehicle) )
                        startUpdateVehicle(vehicle.id)
                    }
                }

                val shapes = it.shapes

                shapes?.let {
                    val polylineOptions = PolylineOptions().clickable(true)
                    for (shape in shapes) {
                        polylineOptions.add(LatLng(shape.lat, shape.lon))
                    }

                    CoroutineScope(Dispatchers.Main).launch {
                        _liveDataPolyline.value?.remove()
                        val polyline = mMap.addPolyline(polylineOptions)
                        polyline.tag = "route"
                        polyline.color = -0x1000000
                        polyline.width = 12.toFloat()
                        _liveDataPolyline.setValue(polyline)
                    }
                }
            }
        }
    }



    fun getFavouriteRoutes() {
        CoroutineScope(Dispatchers.Default).launch {
            _liveDataFavouriteRoutes.postValue(getFavouriteRoutesAction.execute())
        }
    }
    fun getFavouriteTrips() {
        CoroutineScope(Dispatchers.Default).launch {
            _liveDataFavouriteTrips.postValue(getFavouriteTrips.execute())
        }
    }

    fun onSearchChanged(requestText: String) {
        if (requestText.isNotEmpty()) {
            CoroutineScope(Dispatchers.Default).launch {
                val searchResult = getRouteByNameLikeAction.execute(requestText)
                searchResult?.let {
                    _liveDataSearchRoute.postValue(it)
                    return@launch
                }
            }
        }
        _liveDataSearchRoute.value = emptyList()
    }

    private val scope = CoroutineScope(Dispatchers.Default) // could also use an other scope such as viewModelScope if available
    private var job: Job? = null

    private fun startUpdateVehicle(vehicleUid: String) {
        stopUpdateVehicles()
        job = scope.launch {
            while(true) {
                val vehicle = getVehicleAction.execute(vehicleUid)

                vehicle?.let {
                    CoroutineScope(Dispatchers.Main).launch {
                        clusterManagerVehicle.clearItems()
                        addPoints(clusterManagerVehicle, listOf(it))
                    }
                }

                delay(SERVER_QUERY_TIME)
            }
        }
    }

    private fun startUpdateVehicles(routeUid: String) {
        stopUpdateVehicles()
        job = scope.launch {
            while(true) {
                val routeShapeTrips = mGetRouteShapeVehiclesByRouteIdAction.execute(routeUid)

                routeShapeTrips?.let {

                    if (!it.vehicles.isNullOrEmpty()) {
                        CoroutineScope(Dispatchers.Main).launch {
                            clusterManagerVehicle.clearItems()
                            addPoints(clusterManagerVehicle, it.vehicles)
                        }
                    }

                }

                delay(SERVER_QUERY_TIME)
            }
        }
    }

    fun stopUpdateVehicles() {
        job?.cancel()
        job = null
    }

    fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        clusterManagerVehicle = ClusterManager<BaseClusterItem>(getContext(), mMap)
        clusterManagerStop = ClusterManager<BaseClusterItem>(getContext(), mMap)

        mMap.setPadding(0,0,0, 200)
        mMap.setMapStyle(
            MapStyleOptions.loadRawResourceStyle(
                getContext(), R.raw.map_style))

        val prague = LatLng(50.073658, 14.418540)

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(prague, 15f))
        mMap.setOnPolylineClickListener(this)

        CoroutineScope(Dispatchers.Default).launch {
            val stops = getAllStopsAction.execute()

            if (stops.isNotEmpty()) {
                CoroutineScope(Dispatchers.Main).launch {
                    addPoints(clusterManagerStop, stops)
                }
            }
        }
    }

    private fun addPoints(clusterManager: ClusterManager<BaseClusterItem>, points: List<BaseClusterItem>) {
        clusterManager.renderer =
            IconRenderer(
                getContext(),
                mMap,
                clusterManager,
                points[0].drawable,
                points[0].color
            )

        clusterManager.addItems(points)
        clusterManager.cluster()

        clusterManager.setOnClusterItemClickListener { item ->
            onClusterItemClick(item)
            return@setOnClusterItemClickListener false
        }

        mMap.setOnCameraMoveStartedListener {
            clusterManager.markerCollection.markers.forEach { it.alpha = 0.3f }
            clusterManager.clusterMarkerCollection.markers.forEach { it.alpha = 0.3f }
        }

        mMap.setOnCameraIdleListener {
            clusterManager.markerCollection.markers.forEach { it.alpha = 1.0f }
            clusterManager.clusterMarkerCollection.markers.forEach { it.alpha = 1.0f }
            clusterManager.onCameraIdle()
        }
    }

    private fun <T : ClusterItem> onClusterItemClick(item: T) {
        when (item) {
            is Stop -> {
                stopUpdateVehicles()
                clusterManagerVehicle.clearItems()
                clusterManagerVehicle.cluster()

                _liveDataPolyline.value?.remove()

                _liveDataStop.value = item
                CoroutineScope(Dispatchers.Default).launch {
                    _liveDataStopRoutes.postValue(getRouteNextArriveAction.execute(stopUid = item.uid))
                }
            }
            is Vehicle -> _liveDataVehicle.value = item
        }
    }

    fun setBottomSheetState(newBottomSheetState: Int) {
        _liveDataBottomSheetState.value = newBottomSheetState
        onBottomSheetStateChanged(newBottomSheetState)
    }

    fun onBottomSheetStateChanged(newBottomSheetState: Int) {
        when(newBottomSheetState) {
            BottomSheetBehavior.STATE_COLLAPSED -> mMap.setPadding(0,0,0, 200)
            BottomSheetBehavior.STATE_HALF_EXPANDED -> mMap.setPadding(0,0,0, 400)
        }
    }

    override fun onPolylineClick(p0: Polyline) {
        p0.remove()
    }

    override fun onCleared() {
        stopUpdateVehicles()
        super.onCleared()
    }
}