package cvut.fit.pidmobapp.model.response.loginResponse

data class Token(
    val accessToken: String,
    val tokenType: String
)