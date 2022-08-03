package fr.eni.stationaryShop.dal.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcTools {
    static Connection getConnection() throws IOException, SQLException {

        Properties settings = new Properties();
        settings.load(JdbcTools.class.getResourceAsStream("settings.properties"));

        String url = settings.getProperty("url");
        String user = settings.getProperty("user");
        String password = settings.getProperty("password");

        Connection con = DriverManager.getConnection(url, user, password);
        return con;
    }
}
