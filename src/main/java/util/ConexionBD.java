package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionBD {
    // Definimos los parámetros de conexión a la BBDD
    private static final String url = "jdbc:postgresql://127.0.0.1:5432/jardineria"; // jdbc:nombre driver://ip:puerto/nombre base datos
    private static final String user = "jardinera"; // Usuario BD
    private static final String password = "jardinera"; //contraseña
    // el método debe devolver una variable de tipo Connection que sera utilizada por el código que llama
    private static Connection conex;

    public static Connection crearConexion() throws SQLException {

        if (conex == null || conex.isClosed()) {
            conex = DriverManager.getConnection(url, user, password);
        }
        return conex;
    }
    public static void CerrarConexion() throws SQLException {
        if (conex != null && !conex.isClosed()) {
            conex.close();
            conex = null;
        }
    }

}
