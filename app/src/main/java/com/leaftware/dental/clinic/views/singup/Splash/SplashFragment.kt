package com.leaftware.dental.clinic.views.singup.Splash

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.leaftware.dental.clinic.R
import com.leaftware.dental.clinic.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {

    private lateinit var _binding: FragmentSplashBinding
    private val binding get() = _binding

    private val SPLASH_DELAY: Long = 2000
    private lateinit var viewModel: SplashViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this)[SplashViewModel::class.java]

        viewModel.navigateToLogin.observe(viewLifecycleOwner) { shouldNavigate ->
            if (shouldNavigate) {
                findNavController().navigate(R.id.action_splash_fragment_to_login_fragment)
            }
        }
        Handler().postDelayed({
            viewModel.onSplashTimeout()
        }, SPLASH_DELAY)

        return binding.root
    }
}