package repositorios;

import modelos.Oficina;
import util.ConexionBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OficinaRepo {

    private static final String LISTAR_OFICINAS = "SELECT * FROM oficina";

    private Connection obtenerConexion() throws SQLException {
        return ConexionBD.crearConexion();
    }

    private Statement obtenerSentencia() throws SQLException {
        return obtenerConexion().createStatement();
    }

    public List<Oficina> listarOficinas() {
        // Creamos la variable que contendrá los datos de las oficinas
        List<Oficina> oficinas = new ArrayList<>();
        // ejecutamos la consulta dentro de un try con recursos para asegurarnos el cierre de estos
        try(Statement stmt = obtenerSentencia();
            ResultSet rs = stmt.executeQuery(LISTAR_OFICINAS)) {
            // Recorremos el Resultset ara asignar cada registro a una oficina
            while (rs.next()) {
                Oficina oficina = new Oficina();
                oficina.setCodigoOficina(rs.getString("codigo_oficina"));
                oficina.setCiudad(rs.getString("ciudad"));
                oficina.setPais(rs.getString("pais"));
                oficina.setRegion(rs.getString("region"));
                oficina.setCodigoPostal(rs.getString("codigo_postal"));
                oficina.setTelefono(rs.getString("telefono"));
                oficina.setLineaDireccion1(rs.getString("linea_direccion1"));
                oficina.setLineaDireccion2(rs.getString("linea_direccion2"));
                oficinas.add(oficina);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return oficinas;
    }
}
