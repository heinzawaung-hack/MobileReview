package sample.Database;

import javafx.scene.control.Alert;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseDAO {
    public void saveData(MobileModel mobileModel) throws SQLException, ClassNotFoundException {
        Database database = Database.getInstance();
        Connection connection = database.getConnection();
        String userName = mobileModel.getUserName();
        String password = mobileModel.getPassword();
        String gender = mobileModel.getGender();
        String country = mobileModel.getCountry();
        String insertData = "insert into user (name,password,gender,country) values (?,?,?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(insertData);
        preparedStatement.setString(1,userName);
        preparedStatement.setString(2,password);
        preparedStatement.setString(3,gender);
        preparedStatement.setString(4,country);
        preparedStatement.executeUpdate();
        System.out.println("Insert Data Success");
    }

    public boolean isUserExists(MobileModel mobileModel) throws SQLException, ClassNotFoundException {
        Database database = Database.getInstance();
        Connection connection = database.getConnection();
        String userName = mobileModel.getUserName();
        String password = mobileModel.getPassword();
        String retrieveData = "select * from user where name=? and password=?;";
        PreparedStatement preparedStatement = connection.prepareStatement(retrieveData);
        preparedStatement.setString(1,userName);
        preparedStatement.setString(2,password);
        ResultSet resultSet = preparedStatement.executeQuery();
        int count = 0;
        while (resultSet.next()){
            count = +1;
        }
        if (count == 1){
            System.out.println("Log In Success");
            return true;
        }else {

            return false;
        }
    }

    public List<MobileModel> getAllData() throws SQLException, ClassNotFoundException {
        Database database = Database.getInstance();
        Connection connection = database.getConnection();
        String retrieve = "select * from user";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(retrieve);
        List<MobileModel> modelList = new ArrayList<>();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String userName = resultSet.getString("name");
            String password = resultSet.getString("password");
            String gender = resultSet.getString("gender");
            String country = resultSet.getString("country");
            MobileModel mobileModel = new MobileModel(id,userName,password,gender,country);
            modelList.add(mobileModel);
        }
        return modelList;
    }
}
