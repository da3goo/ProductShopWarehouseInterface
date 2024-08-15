package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import Checkers.Login;
import javafx.stage.Stage;


public class AuthentificationController {
    @FXML
    private TextField emailField;
    @FXML
    private TextField passwordField;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private Label authentificationStatus;

    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    @FXML
    void openLogin(ActionEvent event) throws IOException {
        String login = emailField.getText();
        String password = passwordField.getText();

        try{
            String stat = Login.loginCheck(login,password);
            if (stat.equals("owner")){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Interfaces/adminInterface.fxml"));
                Scene newScene = new Scene(loader.load(),587,628);
                newScene.getStylesheets().add(getClass().getResource("/Styles/AdminInterfaceStyle.css").toExternalForm());


                AdminInterfaceController controller = loader.getController();
                controller.setPreviousStage((Stage) loginButton.getScene().getWindow());

                Stage newStage1 = new Stage();
                newStage1.setTitle("Admin Page");
                newStage1.setScene(newScene);
                newStage1.show();
                Stage currentStage = (Stage) emailField.getScene().getWindow();
                currentStage.close();
            } else if (stat.equals("user")) {
                //потом
            } else if (stat.equals("incorrectPassword")) {
                authentificationStatus.setText("Incorrect Password");
            } else if (stat.equals("not found")) {
                authentificationStatus.setText("Not found");
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    @FXML
    void openRegister(ActionEvent event) {

    }




    @FXML
    void initialize() {
        assert loginButton != null : "fx:id=\"loginButton\" was not injected: check your FXML file 'AuthenficationInterface.fxml'.";
        assert registerButton != null : "fx:id=\"registerButton\" was not injected: check your FXML file 'AuthenficationInterface.fxml'.";

    }

}
