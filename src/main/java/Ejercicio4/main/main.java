package Ejercicio4.main;


import Ejercicio4.database.ConnectionManager;
import Ejercicio4.database.RegistroParticipanteImpl;
import Ejercicio4.model.Participante;
import Ejercicio4.model.Participantes;
import Ejercicio4.sevicios.EmailSender;
import Ejercicio4.ui.VentanaAgregarParticipante;

import java.awt.*;
import java.sql.SQLException;

class main {
    public static void main(String[] args) throws SQLException {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ConnectionManager.crearTabla();
                    Participantes participantesService = new Participantes(new RegistroParticipanteImpl());
                    participantesService.agregarObserver(new EmailSender());
                    new VentanaAgregarParticipante(participantesService);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }
}