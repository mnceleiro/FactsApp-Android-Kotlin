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
import es.murallaromana.pmdm.factsapp.dao.EventosRestApiDao


class ListaEventosFragment : Fragment() {

    private lateinit var binding: FragmentListaEventosBinding

    private lateinit var eventosDao: EventosRestApiDao
    private lateinit var adapter: ListaEventosAdapter
    private lateinit var listaEventos: List<Evento>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentListaEventosBinding.inflate(layoutInflater)

        // Lista de datos (lista de eventos) y creacion del adapter
        eventosDao = EventosRestApiDao()

        // Creación de elementos para usar en el RecyclerView
        val layoutManager = LinearLayoutManager(activity)
        val dividerItemDecoration = DividerItemDecoration(activity, layoutManager.orientation)

        // Enlazamos el recyclerview con los elementos anteriores
        binding.rvListaEventos.layoutManager = layoutManager
        binding.rvListaEventos.addItemDecoration(dividerItemDecoration)
        binding.rvListaEventos.setHasFixedSize(true)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val t1 = Thread {
            listaEventos = eventosDao.getTodosHoy()

            // No podemos actualizar las vistas en un thread diferente o saltara excepcion
            activity?.runOnUiThread {
                val adapter = ListaEventosAdapter(listaEventos, activity as AppCompatActivity)
                binding.rvListaEventos.adapter = adapter
            }
        }

        t1.start()
    }

    companion object {
        @JvmStatic
        fun newInstance() = ListaEventosFragment()
    }
}