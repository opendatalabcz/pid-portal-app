package cvut.fit.pidmobapp.model.response.loginResponse

data class JwtAuthResponse(
    val accessToken: String,
    val tokenType: String
)