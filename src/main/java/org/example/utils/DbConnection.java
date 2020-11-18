package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

public class DbConnection {

    private String url;
    private Properties connectionProps;

    public DbConnection(Map<String,String> dbParams){
        connectionProps = new Properties();
        connectionProps.put("user", dbParams.get("userName"));
        connectionProps.put("password", dbParams.get("password"));
        url = dbParams.get("url");
    }

    public Connection getConection() throws SQLException {
        Connection connection = null;
        connection = DriverManager.getConnection(url, connectionProps);
        return connection;
    }
}
