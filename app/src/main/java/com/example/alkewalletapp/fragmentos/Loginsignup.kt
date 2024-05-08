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

class Loginsignup : Fragment() {
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
        return inflater.inflate(R.layout.fragment_loginsignup, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val botoncrearcuenta = view.findViewById<Button>(R.id.botoncrearcuenta)
        val yatienescuenta = view.findViewById<TextView>(R.id.tienescuentatext)


        botoncrearcuenta.setOnClickListener { v -> findNavController(v).navigate(R.id.action_loginsignup_to_signupPage) }

        yatienescuenta.setOnClickListener { v -> findNavController(v).navigate(R.id.action_loginsignup_to_loginPage) }
    }
}