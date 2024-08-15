module org.example.productshopwarehouseinterface {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens Interfaces to javafx.fxml;
    opens Controllers to javafx.fxml;
    opens Utilities to javafx.base;
    exports Interfaces;
    exports Controllers;
    exports Utilities;
}
