package com.leaftware.dental.clinic.views.singup.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.leaftware.dental.clinic.R
import com.leaftware.dental.clinic.databinding.FragmentLoginBinding
import com.leaftware.dental.clinic.utils.toast

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: LoginViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        initViews()
        return binding.root
    }

    private fun initViews () {
        binding.textViewLogin.setOnClickListener {
            findNavController().navigate(R.id.action_login_fragment_to_change_password_fragment)
        }

        binding.buttonRegisterLogin.setOnClickListener {
            findNavController().navigate(R.id.action_login_fragment_to_register_user_Fragment)
        }

        binding.buttonStartLogin.setOnClickListener {
            val email = binding.editTextEmailLogin.text.toString()
            val password = binding.editTextPasswordLogin.text.toString()
            viewModel.setLogin(email, password)

        }
        validates()
    }

    private fun validates(){
        viewModel.isEmailEmpty.observe(viewLifecycleOwner, Observer {
            requireContext().toast("El campo email esta vacio")
        })

        viewModel.isPasswordEmpty.observe(viewLifecycleOwner, Observer {
            requireContext().toast("El campo contraseña esta vacio")
        })

        viewModel.isEmailFormat.observe(viewLifecycleOwner, Observer {
            requireContext().toast("El formato del campo email no es correcto")
        })

        viewModel.loginIsSuccessful.observe(viewLifecycleOwner, Observer {
            //findNavController().navigate(R.id.a)
        })
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}