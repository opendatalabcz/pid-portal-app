package cvut.fit.pidmobapp.domain.actions

import cvut.fit.pidmobapp.model.dto.UserSignIn
import cvut.fit.pidmobapp.model.response.loginResponse.LoginResponse
import cvut.fit.pidmobapp.repository.AppRepository

class SignInAction(private val appRepository: AppRepository) {

    suspend fun execute(userSignIn: UserSignIn): LoginResponse {
        return appRepository.signIn(userSignIn)
    }
}