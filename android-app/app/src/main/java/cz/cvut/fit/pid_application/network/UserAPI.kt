package cz.cvut.fit.pid_application.network

import cz.cvut.fit.pid_application.model.User
import retrofit2.http.GET

interface UserAPI {
    @GET("posts/1")
    suspend fun getPost(): User

    @GET("posts")
    suspend fun getPosts(): List<User>
}