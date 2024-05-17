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

        // Ajouter chaque discipline en tant que MenuItem au MenuButton
        for (Discipline discipline : disciplines) {
            MenuItem menuItem = new MenuItem(discipline.getName());
            menuItem.setOnAction(event -> {
                // Définir le texte du MenuButton sur la discipline sélectionnée
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
        String sexText = sex.getText(); // Récupération du texte du champ de texte "sex"
        String countryText = country.getText();
        list_column.setText("Discipline");

        if (firstNameText.isEmpty() || lastNameText.isEmpty() || ageText.isEmpty() || sexText.isEmpty()
                || countryText.isEmpty()) {
            error_text.setText("Please fill all the fields");
        } else {
            error_text.setText("");
            char sexChar = sexText.charAt(0); // Extraction du premier caractère pour le sexe de l'athlète
            Athlete athlete = new Athlete(1, lastNameText, firstNameText, countryText, sexChar,
                    Integer.parseInt(ageText), null);
            Stage stage = (Stage) b_validate.getScene().getWindow();
            stage.setUserData(athlete);
            stage.close();
        }
    }
}
