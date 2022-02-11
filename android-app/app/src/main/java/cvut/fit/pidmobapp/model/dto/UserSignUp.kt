package cvut.fit.pidmobapp.model.dto

data class UserSignUp(
    var name: String,
    var username: String,
    var password: String,
    var email: String) {

    fun toUserLogin() = UserSignIn (
        usernameOrEmail = username,
        password = password
    )
}
