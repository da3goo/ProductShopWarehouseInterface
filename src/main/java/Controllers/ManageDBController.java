package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ManageDBController {
    private Stage previousStage;
    public void setPreviousStage(Stage previousStage){
        this.previousStage = previousStage;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addNewItem;

    @FXML
    private Button backFromManageDB;


    @FXML
    private Button deleteItemFromDB;

    @FXML
    void addNewItemToDB(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Interfaces/addNewItemInterface.fxml"));
        Scene newScene = new Scene(loader.load(),587,628);
        newScene.getStylesheets().add(getClass().getResource("/Styles/addNewItemStyle.css").toExternalForm());

        AddNewItemController addNewItemController = loader.getController();
        addNewItemController.setPreviousStage((Stage) addNewItem.getScene().getWindow());

        Stage stage1 = new Stage();
        stage1.setTitle("Manage DB page");
        stage1.setScene(newScene);
        stage1.show();

        Stage currentStage = (Stage) addNewItem.getScene().getWindow();
        currentStage.close();
    }

    @FXML
    void openCleanUpInterface(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Interfaces/AgreeToDatabaseCleanup.fxml"));
        Scene newScene = new Scene(loader.load(),300,200);
        newScene.getStylesheets().add(getClass().getResource("/Styles/AgreeToDatabaseCleanupStyle.css").toExternalForm());



        Stage stage = new Stage();
        stage.setTitle("");
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    void openEditInterface(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Interfaces/editInterface.fxml"));
        Scene newScene = new Scene(loader.load(),985,677);
        newScene.getStylesheets().add(getClass().getResource("/Styles/editInterfaceStyle.css").toExternalForm());


        EditInterfaceController editInterfaceController = loader.getController();
        editInterfaceController.setPreviousStage((Stage) addNewItem.getScene().getWindow());

        Stage currentStage = (Stage) addNewItem.getScene().getWindow();
        currentStage.close();

        Stage stage = new Stage();
        stage.setTitle("Edit");
        stage.setScene(newScene);
        stage.show();
    }

    @FXML
    void goBackFromManageDB(ActionEvent event) {
        if (previousStage!=null){
            previousStage.show();
        }
        Stage currentStage = (Stage) addNewItem.getScene().getWindow();
        currentStage.close();
    }

    @FXML
    void initialize() {

    }

}
