/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class handles the database connection to the Stratford database (StratfordDB)
 * @author Sachith
 */
public class ConnectionFactoryStratford {

    String driverClassName = "org.apache.derby.jdbc.ClientDriver";
    String connectionUrl = "jdbc:derby://localhost:1527/StratfordDB";
    String dbUser = "admin";
    String dbPwd = "password";
    private static ConnectionFactoryStratford connectionFactory = null;

    private ConnectionFactoryStratford() {
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

    public static ConnectionFactoryStratford getInstance() {
        if (connectionFactory == null) {
            connectionFactory = new ConnectionFactoryStratford();
        }
        return connectionFactory;
    }
}
