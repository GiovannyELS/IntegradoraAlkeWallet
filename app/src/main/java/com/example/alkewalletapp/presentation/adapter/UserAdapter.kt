package com.example.alkewalletapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.alkewalletapp.data.local.User
import com.example.alkewalletapp.databinding.UsersItemBinding

/**
 * Adapter para gestionar y mostrar una lista de usuarios en un RecyclerView utilizando ListAdapter
 * para manejar cambios en la lista de mejor manera.
 */
class UserAdapter : ListAdapter<User, UserAdapter.UserViewHolder>(UserDiffCallback()) {

    /**
     * Crea una nueva instancia de [UserViewHolder].
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = UsersItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    /**
     * Vincula los datos de un usuario a una vista en la posición especificada.
     * holder El ViewHolder que debe ser actualizado para representar el contenido del ítem
     * en la posición dada.
     * position La posición del ítem dentro del conjunto de datos del adaptador.
     */
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user)
    }

    /**
     * ViewHolder para los usuarios.
     * Mantiene las referencias a las vistas de cada ítem y proporciona un método para enlazar datos
     * de usuario a esas vistas.
     */
    class UserViewHolder(private val binding: UsersItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        /**
         * Enlaza los datos de un usuario a las vistas correspondientes.
         *El usuario cuyos datos serán enlazados a las vistas.
         */
        fun bind(user: User) {
            binding.textView15.text = user.name
            binding.textView16.text = "$${user.balance}"
            binding.imageView7.setImageResource(user.profileImage)
        }
    }
}

/**
 * Callback para calcular la diferencia entre dos listas de usuarios.
 * Utilizado para determinar si un ítem es el mismo o si su contenido ha cambiado.
 */
class UserDiffCallback : DiffUtil.ItemCallback<User>() {

    /**
     * Comprueba si dos ítems representan el mismo usuario.
     *`true` si los ítems representan el mismo usuario, `false` en caso contrario.
     */
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }

    /**
     * Comprueba si el contenido de dos ítems es el mismo.
     *
     * `true` si los contenidos de los ítems son iguales, `false` en caso contrario.
     */
    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}
