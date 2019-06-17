package com.dbimpl.dbwiscops.dao;

import java.sql.*;

public class DbAdapter {
    /*- 01 Variables ---------------- */
    String jdbUrl = "jdbc:postgresql://localhost:5432/dbwiscops";
    String username = "postgres";
    String password = "postgres";

    /*- 02 Database Variables ---------------- */
    public Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    /*
    Connect to Database
     */
    public void connect () {
        // Connect to database
        try {
            conn = DriverManager.getConnection(jdbUrl, username, password);

            // Print success message
            System.out.println("Database connection established");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } // connect

    public Connection getConn() {
        return conn;
    }

    /*
        Disconnect from database
         */
    public void disconnect() {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    } // disconnect
}
