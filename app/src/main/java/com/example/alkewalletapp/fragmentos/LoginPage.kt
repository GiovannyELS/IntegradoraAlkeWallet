package com.example.alkewalletapp.fragmentos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import com.example.alkewalletapp.R

class LoginPage : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login_page, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val botonlogin = view.findViewById<Button>(R.id.botonlogin)
        val crearnuevacuenta = view.findViewById<TextView>(R.id.textcrearnuevacuenta)


        botonlogin.setOnClickListener { v -> findNavController(v).navigate(R.id.action_loginPage_to_homePage) }

        crearnuevacuenta.setOnClickListener { v -> findNavController(v).navigate(R.id.action_loginPage_to_signupPage) }
    }
}