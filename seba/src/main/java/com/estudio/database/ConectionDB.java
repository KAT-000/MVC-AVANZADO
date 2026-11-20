package com.estudio.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConectionDB {

    private static final String URL = "jdbc:oracle:thin:@//localhost:1521/FREEPDB1";
    private static final String USER = "usuario_desarrollador";
    private static final String PASS = "123456";
    
    public static Connection obtenerConexion() throws SQLException {

        return DriverManager.getConnection(URL, USER, PASS);

    }
}
