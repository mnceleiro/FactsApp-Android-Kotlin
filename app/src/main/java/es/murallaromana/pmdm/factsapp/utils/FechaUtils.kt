package es.murallaromana.pmdm.factsapp.utils

import java.time.LocalDate
import java.time.format.TextStyle
import java.util.*

object FechaUtils {

    /**
     * Genera una fecha en formato: "Mes" de "Anho" con el lenguaje del dispositivo.
     *
     * @return fecha como string sin el año. Por ejemplo: diciembre de 2021, october of 2018...
     */
    fun getFechaLargaHoySinAnho(): String {
        val fechaHoy = LocalDate.now()

        return "${fechaHoy.dayOfMonth} de ${fechaHoy.month.getDisplayName(TextStyle.FULL, Locale.getDefault())}"
    }
}