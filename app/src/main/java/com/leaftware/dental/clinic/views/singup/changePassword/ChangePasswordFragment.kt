package com.leaftware.dental.clinic.views.singup.changePassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.leaftware.dental.clinic.R
import com.leaftware.dental.clinic.databinding.FragmentChangePasswordBinding
import com.leaftware.dental.clinic.utils.toast

class ChangePasswordFragment : Fragment() {

    private var _binding: FragmentChangePasswordBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: ChangePasswordViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChangePasswordBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[ChangePasswordViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.buttonStartChangePassword.setOnClickListener {
            val email = binding.editTextEmailChangePassword.text.toString()
            viewModel.setSendChangePassword(email)
            validates()
        }

        binding.imageViewBackChangePasswordFragment.setOnClickListener {
            //requireContext().
            fragmentManager?.popBackStack()
        }
    }

    private fun validates() {
        viewModel.isEmailEmpty.observe(this.viewLifecycleOwner) {
            requireContext().toast("El campo email esta vacio")
        }

        viewModel.isEmailFormat.observe(this.viewLifecycleOwner) {
            requireContext().toast("El formato del campo email no es correcto")
        }

        viewModel.SendChangePasswordIsSuccessful.observe(this.viewLifecycleOwner) {
            findNavController().navigate(R.id.action_change_password_fragment_to_new_password_fragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}