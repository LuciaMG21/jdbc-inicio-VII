import modelos.Empleados;
import repositorios.EmpleadoRepo;

import java.sql.*;
import java.util.List;

public class Paso1 {
    public static void main(String[] args) throws SQLException {

        EmpleadoRepo repoEmpl = new EmpleadoRepo();
        System.out.println("-------------- Lista de empleados---------------");
        List<Empleados> listEmpleados = repoEmpl.listarEmpleados();
        for (Empleados emp : listEmpleados) {
            System.out.println(emp.toString());
        }
    }
}
