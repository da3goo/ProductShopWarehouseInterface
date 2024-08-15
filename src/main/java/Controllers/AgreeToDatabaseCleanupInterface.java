package Controllers;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import Connection.SQLServerConnection;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AgreeToDatabaseCleanupInterface {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button noButton;

    @FXML
    private Label timer10;

    @FXML
    private Button yesButton;

    @FXML
    void cleanUp(ActionEvent event) throws SQLException {
        String query = "Truncate table catalog";
        try(Connection connection =SQLServerConnection.getConnection()){
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        }catch(SQLException e) {
            System.out.println(e);
        }
        goBack(event);
    }

    @FXML
    void goBack(ActionEvent event) {
        Stage currentStage = (Stage) noButton.getScene().getWindow();
        currentStage.close();
    }

    @FXML
    void initialize() {
        yesButton.setDisable(true);
        int initialTime = 10;
        timer10.setText(initialTime+"s");
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {

            int currentTime = Integer.parseInt(timer10.getText().replace("s", ""));
            if (currentTime > 1) {
                timer10.setText((currentTime - 1) + "s");
            }
            if(currentTime == 1){
                timer10.setText("");
            }
        }));
        timeline.setCycleCount(initialTime);
        timeline.setOnFinished(e -> {

            yesButton.setDisable(false);
        });
        timeline.play();
    }
}
