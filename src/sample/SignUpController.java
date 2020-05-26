package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import sample.Database.DatabaseDAO;
import sample.Database.MobileModel;
import sample.Tools.Messages;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {

    public JFXTextField userNameField;
    public JFXPasswordField passwordField;
    public JFXRadioButton maleRadio;
    public JFXRadioButton femaleRadio;
    public ToggleGroup GenderGroup;
    public JFXTextField countryField;
    public JFXButton signUpButton;
    public JFXButton loginButton;
    private Messages messages;
    private DatabaseDAO databaseDAO;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        messages = new Messages();
        databaseDAO = new DatabaseDAO();
        maleRadio.setUserData("Male");
        femaleRadio.setUserData("Female");
    }

    public void signUpAction(ActionEvent event) {
        String userName = userNameField.getText();
        String password = passwordField.getText();
        String gender = (String) GenderGroup.getSelectedToggle().getUserData();
        String country = countryField.getText();
        if (userName.isEmpty() || password.isEmpty() || country.isEmpty()){
            messages.errorMessage("Invalid Field","Please fill all field to Register");
            return;
        }
        MobileModel mobileModel = new MobileModel(userName,password,gender,country);
        try {
            databaseDAO.saveData(mobileModel);
            messages.infoMessage("SignUp Success","Account created success, Now you can LogIn");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void logInAction(ActionEvent event) throws IOException {
        userNameField.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Log In");
        stage.setResizable(false);
        stage.show();
    }
}
