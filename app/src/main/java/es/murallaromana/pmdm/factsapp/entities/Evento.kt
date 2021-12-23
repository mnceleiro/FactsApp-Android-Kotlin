package es.murallaromana.pmdm.factsapp.entities

import com.google.gson.annotations.SerializedName

class Evento(
    @SerializedName("year") val anho: Int,
    @SerializedName("description") val descripcion: String
)