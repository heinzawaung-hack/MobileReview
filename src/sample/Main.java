package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Database.Database;

import java.sql.Connection;
import java.sql.Statement;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Connection connection = Database.getInstance().getConnection();
        //create table for the first time.This is SQlite Statement.
        String createTable = "create table if not exists user(id integer primary key autoincrement, name varchar(20), password varchar(20), gender varchar(10), country varchar(15));";
        Statement statement = connection.createStatement();
        statement.execute(createTable);
        System.out.println("Table Created Successful");

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
        primaryStage.setResizable(false);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
