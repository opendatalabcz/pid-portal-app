package cvut.fit.pidmobapp.repository.server.api

import cvut.fit.pidmobapp.config.Config
import cvut.fit.pidmobapp.model.Stop
import cvut.fit.pidmobapp.model.response.TripResponse
import cvut.fit.pidmobapp.model.response.RouteNextTripTimeResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface StopApi {

    @GET("stop/{id}")
    suspend fun getById(@Path("id") id: Long) : Call<Stop>

    @GET("stop/")
    suspend fun getAllStops() : Response<List<Stop>>

    // get routes for given stop
    @GET("stop/{uid}/routesTime")
    suspend fun getRoutes(@Path("uid") uid: String) : Response<List<RouteNextTripTimeResponse>>

    @GET("stop/{stopId}/{routeId}")
    suspend fun getClosestTrip(@Path("stopId") stopId: String, @Path("routeId") routeId: String) : Response<TripResponse>

    companion object {
        private var BASE_URL = Config.BASE_URL + "api/"
        fun create() : StopApi {
            val retrofit = BaseApi.createRetrofit(BASE_URL, null)
            return retrofit.create(StopApi::class.java)
        }
    }
}