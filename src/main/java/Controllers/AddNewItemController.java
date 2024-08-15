package Controllers;

import java.net.URL;
import Utilities.ManageDB;
import java.util.ResourceBundle;
import java.util.Timer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddNewItemController {
    private Stage previousStage;
    public void setPreviousStage(Stage previousStage){
        this.previousStage = previousStage;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private Label statusLabel;
    private Label statusLabel2;




    @FXML
    private TextField entityNewItem;

    @FXML
    private Button goBackFromAddNewIten;

    @FXML
    private TextField nameAddNewItem;

    @FXML
    private TextField priceNewItem;

    @FXML
    private Button submitNewItem;

    @FXML
    private TextField typeAddNewItem;
    @FXML
    private TextField countryNewItem;
    @FXML
    private Button refreshButton;

    @FXML
    void goBackFromAddNewItem(ActionEvent event) {
        if(previousStage!=null) {
            previousStage.show();

        }
        Stage currentStage = (Stage) nameAddNewItem.getScene().getWindow();
        currentStage.close();
    }
    @FXML
    void refreshAddNewItem(){
        Stage currentStage = (Stage) nameAddNewItem.getScene().getWindow();
        currentStage.close();
        nameAddNewItem.clear();
        typeAddNewItem.clear();
        countryNewItem.clear();
        entityNewItem.clear();
        priceNewItem.clear();
        currentStage.show();
    }



    @FXML
    void submitNewItem(ActionEvent event) throws InterruptedException {
        statusLabel.setText("dasdsa");
        String type = typeAddNewItem.getText();
        String name = nameAddNewItem.getText();
        int entity = Integer.parseInt(entityNewItem.getText());
        int price = Integer.parseInt(priceNewItem.getText());
        String country = countryNewItem.getText();
        boolean isAdded = ManageDB.addItem(type,name,entity,price,country);
        if(isAdded){
            statusLabel.setText("Successful!");


        }else{
            statusLabel2.setText("Error");
            Thread.sleep(10000);
            statusLabel2.setText("");
        }

    }



}
