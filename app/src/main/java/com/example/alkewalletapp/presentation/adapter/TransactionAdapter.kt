package com.example.alkewalletapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alkewalletapp.R
import com.example.alkewalletapp.data.local.Transaction

/**
 * Adapter para gestionar y mostrar una lista de transacciones en un RecyclerView.
 */
class TransactionAdapter : RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>() {

    /**
     * Lista de transacciones a mostrar.
     * Cuando se establece una nueva lista, se notifica a los observadores de datos del cambio.
     */
    var transactions = mutableListOf<Transaction>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    /**
     * Crea una nueva instancia de TransactionViewHolder.
     * El ViewGroup en el que se añadirá la nueva vista después de ser vinculada a una posición del adaptador.
     * El tipo de vista de la nueva vista.
     * return Una nueva instancia de TransactionViewHolder.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.users_item, parent, false)
        return TransactionViewHolder(view)
    }

    /**
     * Devuelve el tamaño de la lista de transacciones.
     */
    override fun getItemCount(): Int {
        return transactions.size
    }

    /**
     * Vincula los datos de una transacción a una vista en la posición especificada.
     *  holder El ViewHolder que debe ser actualizado para representar el contenido del ítem en la posición dada.
     *  position La posición del ítem dentro del conjunto de datos del adaptador.
     */
    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val transaction: Transaction = transactions[position]

        holder.profileImage.setImageResource(transaction.profileImage)
        holder.transactionType.setImageResource(transaction.transactionType)
        holder.date.text = transaction.date
        holder.name.text = transaction.name
        holder.operator.text = transaction.operator
        holder.amount.text = transaction.amount.toString()
    }

    /**
     * ViewHolder para las transacciones.
     * Mantiene las referencias a las vistas de cada ítem.
     */
    class TransactionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val profileImage: ImageView = view.findViewById(R.id.imageView7)
        val transactionType: ImageView = view.findViewById(R.id.imageView11)
        val name: TextView = view.findViewById(R.id.textView15)
        val date: TextView = view.findViewById(R.id.textView17)
        val operator: TextView = view.findViewById(R.id.operadorView)
        val amount: TextView = view.findViewById(R.id.textView16)
    }
}
