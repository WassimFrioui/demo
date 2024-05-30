package com.example.controllers.popup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.example.models.Athlete;
import com.example.models.EventResult;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Add_Button_EvenResult {
    @FXML
    private Button b_cancel;

    @FXML
    private Button b_validate;

    @FXML
    private DatePicker date;

    @FXML
    private TextField description;

    @FXML
    private Text error_text;

    @FXML
    private MenuButton list_column;

    @FXML
    private TextField name;

    @FXML
    private TextField ranklist;

    @FXML
    private TextField scorelist;

    @FXML
    private TextField templist;

    @FXML
    private Text text;

    @FXML
    void B_Cancel_Click(ActionEvent event) {
        Stage stage = (Stage) b_cancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    void B_Validate_Click(ActionEvent event) {
        String nameText = name.getText();
        String descriptionText = description.getText();
        String dateText = date.getValue() != null ? date.getValue().toString() : "";
        List<Float> templistText = new ArrayList<>();
        List<String> scorelistText = new ArrayList<>();
        List<Athlete> ranklistText = new ArrayList<>();
        String eventText = list_column.getText();

        try {
            if (!templist.getText().isEmpty()) {
                templistText = Arrays.stream(templist.getText().split(","))
                        .map(String::trim)
                        .map(Float::parseFloat)
                        .collect(Collectors.toList());
            }
        } catch (NumberFormatException e) {
            error_text.setText("Invalid temperature list");
            error_text.setStyle("-fx-fill: red;");
            return;
        }

        if (!scorelist.getText().isEmpty()) {
            scorelistText = Arrays.stream(scorelist.getText().split(","))
                    .map(String::trim)
                    .collect(Collectors.toList());
        }

        if (nameText.isEmpty() || descriptionText.isEmpty() || dateText.isEmpty() || templistText.isEmpty()
                || scorelistText.isEmpty() || eventText.isEmpty()) {
            error_text.setText("Please fill all the fields");
            error_text.setStyle("-fx-fill: red;");
        } else {
            error_text.setText("");
            EventResult neweventresult = new EventResult(0, nameText, descriptionText, dateText,
                    ranklistText, templistText, scorelistText, null);
            Stage stage = (Stage) b_validate.getScene().getWindow();
            stage.setUserData(neweventresult);
            stage.close();
        }
    }

}
