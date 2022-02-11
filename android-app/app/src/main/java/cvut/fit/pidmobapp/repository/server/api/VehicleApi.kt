package cvut.fit.pidmobapp.repository.server.api

import cvut.fit.pidmobapp.model.Vehicle
import cvut.fit.pidmobapp.config.Config
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface VehicleApi {

    @GET("{id}")
    suspend fun getById(@Path("id") id: String) : Response<Vehicle>

    companion object {
        private var BASE_URL = Config.BASE_URL + "api/vehicle/"

        fun create() : VehicleApi {

            val retrofit = BaseApi.createRetrofit(BASE_URL, null)

            return retrofit.create(VehicleApi::class.java)
        }
    }
}