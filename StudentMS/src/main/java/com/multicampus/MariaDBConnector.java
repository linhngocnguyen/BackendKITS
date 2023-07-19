package com.multicampus;

import java.sql.*;

public class MariaDBConnector {

    private Connection conn = null;

    public MariaDBConnector(String host, int port, String database, String user, String password) throws SQLException {
        String url = "jdbc:mariadb://" + host + ":" + port + "/" + database;
        conn = DriverManager.getConnection(url, user, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }

    public void close() throws SQLException {
        conn.close();
    }
}
