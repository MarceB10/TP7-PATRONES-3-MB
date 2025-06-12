package Ejercicio4.sevicios;

public class EmailSender implements Observador{
    @Override
    public void actualizar(String email, String nombre) {
        System.out.println("Enviando correo a " + email
                + " para el participante " + nombre
                + " con el mensaje: Inscripcion Exitosa.");
    }
}
