package Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import Utilities.GetTableData;
import Utilities.ManageDB;
import Utilities.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class EditInterfaceController {

    private Stage previousStage;

    public void setPreviousStage(Stage previousStage) {
        this.previousStage = previousStage;
    }

    @FXML
    private TableColumn<Product, Void> deleteColumn;

    @FXML
    TableView<Product> tableView;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Product, String> countryColumn;

    @FXML
    private TableColumn<Product, Integer> entityColumn;

    @FXML
    private TableColumn<Product, Integer> idColumn;

    @FXML
    private TableColumn<Product, String> nameColumn;

    @FXML
    private TableColumn<Product, Integer> priceColumn;

    @FXML
    private TableColumn<Product, String> typeColumn;

    @FXML
    private TableColumn<Product, Integer> updateEntityColumn;

    @FXML
    private Button backButton;

    @FXML
    private Button refreshButton;

    @FXML
    void refresh() {
        loadData();
    }

    @FXML
    void initialize() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        entityColumn.setCellValueFactory(new PropertyValueFactory<>("entity"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        // Установка фабрики ячеек и обработчика изменений для updateEntityColumn
        updateEntityColumn.setCellValueFactory(new PropertyValueFactory<>("entity"));
        updateEntityColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        updateEntityColumn.setOnEditCommit(event -> {
            Product product = event.getRowValue();
            int newValue = event.getNewValue();
            product.setEntity(newValue);
            ManageDB.updateProductEntityInDatabase(product.getId(), newValue);
        });


        Callback<TableColumn<Product, Void>, TableCell<Product, Void>> cellFactory = new Callback<TableColumn<Product, Void>, TableCell<Product, Void>>() {
            @Override
            public TableCell<Product, Void> call(final TableColumn<Product, Void> param) {
                final TableCell<Product, Void> cell = new TableCell<Product, Void>() {
                    private final Button btn = new Button("Delete");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Product data = getTableView().getItems().get(getIndex());
                            ManageDB.deleteProductFromDB(data);
                            loadData();
                        });
                    }

                    @Override
                    protected void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };
        deleteColumn.setCellFactory(cellFactory);

        tableView.setEditable(true);
        loadData();
    }

    private void loadData() {
        List<Product> productList = GetTableData.getProducts("");
        ObservableList<Product> observableList = FXCollections.observableArrayList(productList);
        tableView.setItems(observableList);
    }

    @FXML
    void goBackFromEdit() {
        if (previousStage != null) {
            previousStage.show();
        }
        Stage currentStage = (Stage) backButton.getScene().getWindow();
        currentStage.close();
    }
}
