package com.example.alkewalletapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.alkewalletapp.R
import com.example.alkewalletapp.data.local.Transaction


/**
 * ViewModel para la página de inicio.
 * Esta clase maneja la lógica y los datos necesarios para la pantalla de inicio,
 * incluyendo la carga de transacciones de ejemplo.
 */
class HomePageViewModel : ViewModel() {

    private val _transaction = MutableLiveData<MutableList<Transaction>>()

    /**
     * LiveData que expone la lista de transacciones.
     */
    val transaction: LiveData<MutableList<Transaction>> get() = _transaction

    /**
     * Inicializa el ViewModel cargando las transacciones de ejemplo.
     */
    init {
        loadTransaction()
    }

    /**
     * Carga una lista de transacciones de ejemplo y las asigna al LiveData de transacciones.
     */
    private fun loadTransaction() {
        val exampleTransaction = mutableListOf(
            Transaction(
                R.drawable.profilepicture1, R.drawable.send_iconamarillo, "Kathy",
                "Oct 14,10:24", "-$", 100.0
            ),
            Transaction(
                R.drawable.profilepicture2, R.drawable.request_iconazul, "Kony",
                "Oct 16,01:10", "+$", 120.0
            ),
            Transaction(
                R.drawable.profilepicture3, R.drawable.send_iconamarillo, "Pablo",
                "Oct 14,10:24", "-$", 200.0
            ),
            Transaction(
                R.drawable.profilepicture4, R.drawable.send_iconamarillo, "Barbara",
                "Oct 20,11:25", "-$", 130.0
            ),
            Transaction(
                R.drawable.profilepicture5, R.drawable.request_iconazul, "Daniela",
                "Oct 01,05:00", "+$", 300.0
            ),
            Transaction(
                R.drawable.profilepicture6, R.drawable.request_iconazul, "Frank",
                "Oct 12,10:24", "+$", 600.0
            ),
            Transaction(
                R.drawable.profilepicture1, R.drawable.send_iconamarillo, "Kathy",
                "Oct 14,10:24", "-$", 100.0
            )
        )
        _transaction.value = exampleTransaction
    }
}
