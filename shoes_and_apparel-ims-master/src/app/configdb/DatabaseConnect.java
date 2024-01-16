package app.configdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnect extends Config{
    public Connection ConnectDB(){
        try {
            Class.forName(DRIVER);
            connect = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
           System.out.println(e);
        }
    return null;
    }
}
