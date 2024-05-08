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

class SignupPage : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val botonCrearCtaDos = view.findViewById<Button>(R.id.botoncrearcuenta2)
        val textYaTienesUna = view.findViewById<TextView>(R.id.textyatienesuna)


        botonCrearCtaDos.setOnClickListener { v -> findNavController(v).navigate(R.id.action_signupPage_to_loginsignup) }

        textYaTienesUna.setOnClickListener { v -> findNavController(v).navigate(R.id.action_signupPage_to_loginPage) }
    }
}