import util.ConexionBD;

import java.sql.*;

public class Paso1 {
    public static void main(String[] args) throws SQLException {

        // CONSULTAS A REALIZAR INTRODUCIDAS EN VARIABLES TIPO STRING

        String consulta1 = "SELECT * FROM cliente";
        //Ejercicio 7
        String consulta7 = """
        select c.nombre_cliente, e.nombre, o.ciudad, count(*) As cantidad
        from cliente c
        inner join empleado e on c.codigo_empleado_rep_ventas = e.codigo_empleado
        inner join oficina o on e.codigo_oficina = o.codigo_oficina
        group by c.nombre_cliente, e.nombre, o.ciudad
        having count(*) > 1""";
        //Ejercicio 8
        String consulta8 = """
        select e.nombre, j.nombre As jefe
        from empleado e
        inner join empleado j on e.codigo_jefe = j.codigo_empleado""";
        //Ejercicio 9
        String consulta9 = """
        select e.nombre as empleado, j.nombre as jefe, jj.nombre as jefe_del_jefe
        from empleado e
        inner join empleado j on e.codigo_jefe = j.codigo_empleado
        inner join empleado jj on j.codigo_jefe = jj.codigo_empleado""";
        //Ejercicio 10
        String consulta10 = """
        select c.nombre_cliente, p.fecha_entrega, p.fecha_esperada
        from cliente c
        inner join pedido p on c.codigo_cliente = p.codigo_cliente
        where p.fecha_entrega > p.fecha_esperada""";
        //Ejercicio 11
        String consulta11 = """
        select distinct p.gama
        from producto p
        inner join detalle_pedido d on p.codigo_producto = d.codigo_producto""";

        // Dentro de los paréntesis en un try-catch con recursos añadimos conexión, Statemen y resultado
        // Creamos la instancia de la conexión a la BBDD
        // Generamos una instancia de sentencia para poder enviar consultas al servidor de BBDD
        // definimos la consulta, la enviamos al servidor (ejecutamos la sentencia) y obtenemos el resultado devuelto por el servidor
        // En el ResulSet tenemos todos los registros devueltos por el servidor dentro de un iterador
        Connection conex = ConexionBD.crearConexion(); // extraigo la conexión para que no se cierre y sea null
        try (//Connection conex = ConexionBD.Creaconexion(); // llama a conexionBD
             Statement st = conex.createStatement();
             ResultSet rs = st.executeQuery(consulta7); // introduces la consulta deseada
             ) {
            // Obtiene los metadatos para saber cuántas columnas tiene la consulta
            ResultSetMetaData meta = rs.getMetaData();
            int columnas = meta.getColumnCount();

            // Establece un ancho fijo para las columnas (se puede ajustar a tu gusto)
            int anchoCol = 35;

            // Imprime cabeceras con formato
            for (int i = 1; i <= columnas; i++) {
                System.out.printf("%-" + anchoCol + "s", meta.getColumnLabel(i));
            }
            System.out.println();

            // Línea separadora
            System.out.println("-".repeat(anchoCol * columnas));

            // Imprime los datos con formato
            while (rs.next()) {
                for (int i = 1; i <= columnas; i++) {
                    System.out.printf("%-" + anchoCol + "s", rs.getString(i));
                }
                System.out.println();
            }
            ConexionBD.CerrarConexion();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
