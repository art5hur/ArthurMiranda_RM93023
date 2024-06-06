package br.com.fiap.arthurmiranda_rm93023.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.arthurmiranda_rm93023.R
import br.com.fiap.arthurmiranda_rm93023.model.Praia


class PraiaAdapter : RecyclerView.Adapter<PraiaAdapter.ItemViewHolder>() {

    private val items = mutableListOf<Praia>()

    fun addItem(newItem: Praia) {
        items.add(newItem)
        notifyDataSetChanged()
    }

    fun removeItem(item: Praia) {
        items.remove(item)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_praia, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewNomePraia = view.findViewById<TextView>(R.id.textViewNomePraia)
        val textViewCidade = view.findViewById<TextView>(R.id.textViewCidade)
        val textViewEstado = view.findViewById<TextView>(R.id.textViewEstado)

        val button = view.findViewById<ImageButton>(R.id.imageButton)

        fun bind(item: Praia) {
            textViewNomePraia.text = item.nome
            textViewCidade.text = item.cidade
            textViewEstado.text = item.estado

            button.setOnClickListener {
                item.onRemove(item)
            }
        }
    }
}


