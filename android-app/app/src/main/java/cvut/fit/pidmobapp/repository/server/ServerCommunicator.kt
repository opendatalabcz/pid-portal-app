package cvut.fit.pidmobapp.repository.server

import cvut.fit.pidmobapp.model.*
import cvut.fit.pidmobapp.model.response.TripResponse
import cvut.fit.pidmobapp.repository.server.api.*
import cvut.fit.pidmobapp.model.response.RouteShapeVehicles
import cvut.fit.pidmobapp.model.response.loginResponse.LoginResponse
import cvut.fit.pidmobapp.model.Vehicle
import cvut.fit.pidmobapp.model.dto.UserSignIn
import cvut.fit.pidmobapp.model.dto.UserSignUp
import cvut.fit.pidmobapp.model.response.RouteNextTripTimeResponse
import retrofit2.Response

class ServerCommunicator {

    suspend fun getRouteByNameLike(routeName: String): Response<List<Route>> {
        val routeApi = RouteApi.create()
        return routeApi.getByNameLike(routeName)
    }

    suspend fun getRouteById(routeId: String): Response<Route?> {
        val routeApi = RouteApi.create()
        return routeApi.getById(routeId)
    }

    suspend fun getTripByRouteId(routeId: String): Response<RouteShapeVehicles> {
        val routeApi = RouteApi.create()
        return routeApi.getTrips(routeId)
    }

    suspend fun getClosestTripByRouteId(stopId: String,routeId: String): Response<TripResponse> {
        val stopApi = StopApi.create()
        return stopApi.getClosestTrip(stopId, routeId);
    }

    suspend fun getVehicleById(vehicleId: String): Response<Vehicle> {
        val vehicleApi = VehicleApi.create()
        return vehicleApi.getById(vehicleId)
    }

    suspend fun getAllStops(): Response<List<Stop>> {
        val stopApi = StopApi.create()
        return stopApi.getAllStops()
    }

    suspend fun getRoutesWithNextTrip(stopUid: String): Response<List<RouteNextTripTimeResponse>> {
        val stopApi = StopApi.create()
        return stopApi.getRoutes(stopUid)
    }

    suspend fun signIn(userSignIn: UserSignIn): Response<LoginResponse> {
        val authApi = AuthApi.create()
        return authApi.signIn(userSignIn)
    }

    suspend fun signUp(userSignUp: UserSignUp): Response<Unit> {
        val authApi = AuthApi.create()
        return authApi.signUp(userSignUp)
    }

    suspend fun postFavouriteRoute(routeUid: String, token: String): Response<Unit> {
        val userApi = UserApi.create(token)
        return userApi.postFavouriteRoute(routeUid)
    }

    suspend fun deleteFavouriteRoute(routeUid: String, token: String): Response<Unit> {
        val userApi = UserApi.create(token)
        return userApi.deleteFavouriteRoute(routeUid)
    }

    suspend fun postFavouriteTrip(tripUid: String, token: String): Response<Unit> {
        val userApi = UserApi.create(token)
        return userApi.postFavouriteTrip(tripUid)
    }

    suspend fun deleteFavouriteTrip(tripUid: String, token: String): Response<Unit> {
        val userApi = UserApi.create(token)
        return userApi.deleteFavouriteTrip(tripUid)
    }

    suspend fun getTripById(tripId: String): Response<TripResponse> {
        val tripApi = TripApi.create()
        return tripApi.getById(tripId)
    }

}