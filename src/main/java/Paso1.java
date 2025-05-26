import modelos.Empleados;
import modelos.Oficina;
import repositorios.EmpleadoRepo;
import repositorios.OficinaRepo;

import java.sql.*;
import java.util.List;

public class Paso1 {
    public static void main(String[] args) throws SQLException {

        EmpleadoRepo repoEmpl = new EmpleadoRepo();
        OficinaRepo repoOficina = new OficinaRepo();

        System.out.println("-------------- Lista de empleados---------------");
        List<Empleados> listEmpleados = repoEmpl.listarEmpleados();
        for (Empleados emp : listEmpleados) {
            System.out.println(emp.toString());
        }
        System.out.println("-------------- Lista de oficinas--------------");
        List<Oficina> listaOfis = repoOficina.listarOficinas();
        for (Oficina oficina : listaOfis) {
            System.out.println(oficina.toString());
        }
    }
}
