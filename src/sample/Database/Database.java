package sample.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Database database;
    private Connection connection;
    private String url = "jdbc:sqlite:userdb";

    Database() throws SQLException {
        connect();
    }

    public static Database getInstance() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        if (database == null){
            database = new Database();
        }
        return database;
    }

    public void connect() {
        try {
            connection = DriverManager.getConnection(url);
            System.out.println("Connected to SQLite Database");
        } catch (SQLException e) {
            System.out.println("Can't connect to Database");
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return connection;
    }
}
