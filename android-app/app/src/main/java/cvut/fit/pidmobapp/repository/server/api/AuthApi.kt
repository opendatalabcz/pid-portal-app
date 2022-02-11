package cvut.fit.pidmobapp.repository.server.api

import cvut.fit.pidmobapp.model.dto.UserSignIn
import cvut.fit.pidmobapp.model.dto.UserSignUp
import cvut.fit.pidmobapp.model.response.loginResponse.LoginResponse
import cvut.fit.pidmobapp.config.Config
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST("signin")
    suspend fun signIn(@Body userSignIn: UserSignIn): Response<LoginResponse>

    @POST("signup")
    suspend fun signUp(@Body userSignUp: UserSignUp) : Response<Unit>

    companion object {

        private var BASE_URL = Config.BASE_URL + "api/auth/"

        fun create() : AuthApi {

            val retrofit = BaseApi.createRetrofit(BASE_URL, null)

            return retrofit.create(AuthApi::class.java)

        }
    }
}