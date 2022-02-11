package cvut.fit.pidmobapp.domain.actions

import cvut.fit.pidmobapp.model.dto.UserSignUp
import cvut.fit.pidmobapp.repository.AppRepository

class SignUpAction(private val appRepository: AppRepository) {

    suspend fun execute(userSignUp: UserSignUp): Boolean {
        return appRepository.signUp(userSignUp)
    }
}