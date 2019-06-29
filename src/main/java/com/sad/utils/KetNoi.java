package com.sad.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KetNoi {

    private static Connection connection(String classForName, String url, String username, String password) {
        try {
            Class.forName(classForName);
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Connection HYPER() {
        final String classForName = "org.hsqldb.jdbc.JDBCDriver",
                //url = "jdbc:hsqldb:hsql://localhost:9001",
                url = "jdbc:hsqldb:hsql://ilink.dhsptn.edu.vn:9001",
               // url = "jdbc:hsqldb:hsql://primo.ted.com.vn:9001",
                username = "SA",
                password = "";
        return connection(classForName, url, username, password);
    }

    public static Connection ORACLE() {
        final String classForName = "oracle.jdbc.driver.OracleDriver",
                url = "jdbc:oracle:thin:@catalog.dhsptn.edu.vn:1521:aleph23",
                // url = "jdbc:oracle:thin:@192.168.1.118:1521:aleph23",
                username = "tedadmin",
                password = "tedprodba9102";
        return connection(classForName, url, username, password);
    }
}
