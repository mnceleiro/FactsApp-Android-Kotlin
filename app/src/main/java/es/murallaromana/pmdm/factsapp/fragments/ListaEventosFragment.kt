package es.murallaromana.pmdm.factsapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import es.murallaromana.pmdm.factsapp.adapters.ListaEventosAdapter
import es.murallaromana.pmdm.factsapp.databinding.FragmentListaEventosBinding
import es.murallaromana.pmdm.factsapp.entities.Evento
import androidx.recyclerview.widget.DividerItemDecoration




class ListaEventosFragment : Fragment() {

    private lateinit var binding: FragmentListaEventosBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentListaEventosBinding.inflate(layoutInflater)

        // Lista de datos mockeados (lista de eventos)
        val listaEventos = listOf(
            Evento(1521, "Incendio en Oviedo que destruye tres cuartas partes de la ciudad e imposición posterior de construcción de las casas en piedra."),
            Evento(1836, "Las fuerzas liberales del general Espartero ponen fin al segundo sitio de Bilbao, provocando la desbandada del ejército carlista."),
            Evento(1968, "El módulo de mando del Apolo VIII entra en órbita lunar como ensayo previo al envío del primer hombre a su superficie.")
        )

        // Creación de elementos para usar en el RecyclerView
        val layoutManager = LinearLayoutManager(activity)
        val dividerItemDecoration = DividerItemDecoration(activity, layoutManager.orientation)
        val adapter = ListaEventosAdapter(listaEventos, activity as AppCompatActivity)

        // Enlazamos el recyclerview con los elementos anteriores
        binding.rvListaEventos.layoutManager = layoutManager
        binding.rvListaEventos.addItemDecoration(dividerItemDecoration)
        binding.rvListaEventos.setHasFixedSize(true)
        binding.rvListaEventos.adapter = adapter

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = ListaEventosFragment()
    }
}