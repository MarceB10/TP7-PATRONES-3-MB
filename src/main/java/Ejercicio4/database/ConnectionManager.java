package Ejercicio4.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class ConnectionManager {

    public static final String URL = "jdbc:derby:participantes;create=true";

    private ConnectionManager() {}

    public static Connection getConnection() throws SQLException {
        Locale.setDefault(new Locale("es", "ES"));
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar a la base de datos",e);
        }
    }

    public static void close(Connection conn) {
        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            throw new RuntimeException("Error al cerrar la conexion", e);
        }
    }

    public static void crearTabla() {
        String sql = "CREATE TABLE participantes (" +
                "id INT NOT NULL GENERATED ALWAYS AS IDENTITY, " +
                "nombre VARCHAR(100), " +
                "telefono VARCHAR(20), " +
                "region VARCHAR(50), " +
                "email VARCHAR(100))";

        try (Connection conn = getConnection();
             Statement st = conn.createStatement()) {
            st.executeUpdate(sql);
            System.out.println("Tabla creada exitosamente");
        } catch (SQLException e) {
            System.out.println("La tabla ya existe o error al crearla: " + e.getMessage());
        }
    }

}
