package com.my.common.dbconnection;

import java.sql.*;

public class OracleDBConnection {

    private static Connection con;

    private static final String dbURL = "dbURL";
    private static final String username = "username";
    private static final String password = "password";

    private static Connection getConnection() {
        try {
            if (con == null) {
                createConnection();
            } else if (con.isClosed()) {
                createConnection();
            }
        } catch (Exception e) {
            System.out.println("Database Connection Creation Failed : " + e.getMessage());
        }
        return con;
    }

    private static synchronized void createConnection() {
        try {
            if (con != null && !con.isClosed()) {
                return;
            }
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(dbURL, username, password);
        } catch (Exception e) {
            System.out.println("Database Connection Creation Failed : " + e.getMessage());
        }
    }

    public static PreparedStatement getPrepareStatement(final String sql) {
        try {
            return getConnection().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Long generatedKey(final String tableName) {
        try {
            final PreparedStatement pstmt = getConnection().prepareStatement("select max(id) from " + tableName);
            final ResultSet rs = pstmt.executeQuery();
            Long generatedKey = null;
            if (rs.next()) {
                generatedKey = rs.getLong(1);
            }
            return generatedKey;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
