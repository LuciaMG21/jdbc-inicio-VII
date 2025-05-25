import java.sql.*;

public class Paso1 {
    public static void main(String[] args) {
        // Definimos los parámetros de conesión a la BBDD
        String url = "jdbc:postgresql://127.0.0.1:5432/jardineria"; // jdbc:nombre driver://ip:puerto/nombre base datos
        String user = "jardinero"; // Usuario BD
        String password = "12345"; //contraseña

        try {
            // Creamos la instancia de la conexión a la BBDD
            Connection conex = DriverManager.getConnection(url, user, password);
            // Creamos una instancia de sentencia para poder enviar consultas al servidor de BBDD
            Statement st = conex.createStatement();
            // definimos la consulta, la enviamos al servidor (ejecutamos la sentencia) y obtenemos el resultado devuelto por el servidor
            ResultSet rs = st.executeQuery("SELECT * FROM cliente");
            // En el ResulSet tenemos todos los registros devueltos por el servidor dentro de un iterador
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2));
            }
            // se cierran en orden inverso a su creación
            rs.close();
            st.close();
            conex.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
