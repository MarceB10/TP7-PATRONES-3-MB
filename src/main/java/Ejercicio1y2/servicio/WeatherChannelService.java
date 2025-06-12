package Ejercicio1y2.servicio;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherChannelService implements ClimaOnline {
    private String apiKey;

    public WeatherChannelService(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public String temperatura() {
        try {
            String endpoint = "https://api.openweathermap.org/data/2.5/weather?q=Viedma,Argentina&units=metric&APPID=" + apiKey;
            URL url = new URL(endpoint);//construyo la URL
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();//abro la conexion
            conn.setRequestMethod("GET");//tipo de peticion

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));//leo la respuesta del servidor
            StringBuilder responseJson = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                responseJson.append(line);
            }

            br.close();//cierro el buffer

            JSONObject json = new JSONObject(responseJson.toString());//parseo la respuesta a un objeto JSON
            double temp = json.getJSONObject("main").getDouble("temp");//obtengo la temperatura, de aca solo saco la temperatura
            return temp + " °C";

        }catch (Exception e) {
            return "Error al consultar la temperatura: " + e.getMessage();
        }
    }
}