package com.example.alkewalletapp.presentation.ui.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.alkewalletapp.R
import com.example.alkewalletapp.databinding.FragmentSplashBinding

/**
 * Fragmento que representa la pantalla de bienvenida o "splash" de la aplicación.
 */
class Splash : Fragment() {

    private lateinit var binding: FragmentSplashBinding
    // Tiempo de espera en milisegundos antes de navegar a la página de inicio de sesión o registro.
    private val SPLASH_TIME_OUT: Long = 3000

    /**
     * Se llama cuando el fragmento se crea.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
        }
    }

    /**
     * Infla el diseño para este fragmento.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Se llama inmediatamente después de que se ha llamado a onCreateView().
     *
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Navega a la página de inicio de sesión o registro después de un retraso definido.
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_splash_to_loginsignup)
        }, SPLASH_TIME_OUT)
    }
}
