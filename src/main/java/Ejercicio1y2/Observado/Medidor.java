package Ejercicio1y2.Observado;

import Ejercicio1y2.Observadores.ObserverTemperatura;
import Ejercicio1y2.servicio.ClimaOnline;

import java.util.ArrayList;
import java.util.List;

public class Medidor {
    private List<ObserverTemperatura> observers;
    private String temperatura;
    private ClimaOnline clima;

    public Medidor(ClimaOnline clima) {
        this.clima = clima;
        this.observers = new ArrayList<>();
    }

    public void agregarObservador(ObserverTemperatura observer) {
        this.observers.add(observer);
    }

    private void notificarObservadores() {
        for (ObserverTemperatura observer : observers) {
            observer.updateTemperatura(temperatura);
        }
    }

    public void leerTemperatura() {
        this.temperatura = this.clima.temperatura();
        this.notificarObservadores();
    }
}