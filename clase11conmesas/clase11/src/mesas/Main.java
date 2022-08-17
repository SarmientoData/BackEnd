package mesas;

import java.sql.*;

public class Main {
    private static final String SQL_CREATE_TABLE="DROP TABLE IF EXISTS FIGURAS; CREATE TABLE" +
            " FIGURAS ("
            +" ID INT PRIMARY KEY,"
            +" FIGURA VARCHAR(100) NOT NULL,"
            +" COLOR VARCHAR(100) NOT NULL)";
    private static final String SQL_INSERT_1="INSERT INTO FIGURAS (ID, FIGURA, COLOR) VALUES " +
            "(1,'circulo', 'rojo')";
    private static final String SQL_INSERT_2="INSERT INTO FIGURAS (ID, FIGURA, COLOR) VALUES " +
            "(2,'circulo', 'naranja')";
    private static final String SQL_INSERT_3="INSERT INTO FIGURAS (ID, FIGURA, COLOR) VALUES " +
            "(3,'cuadrado', 'verde')";
    private static final String SQL_INSERT_4="INSERT INTO FIGURAS (ID, FIGURA, COLOR) VALUES " +
            "(4,'cuadrado', 'azul')";
    private static final String SQL_INSERT_5="INSERT INTO FIGURAS (ID, FIGURA, COLOR) VALUES " +
            "(5,'cuadrado', 'negro')";
    private static final String SQL_SELECT_CIRCULOS_ROJOS="SELECT * FROM FIGURAS WHERE FIGURA='circulo' AND COLOR='rojo'";
    private static final String SQL_SELECT_TODOS="SELECT * FROM FIGURAS";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        Connection connection= DriverManager.getConnection(
                "jdbc:h2:~/clase11","sa","sa");
        Statement statement= connection.createStatement();
        statement.execute(SQL_CREATE_TABLE);
        statement.execute(SQL_INSERT_1);
        statement.execute(SQL_INSERT_2);
        statement.execute(SQL_INSERT_3);
        statement.execute(SQL_INSERT_4);
        statement.execute(SQL_INSERT_5);
        ResultSet rs=statement.executeQuery(SQL_SELECT_CIRCULOS_ROJOS);
        while (rs.next()){
            System.out.println(rs.getInt(1)+"-"+rs.getString(2)+"-"+
                    rs.getString(3));
        }
        //pueden usar el mismo rs pero se recomienda usar otro por si necesitan tener el anterior
        System.out.println("***-----------------------------------***");
        ResultSet rs2=statement.executeQuery(SQL_SELECT_TODOS);
        while (rs2.next()){
            System.out.println(rs2.getInt(1)+"-"+rs2.getString(2)+"-"+
                    rs2.getString(3));
        }

    }
}
