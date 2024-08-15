package Interfaces;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/Interfaces/AuthenficationInterface.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 587, 628);
        scene.getStylesheets().add(getClass().getResource("/Styles/loginButtonStyle.css").toExternalForm());
        stage.setTitle("Product Warehouse");
        stage.setScene(scene);
        stage.show();
    }
}