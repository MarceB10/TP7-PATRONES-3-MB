package Ejercicio1y2.Observadores;

import java.io.PrintWriter;
import java.time.LocalDate;

public class RegistradorTemperatura implements ObserverTemperatura{
    private String archivo = "src/main/java/Ejercicio1y2/archivo/temperatura.txt";

    @Override
    public void updateTemperatura(String temperatura) {
        try (PrintWriter writer = new PrintWriter(archivo)) {
            writer.println("Temperatura actual: " + temperatura + " - en la fecha: " + LocalDate.now());
        } catch (Exception e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
