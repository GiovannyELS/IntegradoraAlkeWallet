package com.example.alkewalletapp.fragmentos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import com.example.alkewalletapp.R

class SendMoney : Fragment() {
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
        return inflater.inflate(R.layout.fragment_send_money, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val botonback = view.findViewById<ImageView>(R.id.boton_back)
        val botonhome = view.findViewById<View>(R.id.botonverdeenviar)


        botonback.setOnClickListener { v -> findNavController(v).navigate(R.id.action_sendMoney_to_homePage) }

        botonhome.setOnClickListener { v -> findNavController(v).navigate(R.id.action_sendMoney_to_loginsignup) }
    }
}