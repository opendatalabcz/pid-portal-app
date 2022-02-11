package cvut.fit.pidmobapp.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import cvut.fit.pidmobapp.model.dto.UserSignUp
import cvut.fit.pidmobapp.databinding.FragmentSignupBinding
import cvut.fit.pidmobapp.domain.viewmodel.LoginSharedViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignupBinding
    private val viewModel by sharedViewModel<LoginSharedViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignupBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonRegister.setOnClickListener {

            val name = binding.editName.editText?.text.toString()
            val username = binding.editUserName.editText?.text.toString()
            val email = binding.editEmail.editText?.text.toString()
            val password = binding.editPassword.editText?.text.toString()

            if (name.isNotBlank() && username.isNotBlank() && email.isNotBlank() && password.isNotBlank()) {
                val user = UserSignUp(name, username, password, email)
                viewModel.onSignUp(user)
            }
        }

        binding.buttonLogin.setOnClickListener{
            viewModel.onLoginClick()
        }
    }
}