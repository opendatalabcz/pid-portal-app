package cvut.fit.pidmobapp.repository.server.api

import cvut.fit.pidmobapp.model.*
import cvut.fit.pidmobapp.config.Config
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UserApi {

    @GET("routes")
    fun getFavouriteRoutes() : Response<List<Route>>

    @GET("trips")
    fun getFavouriteTrips() : Response<List<Route>>

    @POST("routes/{routeId}")
    suspend fun postFavouriteRoute(@Path("routeId") routeUid: String) : Response<Unit>

    // get vehicles for given trip
    @DELETE("routes/{routeId}")
    suspend fun deleteFavouriteRoute(@Path("routeId") routeId: String) : Response<Unit>

    @POST("trips/{tripId}")
    suspend fun postFavouriteTrip(@Path("tripId") tripId: String) : Response<Unit>

    // get vehicles for given trip
    @DELETE("trips/{tripId}")
    suspend fun deleteFavouriteTrip(@Path("tripId") tripId: String) : Response<Unit>

    companion object {
        private var BASE_URL = Config.BASE_URL + "api/user/"

        fun create(token: String) : UserApi {

            val retrofit = BaseApi.createRetrofit(BASE_URL, token)
            return retrofit.create(UserApi::class.java)
        }
    }
}