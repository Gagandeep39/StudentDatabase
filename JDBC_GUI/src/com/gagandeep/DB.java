package com.gagandeep;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    static Connection con = null;
    public static Connection getConnection() {
        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/demo?useSSL=false", "root", "123456");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void closeConnection(){
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
