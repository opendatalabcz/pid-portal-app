package cvut.fit.pidmobapp.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import cvut.fit.pidmobapp.R
import cvut.fit.pidmobapp.databinding.ActivityLoginBinding
import cvut.fit.pidmobapp.domain.viewmodel.LoginSharedViewModel
import cvut.fit.pidmobapp.presentation.fragment.LoginFragment
import cvut.fit.pidmobapp.presentation.fragment.SignUpFragment
import cvut.fit.pidmobapp.config.Config.SHARED_PREFERENCES
import cvut.fit.pidmobapp.config.Config.SP_IS_AUTH
import cvut.fit.pidmobapp.config.Config.SP_TOKEN
import cvut.fit.pidmobapp.config.Config.SP_USER_NAME
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel by viewModel<LoginSharedViewModel>()
    private val loginFragment: LoginFragment by inject()
    private val mSignUpFragment: SignUpFragment by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.liveDataToken.observe(this, {
            val sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString(SP_TOKEN, it.jwtAuthResponse.accessToken)
            editor.putString(SP_USER_NAME, it.user.name)
            editor.putBoolean(SP_IS_AUTH, true)
            editor.apply()
            val mapsIntent = Intent(this, MapsActivity::class.java)
            startActivity(mapsIntent)
        })

        viewModel.liveDataShowSignUp.observe(this, {
            showFragment(mSignUpFragment)
        })
        viewModel.liveDataShowLogIn.observe(this, {
            showFragment(loginFragment)
        })
        showFragment(loginFragment)
    }

    private fun <T : Fragment> showFragment(fragment: T) {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.fragment_container, fragment,
                fragment.toString())
            .commit()
    }

    override fun onBackPressed() {
        val mapsIntent = Intent(this, MapsActivity::class.java)
        finish()
        startActivity(mapsIntent)
    }
}