package cvut.fit.pidmobapp.repository.server.api

import cvut.fit.pidmobapp.model.*
import cvut.fit.pidmobapp.model.response.TripResponse
import cvut.fit.pidmobapp.model.Vehicle
import cvut.fit.pidmobapp.config.Config
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TripApi {

    @GET("{id}")
    suspend fun getById(@Path("id") id: String) : Response<TripResponse>

    @GET("{routeId}")
    suspend fun getByRouteId(@Path("routeId") routeId: String) : Response<Trip?>

    // get vehicles for given trip
    @GET("{id}/vehicles")
    suspend fun getVehicles(@Path("id") id: Long) : Call<Set<Vehicle>>

    // get current position
    @GET("{id}/position")
    suspend fun getPosition(@Path("id") id: Long) : Call<Position>

    companion object {
        private var BASE_URL = Config.BASE_URL + "api/trip/"
        fun create() : TripApi {
            val retrofit = BaseApi.createRetrofit(BASE_URL, null)
            return retrofit.create(TripApi::class.java)
        }
    }
}