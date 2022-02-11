package cvut.fit.pidmobapp.domain.viewmodel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cvut.fit.pidmobapp.R
import cvut.fit.pidmobapp.model.dto.UserSignIn
import cvut.fit.pidmobapp.model.dto.UserSignUp
import cvut.fit.pidmobapp.model.response.loginResponse.LoginResponse
import cvut.fit.pidmobapp.domain.actions.SaveFavouriteRoutesAction
import cvut.fit.pidmobapp.domain.actions.SaveFavouriteTripsAction
import cvut.fit.pidmobapp.domain.actions.SignInAction
import cvut.fit.pidmobapp.domain.actions.SignUpAction
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.inject
import java.lang.Exception

class LoginSharedViewModel(application: Application) : BaseViewModel(application) {

    private val signInAction: SignInAction by inject()
    private val signUpAction: SignUpAction by inject()
    private val saveFavouriteRoutesAction: SaveFavouriteRoutesAction by inject()
    private val saveFavouriteTripsAction: SaveFavouriteTripsAction by inject()

    private val _liveDataToken = MutableLiveData<LoginResponse>()
    private val _liveDataShowSignUp = MutableLiveData<Unit>()
    private val _liveDataShowLogIn = MutableLiveData<Unit>()

    val liveDataToken: LiveData<LoginResponse> = _liveDataToken
    val liveDataShowSignUp: LiveData<Unit> = _liveDataShowSignUp
    val liveDataShowLogIn: LiveData<Unit> = _liveDataShowLogIn


    fun onSignIn(userSignIn: UserSignIn){
        CoroutineScope(Dispatchers.Default).launch {
            try {
                val result = signInAction.execute(userSignIn)

                if (result.user.favouriteRoutes.isNotEmpty()) {
                    saveFavouriteRoutesAction.execute(result.user.favouriteRoutes)
                }
                if (result.user.favouriteTrips.isNotEmpty()) {
                    saveFavouriteTripsAction.execute(result.user.favouriteTrips)
                }

                CoroutineScope(Dispatchers.Main).launch {
                        _liveDataToken.value = result
                }
            } catch (e: Exception) {
                CoroutineScope(Dispatchers.Main).launch {
                    Toast.makeText(getApplication(), R.string.login_error, Toast.LENGTH_SHORT)
                        .show()
                }
                print(e.message)
            }
        }
    }

    fun onSignUp(userSignUp: UserSignUp){
        CoroutineScope(Dispatchers.Default).launch {
            val result = signUpAction.execute(userSignUp)
            if (result)
                onSignIn(userSignUp.toUserLogin())
            else Log.e("Error sign up", "dsfg")
        }
    }

    fun onLoginClick() {
        _liveDataShowLogIn.value = Unit
    }

    fun onRegisterClick() {
        _liveDataShowSignUp.value = Unit
    }

}