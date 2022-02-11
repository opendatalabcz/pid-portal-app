package cvut.fit.pidmobapp.repository

import cvut.fit.pidmobapp.model.*
import cvut.fit.pidmobapp.model.response.TripResponse
import cvut.fit.pidmobapp.model.response.loginResponse.LoginResponse
import cvut.fit.pidmobapp.model.response.RouteShapeVehicles
import cvut.fit.pidmobapp.model.Vehicle
import cvut.fit.pidmobapp.model.dto.UserSignIn
import cvut.fit.pidmobapp.model.dto.UserSignUp
import cvut.fit.pidmobapp.model.response.RouteNextTripTimeResponse

interface AppRepository {

    suspend fun getRouteByNameLike(routeName: String): List<Route>?

    suspend fun getRouteById(routeId: String): Route?

    suspend fun getTripByRouteId(routeId: String): RouteShapeVehicles?

//    suspend fun getShapesById(shapeId: String): List<ShapeOld>

    suspend fun getAllStops(): List<Stop>

    suspend fun getRoutesWithNextTrip(stopUid: String): List<RouteNextTripTimeResponse>

    suspend fun signIn(userSignIn: UserSignIn): LoginResponse

    suspend fun signUp(userSignUp: UserSignUp): Boolean

    suspend fun getFavouriteRoutes(): List<Route>

    suspend fun getFavouriteTrips(): List<Trip>

    suspend fun getFavouriteRouteById(routeUid: String): Route?

    suspend fun saveFavouriteRoute(route: Route, token: String)

    suspend fun saveFavouriteRoutes(routes: List<Route>)

    suspend fun deleteFavouriteRoute(route: Route, token: String)

    suspend fun getFavouriteTripById(tripUid: String): Trip?

    suspend fun saveFavouriteTrip(trip: Trip, token: String)

    suspend fun deleteFavouriteTrip(trip: Trip, token: String)

    suspend fun saveFavouriteTrips(trips: List<Trip>)

    suspend fun clearFavourites()

    suspend fun getClosestTripByRouteId(stopId: String, routeId: String): TripResponse?

    suspend fun getVehicleById(vehicleId: String): Vehicle?

    suspend fun getTripById(tripId: String): TripResponse?
}