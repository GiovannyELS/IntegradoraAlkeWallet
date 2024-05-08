package com.example.alkewalletapp.fragmentos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import com.example.alkewalletapp.R

class HomePage : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val botonEnviar1 = view.findViewById<View>(R.id.botonVerde1)
        val botonIngresar1 = view.findViewById<View>(R.id.boton_ingresar1)


        botonEnviar1.setOnClickListener { v -> findNavController(v).navigate(R.id.action_homePage_to_sendMoney) }

        botonIngresar1.setOnClickListener { v -> findNavController(v).navigate(R.id.action_homePage_to_requestMoney) }
    }
}