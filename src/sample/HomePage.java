package sample;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class HomePage implements Initializable {

    public BorderPane borderPane;
    public JFXButton dashBoardButton;
    public JFXButton wishListButton;
    public JFXButton addPhoneButton;
    public JFXButton contactButton;
    public HBox dashBoardView;
    public ImageView column1ImageUp;
    public ImageView column1ImageDown;
    public ImageView column2ImageUp;
    public ImageView column2ImageDown;
    public ImageView column3ImageUp;
    public ImageView column3ImageDown;
    public ImageView column4ImageUp;
    public ImageView column4ImageDown;
    public JFXButton logoutButton;
    public ImageView LogOutImage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       imageInitialize();
    }

    private void imageInitialize() {
        Image se = new Image(getClass().getResourceAsStream("/sample/PhonesImg/Se.png"));
        column1ImageUp.setImage(se);

        Image iphone11 = new Image(getClass().getResourceAsStream("/sample/PhonesImg/Iphone11.png"));
        column1ImageDown.setImage(iphone11);

        Image xiaomi10 = new Image(getClass().getResourceAsStream("/sample/PhonesImg/Mi10.png"));
        column2ImageUp.setImage(xiaomi10);

        Image redmi9 = new Image(getClass().getResourceAsStream("/sample/PhonesImg/Redmi9.png"));
        column2ImageDown.setImage(redmi9);

        Image Vivo = new Image(getClass().getResourceAsStream("/sample/PhonesImg/Vivo.png"));
        column3ImageUp.setImage(Vivo);

        Image samsung = new Image(getClass().getResourceAsStream("/sample/PhonesImg/Samsung.png"));
        column3ImageDown.setImage(samsung);

        Image oppo = new Image(getClass().getResourceAsStream("/sample/PhonesImg/Oppo.png"));
        column4ImageUp.setImage(oppo);

        Image onePlus = new Image(getClass().getResourceAsStream("/sample/PhonesImg/Oneplus.png"));
        column4ImageDown.setImage(onePlus);

        Image logOut = new Image(getClass().getResourceAsStream("/sample/PhonesImg/Exist12.png"));
        LogOutImage.setImage(logOut);
    }

    public void dashBoardView(ActionEvent event) {
        borderPane.setCenter(dashBoardView);
    }

    public void wishListAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("WhistList.fxml"));
        borderPane.setCenter(root);
    }

    public void addPhoneAction(ActionEvent event) {
    }

    public void contactAction(ActionEvent event) {
    }

    public void LogoutAction(ActionEvent event) throws IOException {
        dashBoardButton.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("Log In");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
