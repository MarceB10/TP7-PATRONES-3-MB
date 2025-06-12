package Ejercicio4.model;

import Ejercicio4.sevicios.EmailSender;
import Ejercicio4.sevicios.Observador;

import java.util.ArrayList;
import java.util.List;

public class Participantes {
    private RegistroParticipantes registroDeParticipantes;
    private List<Observador> observers;

    public Participantes(RegistroParticipantes registroDeParticipantes) {
        this.registroDeParticipantes = registroDeParticipantes;
        this.observers = new ArrayList<>();
    }

    public void nuevoParticipante(String nombre, String telefono, String region, String email) {
        var participante = new Participante(nombre, telefono, region, email);
        System.out.println("Nuevo participante agregado: " + nombre);
        this.registroDeParticipantes.registrar(participante);
        this.notificar(participante);
    }

    public void agregarObserver(Observador observer) {
        this.observers.add(observer);
    }

    private void notificar(Participante participante) {
        for (Observador observer : observers) {
            observer.actualizar(participante.getEmail(), participante.getNombre());
        }
    }
}
