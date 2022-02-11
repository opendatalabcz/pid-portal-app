package cvut.fit.pidmobapp.repository

import android.util.Log
import cvut.fit.pidmobapp.repository.database.AppDatabase
import cvut.fit.pidmobapp.model.*
import cvut.fit.pidmobapp.model.response.TripResponse
import cvut.fit.pidmobapp.repository.server.ServerCommunicator
import cvut.fit.pidmobapp.model.response.loginResponse.LoginResponse
import cvut.fit.pidmobapp.model.response.RouteShapeVehicles
import cvut.fit.pidmobapp.model.Vehicle
import cvut.fit.pidmobapp.model.dto.UserSignIn
import cvut.fit.pidmobapp.model.dto.UserSignUp
import cvut.fit.pidmobapp.model.response.RouteNextTripTimeResponse
import java.lang.Exception

class AppRepositoryImpl(private val serverCommunicator: ServerCommunicator, private val database: AppDatabase) :
    AppRepository {

    override suspend fun getRouteByNameLike(routeName: String): List<Route>? {
        val routeResponse = serverCommunicator.getRouteByNameLike(routeName)
        if (routeResponse.isSuccessful)
            routeResponse.body()?.let {
                Log.i("routeResponse.body",routeResponse.body().toString())
                return routeResponse.body()
            }
        return emptyList()
    }

    override suspend fun getRouteById(routeId: String): Route? {
        val routeResponse = serverCommunicator.getRouteById(routeId)
        if (routeResponse.isSuccessful)
            routeResponse.body()?.let {
                return routeResponse.body()
            }
        return null
    }

    override suspend fun getClosestTripByRouteId(stopId: String, routeId: String): TripResponse? {
        val tripVehicleDto = serverCommunicator.getClosestTripByRouteId(stopId, routeId)
        if (tripVehicleDto.isSuccessful)
            tripVehicleDto.body()?.let {
                return it
            }
        return null
    }

    override suspend fun getTripById(tripId: String): TripResponse? {
        val tripDto = serverCommunicator.getTripById(tripId)
        if (tripDto.isSuccessful)
            tripDto.body()?.let {
                return it
            }
        return null
    }

    override suspend fun getTripByRouteId(routeId: String): RouteShapeVehicles? {
        val routeShapeVehiclesResponse = serverCommunicator.getTripByRouteId(routeId)
        if (routeShapeVehiclesResponse.isSuccessful)
            routeShapeVehiclesResponse.body()?.let {
                return it
            }
        return null
    }

    override suspend fun getVehicleById(vehicleId: String): Vehicle? {
        val vehicle = serverCommunicator.getVehicleById(vehicleId)
        if (vehicle.isSuccessful)
            vehicle.body()?.let {
                return it
            }
        return null
    }

//    override suspend fun getShapesById(shapeId: String): List<ShapeOld> {
//        val shapesResponse = serverCommunicator.getShapesById(shapeId)
//        if (shapesResponse.isSuccessful)
//            shapesResponse.body()?.let {
//                return it
//            }
////        return database.shapeDao().getById(shapeId)
//        return emptyList()
//    }

    override suspend fun getAllStops(): List<Stop> {
        val stopsResponse = serverCommunicator.getAllStops()
        if (stopsResponse.isSuccessful)
            stopsResponse.body()?.let {
                return it
            }
        return emptyList()
    }

    override suspend fun getRoutesWithNextTrip(stopUid: String): List<RouteNextTripTimeResponse> {
        val routeResponse = serverCommunicator.getRoutesWithNextTrip(stopUid)
        if (routeResponse.isSuccessful)
            routeResponse.body()?.let {
                return it
            }
        return emptyList()
    }

    override suspend fun signIn(userSignIn: UserSignIn): LoginResponse {
        val authResponse = serverCommunicator.signIn(userSignIn = userSignIn)
        if (authResponse.isSuccessful)
            authResponse.body()?.let {
                return it
            }
        throw Exception()
    }


    override suspend fun signUp(userSignUp: UserSignUp): Boolean {
        val authResponse = serverCommunicator.signUp(userSignUp = userSignUp)
        if (authResponse.isSuccessful)
                return true
        return false
    }

    override suspend fun getFavouriteRoutes(): List<Route> {
        val favouriteRoutes = database.favouriteRoutesDao().getAll()
        favouriteRoutes?.let {
            return it
        }
        return emptyList()
    }

    override suspend fun getFavouriteTrips(): List<Trip> {
        val favouriteRoutes = database.favouriteTripsDao().getAll()
        favouriteRoutes?.let {
            return it
        }
        return emptyList()
    }

    override suspend fun getFavouriteRouteById(routeUid: String): Route? {
        val favouriteRoute = database.favouriteRoutesDao().getById(routeUid)
        favouriteRoute?.let {
            return it
        }
        return null
    }

    override suspend fun saveFavouriteRoute(route: Route, token: String) {
        serverCommunicator.postFavouriteRoute(routeUid = route.uid, token)
        database.favouriteRoutesDao().insert(route)
    }

    override suspend fun deleteFavouriteRoute(route: Route, token: String) {
        serverCommunicator.deleteFavouriteRoute(routeUid = route.uid, token)
        database.favouriteRoutesDao().delete(route)
    }

    override suspend fun saveFavouriteRoutes(routes: List<Route>) {
        database.favouriteRoutesDao().insertAll(routes)
    }

    override suspend fun getFavouriteTripById(tripUid: String): Trip? {
        return database.tripDao().getById(tripUid)
    }

    override suspend fun saveFavouriteTrips(trips: List<Trip>) {
        database.tripDao().insertAll(trips)
    }

    override suspend fun saveFavouriteTrip(trip: Trip, token: String) {
        serverCommunicator.postFavouriteTrip(tripUid = trip.uid, token)
        database.tripDao().insert(trip)
    }

    override suspend fun deleteFavouriteTrip(trip: Trip, token: String) {
        serverCommunicator.deleteFavouriteTrip(tripUid = trip.uid, token)
        database.tripDao().delete(trip)
    }

    override suspend fun clearFavourites() {
        database.favouriteRoutesDao().deleteAllFavouriteRoutes()
        database.tripDao().deleteAllTrips()
    }
}