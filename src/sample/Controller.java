package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.Database.DatabaseDAO;
import sample.Database.MobileModel;
import sample.Tools.Messages;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public ImageView mobileImageView;
    public ImageView UserNameImage;
    public ImageView passwordImage;
    public ImageView progressImage;
    public JFXTextField userNameField;
    public JFXButton signInButton;
    public JFXButton signUpButton;
    public JFXCheckBox rememberMe;
    public JFXPasswordField passwordField;
    private Messages messages;
    private DatabaseDAO databaseDAO;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        messages = new Messages();
        databaseDAO = new DatabaseDAO();
        setIconImages();
    }

    private void setIconImages() {
        Image mobileImage = new Image(getClass().getResourceAsStream("/sample/Images/mobile.png"));
        mobileImageView.setImage(mobileImage);
        Image userNameIcon = new Image(getClass().getResourceAsStream("/sample/Images/userName.png"));
        UserNameImage.setImage(userNameIcon);
        Image passwordIcon = new Image(getClass().getResourceAsStream("/sample/Images/password.png"));
        passwordImage.setImage(passwordIcon);
        Image progressGif = new Image(getClass().getResourceAsStream("/sample/Images/745.gif"));
        progressImage.setImage(progressGif);
        progressImage.setVisible(false);
    }

    public void SignInAction(ActionEvent event) {
        //Show Progress Transition before check username & password
        progressImage.setVisible(true);
        PauseTransition pauseTransition = new PauseTransition();
        pauseTransition.setDuration(Duration.seconds(2));
        pauseTransition.setOnFinished(event1 -> {
            String userName = userNameField.getText();
            String password = passwordField.getText();
            if (userName.isEmpty() || password.isEmpty()){
                messages.errorMessage("Field Empty","Please fill all fields to LogIn");
                progressImage.setVisible(false);
                return;
            }
            try {
                MobileModel mobileModel = new MobileModel(userName,password);
                if (databaseDAO.isUserExists(mobileModel)){
                    userNameField.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
                    Scene scene = new Scene(root,840,500);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.setTitle("Home");
                    stage.show();
                }else {
                    messages.errorMessage("404 Not Found","User Name & Password is not exists on Database.Please Register to Log In");
                    progressImage.setVisible(false);
                }
            } catch (SQLException | ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
        });
        pauseTransition.play();
    }

    public void signUpAction(ActionEvent event) throws IOException {
        userNameField.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root,600,400);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Sign Up");
        stage.show();
    }

    public void rememberMeAction(ActionEvent event) {
    }

}
