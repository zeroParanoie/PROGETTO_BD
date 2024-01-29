package engClasses;

import java.sql.*;
import java.io.*;
import java.util.Properties;

import model.role;
public class ConnectionFactory {
    private static Connection connection;

    private ConnectionFactory() {}

    static {
        try (InputStream input = new FileInputStream("src/db.properties")) {
            Properties properties = new Properties();
            properties.load(input);

            String connection_url = properties.getProperty("CONNECTION_URL");
            String user = properties.getProperty("LOGIN_USER");
            String pass = properties.getProperty("LOGIN_PASSWORD");

            connection = DriverManager.getConnection(connection_url, user, pass);
        } catch(IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return connection;
    }

    public static void changeRole(role Role) throws SQLException {
        connection.close();

        try (InputStream input = new FileInputStream("src/db.properties")) {
            Properties properties = new Properties();
            properties.load(input);

            String connection_url = properties.getProperty("CONNECTION_URL");
            String user = properties.getProperty(Role.name() + "_USER");
            String pass = properties.getProperty(Role.name() + "_PASSWORD");

            connection = DriverManager.getConnection(connection_url,user,pass);
        } catch(IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
