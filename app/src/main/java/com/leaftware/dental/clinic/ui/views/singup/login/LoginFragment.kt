package com.leaftware.dental.clinic.ui.views.singup.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.leaftware.dental.clinic.R
import com.leaftware.dental.clinic.databinding.FragmentLoginBinding
import com.leaftware.dental.clinic.utils.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.textViewLogin.setOnClickListener {
            findNavController().navigate(R.id.action_login_fragment_to_change_password_fragment)
        }

        binding.buttonRegisterLogin.setOnClickListener {
            findNavController().navigate(R.id.action_login_fragment_to_register_user_Fragment)
        }

        binding.buttonStartLogin.setOnClickListener {
            val email = binding.editTextEmailLogin.text.toString()
            val password = binding.editTextPasswordLogin.text.toString()
            viewModel.authenticate(email, password)
        }
        observeLogin()
    }

    private fun observeLogin() {

        viewModel.emailEmptyFieldError.observe(viewLifecycleOwner) { isEmptyEmailError ->
            if (isEmptyEmailError) {
                requireContext().toast("El campo email esta vacio")
            }
        }

        viewModel.passwordEmptyFieldError.observe(viewLifecycleOwner) { isEmptyPasswordError ->
            if (isEmptyPasswordError) {
                requireContext().toast("El campo contraseña esta vacio")
            }
        }

        viewModel.emailFormatError.observe(viewLifecycleOwner) { isFormatEmailError ->
            if (isFormatEmailError) {
                requireContext().toast("El texto email no tiene formato correcto")
            }
        }

        viewModel.loginSuccess.observe(viewLifecycleOwner) { isSuccess ->
            if (isSuccess) {
                requireContext().toast("Login correcto")
            } else {
                requireContext().toast("Login incorrecto")
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}