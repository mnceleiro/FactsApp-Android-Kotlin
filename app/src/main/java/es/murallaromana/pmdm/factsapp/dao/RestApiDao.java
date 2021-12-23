package es.murallaromana.pmdm.factsapp.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public abstract class RestApiDao {

    protected static String BASE_URL = "https://byabbe.se/on-this-day";

    protected String enviarPeticionGet(String url) throws IOException {
        URL objetoUrl = new URL(url);

        // Creo una conexión a la URL remota
        HttpURLConnection conexion = (HttpURLConnection) objetoUrl.openConnection();

        // Establezco el metodo (GET) y un navegador
        conexion.setRequestMethod("GET");
        conexion.setRequestProperty("User-Agent", "Mozilla/5.0");

        int codigoRespuesta = conexion.getResponseCode();
        System.out.println("Código de respuesta: " + codigoRespuesta);

        // Si la conexion se realiza correctamente (200 OK) muestro por pantalla
        if (codigoRespuesta == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Imprimo el resultado
            return response.toString();

        } else {
            throw new RuntimeException("Peticion fallida a: " + url + ". Código: " + codigoRespuesta);
        }
    }
}
