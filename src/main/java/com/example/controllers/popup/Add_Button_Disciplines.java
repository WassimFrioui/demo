package com.example.controllers.popup;

import com.example.models.Athlete;
import com.example.models.Discipline;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Add_Button_Disciplines {

    @FXML
    private Button b_cancel;

    @FXML
    private Button b_validate;

    @FXML
    private TextArea description;

    @FXML
    private Text error_text;

    @FXML
    private TextField name;

    @FXML
    private Text text;

    @FXML
    void initialize() {
        text.setText("Add a discipline");
        error_text.setText("");
    }

    @FXML
    void B_Cancel_Click(ActionEvent event) {
        Stage stage = (Stage) b_cancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    void B_Validate_Click(ActionEvent event) {
        String nameText = name.getText();
        String descriptionText = description.getText();
        if (nameText.isEmpty() || descriptionText.isEmpty()) {
            error_text.setText("Please fill all the fields");
            error_text.setStyle("-fx-fill: red;");
            System.out.println("error");
        } else {
            error_text.setText("");
            Stage stage = (Stage) b_validate.getScene().getWindow();
            Discipline discipline = new Discipline(null, nameText, descriptionText);
            stage.setUserData(discipline);
            stage.close();
            System.out.println("success");
        }
    }

}
