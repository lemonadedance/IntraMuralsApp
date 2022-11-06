package com.uni.datautils;

import com.uni.exceptions.DatabaseConnectionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    public static Connection getConnection(){
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?user=postgres&password=mysecretpassword");
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DatabaseConnectionException();
        }
    };
}
