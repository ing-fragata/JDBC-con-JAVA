import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;


public class Main {
    public static void main (String[] args) {

        String url = "jdbc:mysql://localhost:3306/ga7-220501096-aa2-ev01";
        String user = "root";
        String password = "";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {

            //Cargar y registrar el driver JDBC de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Establecer la conexión a la base de datos
            connection = DriverManager.getConnection(url, user, password);

            //Crear un Statement para ejecutar consultas SQL
            statement = connection.createStatement();

            //para insert, delete, update y para create table, drop table usamos statement.executeUpdate
            /*String insertar = "INSERT INTO evidencia1 (cedula, nombre, apellido) VALUES (123456, 'Zammael', 'Henao')";
            statement.executeUpdate(insertar);
            String eliminar = "DELETE FROM evidencia1 where nombre = 'Llerad'";
            statement.executeUpdate(eliminar);
            String actualizar = "UPDATE evidencia1 SET apellido = 'Henao' WHERE nombre = 'Llerad' ";
            statement.executeUpdate(actualizar);*/

            //Ejecutar una consulta SQL tipo select
            String consulta = "SELECT * FROM evidencia1";
            resultSet = statement.executeQuery(consulta);

            while (resultSet.next()) {
                int cedula = resultSet.getInt("cedula");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                System.out.println("la cedula es: " + cedula + "el nombre es " + nombre + " " + apellido);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } finally {
            // Cerrar el ResultSet
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            // Cerrar el Statement
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            // Cerrar la Connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}