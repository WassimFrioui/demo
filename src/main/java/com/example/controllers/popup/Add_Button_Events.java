package com.example.controllers.popup;

import com.example.models.Event;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Add_Button_Events {
    @FXML
    private CheckBox active;

    @FXML
    private Button b_cancel;

    @FXML
    private Button b_validate;

    @FXML
    private TextField description;

    @FXML
    private Text error_text;

    @FXML
    private TextField name;

    @FXML
    private MenuButton list_column;

    @FXML
    private Text text;

    @FXML
    void initialize() {
        text.setText("Add an event");
        error_text.setText("");
    }

    @FXML
    void B_Cancel_Click(ActionEvent event) {
        Stage stage = (Stage) b_cancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    void B_Validate_Click(ActionEvent event) {
        if (name != null && description != null) {
            String nameText = name.getText();
            Boolean activeText = active.isSelected();
            String descriptionText = description.getText();
            if (nameText.isEmpty() || descriptionText.isEmpty()) {
                error_text.setText("Please fill all the fields");
                error_text.setStyle("-fx-fill: red;");
                System.out.println("error");
            } else {
                error_text.setText("");
                Stage stage = (Stage) b_validate.getScene().getWindow();
                Event newEvent = new Event(null, nameText, descriptionText, activeText, null);
                stage.setUserData(newEvent);
                stage.close();
                System.out.println("success");
            }
        } else {
            error_text.setText("Initialization error");
            error_text.setStyle("-fx-fill: red;");
        }
    }
}
