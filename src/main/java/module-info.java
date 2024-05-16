module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.base;
    requires javafx.graphics;

    opens com.example to javafx.fxml;
    opens com.example.controllers to javafx.fxml;
    opens com.example.controllers.dashboard to javafx.fxml;
    opens com.example.controllers.popup to javafx.fxml;
    opens com.example.models to javafx.base;

    exports com.example;
    exports com.example.controllers;
    exports com.example.controllers.dashboard;
    exports com.example.controllers.popup;

}
