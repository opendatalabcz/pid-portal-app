package cvut.fit.pidmobapp.model.response.loginResponse

import cvut.fit.pidmobapp.model.User

data class LoginResponse(
    val jwtAuthResponse: JwtAuthResponse,
    val user: User
)