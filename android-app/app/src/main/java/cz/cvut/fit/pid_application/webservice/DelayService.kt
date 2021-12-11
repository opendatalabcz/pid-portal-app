package cz.cvut.fit.pid_application.webservice

import cz.cvut.fit.pid_application.model.Delay
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface DelayService {
    @GET("destination")
    fun getDestinationList(@QueryMap filter: HashMap<String, String>): Call<List<Delay>>

    @GET("destination/{id}")
    fun getDestination(@Path("id") id: Int): Call<Delay>
}