package cz.cvut.fit.pid_application.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DelayNetwork {
    val retrofit by lazy {
        Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/api/delay/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(DelayAPI::class.java)
    }
}