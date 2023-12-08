package com.leaftware.dental.clinic.ui.views.singup.NewPassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.leaftware.dental.clinic.R
import com.leaftware.dental.clinic.databinding.FragmentNewPasswordBinding
import com.leaftware.dental.clinic.utils.toast

class NewPasswordFragment : Fragment() {

    private var _binding: FragmentNewPasswordBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: NewPasswordViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewPasswordBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[NewPasswordViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initViews() {
        binding.buttonStartNewPassword.setOnClickListener {
            val password = binding.editTextPasswordNewPassword.text.toString()
            val repeatPassword = binding.editTextRepeatPasswordNewPassword.text.toString()
            viewModel.setSendNewPassword(password, repeatPassword)
            validates()
        }

        binding.imageViewBackNewPassword.setOnClickListener {
            fragmentManager?.popBackStack()
        }
    }

    private fun validates() {
        viewModel.isPasswordEmpty.observe(this.viewLifecycleOwner) {
            requireContext().toast("El campo contraseña esta vacio")
        }

        viewModel.isRepeatPasswordEmpty.observe(this.viewLifecycleOwner) {
            requireContext().toast("El campo repetir contraseña esta vacio")
        }

        viewModel.SendNewPasswordIsSuccessful.observe(this.viewLifecycleOwner) {
            //findNavController().navigate(R.id.action_change_password_fragment_to_new_password_fragment)
        }
    }

    /*    companion object {
            */
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewPasswordFragment.
     *//*
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NewPasswordFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }*/
}