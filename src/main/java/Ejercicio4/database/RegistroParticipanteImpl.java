package Ejercicio4.database;


import Ejercicio4.model.Participante;
import Ejercicio4.model.RegistroParticipantes;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegistroParticipanteImpl implements RegistroParticipantes {

    private static final String INSERTAR_PARTICIPANTE = "INSERT INTO participantes(nombre, telefono, region, email) VALUES(?,?,?,?)";
    private String url;
    private String user;
    private String password;

    public RegistroParticipanteImpl() {}


    public RegistroParticipanteImpl(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public void registrar(Participante participante) {
        try ( Connection conn = ConnectionManager.getConnection()){

            PreparedStatement st = conn.prepareStatement(INSERTAR_PARTICIPANTE);

            st.setString(1, participante.getNombre());
            st.setString(2, participante.getTelefono());
            st.setString(3, participante.getRegion());
            st.setString(4, participante.getEmail());
            st.executeUpdate();
            System.out.println("Registro exitoso");

        }
        catch (Exception e) {
            System.err.println("ERROR SQL:");
            throw new RuntimeException("Algo se rompio", e);
        }
    }

}
