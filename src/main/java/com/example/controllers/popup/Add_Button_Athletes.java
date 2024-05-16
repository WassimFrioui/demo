package com.example.controllers.popup;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import com.example.controllers.dashboard.*;
import com.example.models.Athlete;
import com.example.models.Discipline;

public class Add_Button_Athletes {
    @FXML
    private TextField age;

    @FXML
    private Button b_cancel;

    @FXML
    private Button b_validate;

    @FXML
    private TextField country;

    @FXML
    private Text error_text;

    @FXML
    private TextField firstname;

    @FXML
    private TextField lastname;

    @FXML
    private MenuButton list_column;

    @FXML
    private TextField sex;

    @FXML
    void B_Cancel_Click(ActionEvent event) {
        Stage stage = (Stage) b_cancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    void B_Validate_Clck(ActionEvent event) {
        String firstNameText = firstname.getText();
        String lastNameText = lastname.getText();
        String ageText = age.getText();
        String sexText = sex.getText();
        String countryText = country.getText();
        String columnText = list_column.getText();

        if (firstNameText.isEmpty() || lastNameText.isEmpty() || ageText.isEmpty() || sexText.isEmpty()
                || countryText.isEmpty()) {
            error_text.setText("Please fill all the fields");
        } else {
            error_text.setText("");
            Athlete athlete = new Athlete(1, lastNameText, firstNameText, countryText, sexText.charAt(0),
                    Integer.parseInt(ageText), null);

            Stage stage = (Stage) b_validate.getScene().getWindow();
            stage.close();
        }

    }
}
