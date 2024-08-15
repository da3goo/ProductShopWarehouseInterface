package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AdminInterfaceController {
    private Stage previousStage;
    public void setPreviousStage(Stage previousStage){
        this.previousStage = previousStage;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private Button exitFromManageButton;

    @FXML
    void goBackToMain(){
        if (previousStage!=null){
            previousStage.show();
        }
        Stage currentStage = (Stage) exitFromManageButton.getScene().getWindow();
        currentStage.close();
    }
    @FXML
    void openManageDBInterface() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Interfaces/manageDBinterface.fxml"));
        Scene newScene = new Scene(loader.load(),587,628);
        newScene.getStylesheets().add(getClass().getResource("/Styles/manageDBStyle.css").toExternalForm());


        ManageDBController manageDBController = loader.getController();
        manageDBController.setPreviousStage((Stage)exitFromManageButton.getScene().getWindow());

        Stage stage2 = new Stage();
        stage2.setTitle("Manage DB page");
        stage2.setScene(newScene);
        stage2.show();
        Stage currentStage = (Stage) exitFromManageButton.getScene().getWindow();
        currentStage.close();
    }

}
