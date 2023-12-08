package com.leaftware.dental.clinic.ui.views.singup.Splash

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.leaftware.dental.clinic.R
import com.leaftware.dental.clinic.databinding.FragmentSplashBinding
import com.leaftware.dental.clinic.domain.SplashUseCaseImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : Fragment() {

    private lateinit var _binding: FragmentSplashBinding
    //private val binding get() = _binding

    //private val SPLASH_DELAY: Long = 2000
    //private lateinit var viewModel: SplashViewModel

    private lateinit var binding: FragmentSplashBinding
    private val viewModel: SplashViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        /*_binding = FragmentSplashBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this)[SplashViewModel::class.java]

        viewModel.navigateToLogin.observe(viewLifecycleOwner) { shouldNavigate ->
            if (shouldNavigate) {
                findNavController().navigate(R.id.action_splash_fragment_to_login_fragment)
            }
        }
        Handler().postDelayed({
            viewModel.onSplashTimeout()
        }, SPLASH_DELAY)*/

        binding = FragmentSplashBinding.inflate(inflater, container, false)
        val view = binding.root

        // Configuración del ViewModel con el caso de uso SplashUseCase inyectado
        //viewModel = ViewModelProvider(this, SplashViewModelFactory(SplashUseCaseImpl())).get(SplashViewModel::class.java)

        observeNavigation()

        //return binding.root
        return view
    }

    private fun observeNavigation() {
        viewModel.navigateToNextScreen.observe(viewLifecycleOwner) { shouldNavigate ->
            if (shouldNavigate) {
                findNavController().navigate(R.id.action_splash_fragment_to_login_fragment)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //viewModel.onSplashTimeout()
    }
}