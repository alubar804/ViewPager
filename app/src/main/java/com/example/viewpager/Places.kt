package com.example.viewpager


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView


class Places(val imagen:Int, val titulo:String )
class PlacesAdapter(var items: ArrayList<Places>) : RecyclerView.Adapter<PlacesAdapter.TarjViewHolder>() {
    lateinit var onClick : (View) -> Unit

    init {
        this.items = items
    }

    class TarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var laImagen: ImageView

        var tituloView:TextView
        val cancelBoton: Button
        init {
            laImagen=itemView.findViewById(R.id.imageView)
            cancelBoton=itemView.findViewById(R.id.cancel)
            tituloView=itemView.findViewById(R.id.textViewTitulo)

        }

        fun bindTarjeta(t: Places, onClick: (View) -> Unit) = with(itemView) {
            laImagen.setImageResource(t.imagen)

            tituloView.text=t.titulo
            setOnClickListener { onClick(itemView) }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TarjViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.places, viewGroup, false)
        return TarjViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: TarjViewHolder, pos: Int) {
        val item = items.get(pos)
        viewHolder.bindTarjeta(item, onClick)
        viewHolder.cancelBoton.setOnClickListener{
            items.removeAt(viewHolder.adapterPosition)
            notifyItemRemoved(viewHolder.adapterPosition)
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }
}