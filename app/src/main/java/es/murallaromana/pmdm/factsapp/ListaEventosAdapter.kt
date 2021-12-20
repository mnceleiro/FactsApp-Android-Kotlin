package es.murallaromana.pmdm.factsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import es.murallaromana.pmdm.factsapp.databinding.ItemEventoBinding

class ListaEventosAdapter(val listaEventos: List<Evento>, val context: Context)
    : RecyclerView.Adapter<ListaEventosAdapter.EventosViewHolder>() {

    class EventosViewHolder(val binding: ItemEventoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun enlazarDatos(evento: Evento) {
            binding.tvListaEventosAnho.setText(evento.anho)
            binding.tvListaEventosDescripcion.setText(evento.descripcion)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventosViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return EventosViewHolder(ItemEventoBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: EventosViewHolder, position: Int) {
        holder.enlazarDatos(listaEventos[position])
    }

    override fun getItemCount(): Int = listaEventos.size
}