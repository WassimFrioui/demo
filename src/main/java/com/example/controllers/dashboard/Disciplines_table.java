package com.example.controllers.dashboard;

import com.example.App;
import com.example.models.*;
import com.example.models.Discipline;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class Disciplines_table {

    @FXML
    private Button button_add_tab;

    @FXML
    private Button button_delete_tab;

    @FXML
    private Button button_modify_tab;

    @FXML
    private Button page_1;

    @FXML
    private TableView<Discipline> tableview_show;

    @FXML
    private Text title;

    @FXML
    public void initialize() {
        title.setText("Disciplines");

        // Ajouter les colonnes avec leurs noms
        TableColumn<Discipline, Integer> idColumn = new TableColumn<>("Id");
        TableColumn<Discipline, String> nomColumn = new TableColumn<>("Nom");
        TableColumn<Discipline, String> descriptionColumn = new TableColumn<>("Description");

        // Associer les valeurs des colonnes aux propriétés correspondantes de
        // Discipline
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        // Ajouter les colonnes à la TableView
        tableview_show.getColumns().add(idColumn);
        tableview_show.getColumns().add(nomColumn);
        tableview_show.getColumns().add(descriptionColumn);

        // Ajouter une discipline à titre d'exemple
        Discipline discipline1 = new Discipline(1, "Discipline 1", "Description 1");
        Discipline discipline2 = new Discipline(2, "Discipline 2",
                "Description 2 Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        Discipline discipline3 = new Discipline(3, "Discipline 3", "Description 3");

        tableview_show.getItems().add(discipline3);
        tableview_show.getItems().add(discipline1);
        tableview_show.getItems().add(discipline2);

    }

    @FXML
    void Add_Table_Clicked(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("start.fxml"));
        try {
            loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Delete_Table_Clicked(ActionEvent event) {

    }

    @FXML
    void Modify_Table_Clicked(ActionEvent event) {

    }

}
