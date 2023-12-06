package com.leaftware.dental.clinic.views.singup.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }*/
        initViews()
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
        viewModel.isEmailEmpty.observe(this.viewLifecycleOwner){
            requireContext().toast("El campo email esta vacio")
        }

        viewModel.isPasswordEmpty.observe(this.viewLifecycleOwner){
            requireContext().toast("El campo contraseña esta vacio")
        }

        viewModel.isEmailFormat.observe(this.viewLifecycleOwner){
            requireContext().toast("El formato del campo email no es correcto")
        }

        viewModel.loginIsSuccessful.observe(this.viewLifecycleOwner){
            //findNavController().navigate(R.id.a)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}