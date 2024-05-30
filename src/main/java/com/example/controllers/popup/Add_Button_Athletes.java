package com.example.controllers.popup;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
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
    void initialize() {
        // Récupérer la liste des disciplines
        ObservableList<Discipline> disciplines = Discipline.getDisciplines();

        for (Discipline discipline : disciplines) {
            MenuItem menuItem = new MenuItem(discipline.getName());
            menuItem.setOnAction(event -> {

                list_column.setText(discipline.getName());
            });
            list_column.getItems().add(menuItem);
        }
    }

    @FXML
    void B_Cancel_Click(ActionEvent event) {
        Stage stage = (Stage) b_cancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    void B_Validate_Click(ActionEvent event) {
        String firstNameText = firstname.getText();
        String lastNameText = lastname.getText();
        String ageText = age.getText();
        String sexText = sex.getText();
        String countryText = country.getText();
        firstname.setStyle("-fx-text-inner-color: white;");
        list_column.setText("Discipline");

        if (firstNameText.isEmpty() || lastNameText.isEmpty() || ageText.isEmpty() || sexText.isEmpty()
                || countryText.isEmpty()) {
            error_text.setText("Please fill all the fields");
            error_text.setStyle("-fx-fill: red;");
        } else {
            error_text.setText("");
            char sexChar = sexText.charAt(0);
            Athlete athlete = new Athlete(null, lastNameText, firstNameText, countryText, sexChar,
                    Integer.parseInt(ageText), null);
            Stage stage = (Stage) b_validate.getScene().getWindow();
            stage.setUserData(athlete);
            stage.close();
        }
    }
}
