/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class handles the database connection to the Dagenham database (cusdb)
 * @author Sachith
 */
public class ConnectionFactoryDagenham {

    String driverClassName = "org.apache.derby.jdbc.ClientDriver";
    String connectionUrl = "jdbc:derby://localhost:1527/cusdb";
    String dbUser = "sachith";
    String dbPwd = "cbsd";
    private static ConnectionFactoryDagenham connectionFactory = null;

    private ConnectionFactoryDagenham() {
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
        return conn;
    }

    public static ConnectionFactoryDagenham getInstance() {
        if (connectionFactory == null) {
            connectionFactory = new ConnectionFactoryDagenham();
        }
        return connectionFactory;
    }
}
