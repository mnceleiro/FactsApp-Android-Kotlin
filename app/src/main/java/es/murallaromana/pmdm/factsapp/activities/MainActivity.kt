package es.murallaromana.pmdm.factsapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import es.murallaromana.pmdm.factsapp.R
import es.murallaromana.pmdm.factsapp.fragments.ListaEventosFragment
import es.murallaromana.pmdm.factsapp.utils.FechaUtils
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = generarTituloConFechaActual()

        mostrarFragmentListaEventos()
    }

    private fun generarTituloConFechaActual() = "Eventos del ${FechaUtils.getFechaLargaHoySinAnho()}"

    private fun mostrarFragmentListaEventos() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, ListaEventosFragment.newInstance())
            .commit()
    }
}