package presencial;

import java.sql.*;

public class Main {

    // creamos la variable de tipo string con el comando sql de creacion de la tabla
    private static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS ANIMALS; CREATE TABLE ANIMALS ("
        + " ID INT PRIMARY KEY,"
            + " NOMBRE VARCHAR (100) NOT NULL,"
            + " TIPO VARCHAR (100) NOT NULL)";

    // creamos la variable de tipo string con el comando sql para la insercion de datos nuevos en la tabla
    private static final String SQL_INSERT_1 = "INSERT INTO ANIMALS (ID, NOMBRE, TIPO) VALUES " +
            "(1, 'Pancho', 'Perro')";
    private static final String SQL_INSERT_2 = "INSERT INTO ANIMALS (ID, NOMBRE, TIPO) VALUES " +
            "(2, 'Don', 'Gato')";
    private static final String SQL_INSERT_3 = "INSERT INTO ANIMALS (ID, NOMBRE, TIPO) VALUES " +
            "(3, 'Suegra', 'Vibora')";
    private static final String SQL_INSERT_4 = "INSERT INTO ANIMALS (ID, NOMBRE, TIPO) VALUES " +
            "(4, 'Ico', 'Caballo')";
    private static final String SQL_INSERT_5 = "INSERT INTO ANIMALS (ID, NOMBRE, TIPO) VALUES " +
            "(5, 'Bunny', 'Conejo')";

    // CREAMOS LA SENTENCIA DE SQL PARA CONSULTAR LA BASE
    private static final String SQL_SELECT = "SELECT * FROM ANIMALS";

    //pruebas para usar la base de datos h2
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //conectarnos a una base de datos de h2
        // tenemos que seguir cierta sintaxis
        // buscamos los drivers
        Class.forName("org.h2.Driver");
        // hacer la conexion. Crear objeto de tipo conexion (url-direccion- usuario BdD- constraseña BdD)
        // aquel que invoca por primera vez, crea la base de datos
        Connection connection= DriverManager.getConnection(
                "jdbc:h2:~/clase11", "sa", "sa");

        //ya realizamos la conexion a la base
        // creamos el objeto statement, creamos con el metodo create statement
        Statement statement = connection.createStatement();

        // ejecutamos el statament con comandos de sql, llamando la variable que creamos antes
        statement.execute(SQL_CREATE_TABLE);

        // llamamos los comandos de sql para agregar la base. insertamos cinco mascotas.
        statement.execute(SQL_INSERT_1);
        statement.execute(SQL_INSERT_2);
        statement.execute(SQL_INSERT_3);
        statement.execute(SQL_INSERT_4);
        statement.execute(SQL_INSERT_5);

        // tenemos que mostrar la info, que esta en sql, pasarla a java para poder verla. Utilizamos execute
        // query para poder verla. hacemos la consulta, no modificamos la tabla.
        ResultSet rs= statement.executeQuery(SQL_SELECT);

        //recorremos el resultset a traves de un while
        while (rs.next()){
            System.out.println(rs.getInt(1) + " -- " + rs.getString(2)+ " -- " + rs.getString(3));
        }

    }
}
