package Ejercicio1y2;

import Ejercicio1y2.Observado.Medidor;
import Ejercicio1y2.Observadores.ConsoleTemperatura;
import Ejercicio1y2.Observadores.RegistradorTemperatura;
import Ejercicio1y2.servicio.ClimaOnline;
import Ejercicio1y2.servicio.WeatherChannelService;

public class main {
    public static void main(String[] args) {
        ClimaOnline clima = new WeatherChannelService("603baf60189cdb8af361473125dd9d9a");
        Medidor medidor = new Medidor(clima);

        medidor.agregarObservador(new ConsoleTemperatura());
        medidor.agregarObservador(new RegistradorTemperatura());

        medidor.leerTemperatura();

    }
}
