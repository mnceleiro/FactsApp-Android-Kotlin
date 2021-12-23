package es.murallaromana.pmdm.factsapp.dao

import com.google.gson.Gson
import es.murallaromana.pmdm.factsapp.entities.Evento
import es.murallaromana.pmdm.factsapp.entities.ListaEventos
import java.time.LocalDate

class EventosRestApiDao : RestApiDao() {

    fun getTodosHoy(): List<Evento> {
        val hoy = LocalDate.now()

        return getTodosPorDiaYMes(hoy.dayOfMonth, hoy.monthValue)
    }

    private fun getTodosPorDiaYMes(dia: Int, mes: Int): List<Evento> {
        val url = BASE_URL + "/${mes}/${dia}/events.json"

        // Envio la peticion y guardo el JSON en la variable "resultado"
        val resultado = enviarPeticionGet(url)

        // Transformo la peticion a formato JSON y extraigo solamente el evento
        println(resultado)
        val gson = Gson()
        val listaEventosObjecto: ListaEventos = gson.fromJson(resultado, ListaEventos::class.java)

        return listaEventosObjecto.listaEventos
    }
}