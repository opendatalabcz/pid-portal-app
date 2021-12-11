package cz.cvut.fit.pid_application.network

import cz.cvut.fit.pid_application.model.Delay
import retrofit2.http.GET

interface DelayAPI {
    @GET("1")
    suspend fun getDelay(): Delay
}