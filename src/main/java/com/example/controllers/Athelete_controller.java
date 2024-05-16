package com.example.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import com.example.models.Athlete;

public class Athelete_controller {

    @FXML
    private TableView<Athlete> athletesList;

    @FXML
    private TableColumn<Athlete, String> nameColumn;

    @FXML
    private TableColumn<Athlete, Integer> ageColumn;

    @FXML
    private TableColumn<Athlete, Character> sexColumn;

    @FXML
    private TableColumn<Athlete, String> countryColumn;

    @FXML
    private Button btnAddAthlete;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtAge;

    @FXML
    private TextField txtSex;

    @FXML
    private TextField txtCountry;

    // Méthode appelée automatiquement après l'injection des éléments FXML
    public void initialize() {
        // Configuration des cellules des colonnes
        nameColumn.setCellValueFactory(new PropertyValueFactory<Athlete, String>("name"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<Athlete, Integer>("age"));
        sexColumn.setCellValueFactory(new PropertyValueFactory<Athlete, Character>("sex"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<Athlete, String>("country"));
    }

    @FXML
    private void addAthlete() {
        String name = txtName.getText();
        int age = Integer.parseInt(txtAge.getText());
        char sex = txtSex.getText().charAt(0);
        String country = txtCountry.getText();

        athletesList.getItems().add(new Athlete(1, name, name, country, sex, age, null));

        // Rafraîchir la liste des athlètes dans le TableView
        athletesList.refresh();

        // Effacement des champs de saisie
        txtName.clear();
        txtAge.clear();
        txtSex.clear();
        txtCountry.clear();
    }
}
