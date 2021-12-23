package es.murallaromana.pmdm.factsapp.entities

import com.google.gson.annotations.SerializedName

class ListaEventos(
    var wikipedia: String,
    @SerializedName("date") var fecha: String,
    @SerializedName("events") var listaEventos: List<Evento>
) {
}