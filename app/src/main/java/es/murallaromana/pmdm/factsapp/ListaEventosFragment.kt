package es.murallaromana.pmdm.factsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import es.murallaromana.pmdm.factsapp.databinding.FragmentListaEventosBinding

class ListaEventosFragment : Fragment() {

    private lateinit var binding: FragmentListaEventosBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListaEventosBinding.inflate(layoutInflater)

        binding.rvListaEventos.layoutManager = LinearLayoutManager(activity)
        binding.rvListaEventos.setHasFixedSize(true)

        val lista = listOf<Evento>(
            Evento(1, "asd asd asdasd asd asdasd asd asdasd asd asdasd asd asdasd asd asd"),
            Evento(2, "asd asd asdasd asd asdasd asd asdasd asd asdasd asd asdasd asd asd"),
            Evento(3, "asd asd asdasd asd asdasd asd asdasd asd asdasd asd asdasd asd asd")
        )

//        binding.rvListaEventos.adapter = ListaEventosAdapter()

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = ListaEventosFragment()
    }
}