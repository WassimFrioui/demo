package com.example.controllers.dashboard;

import com.example.App;
import com.example.models.Athlete;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Athlete_table {

    @FXML
    private Button button_add_tab;

    @FXML
    private Button button_delete_tab;

    @FXML
    private Button button_modify_tab;

    @FXML
    private Button page_1;

    @FXML
    private TableView<Athlete> tableview_show;

    @FXML
    private Text title;

    @FXML
    public void initialize() {
        title.setText("Athletes");
        addColumnsToTableView(tableview_show, "Id", "Nom", "Prénom", "Date de naissance", "Sexe", "Nationalité",
                "Discipline");
    }

    private void addColumnsToTableView(TableView<Athlete> tableView, String... columnNames) {
        for (String columnName : columnNames) {
            TableColumn<Athlete, String> column = new TableColumn<>(columnName);
            tableView.getColumns().add(column);
        }
    }

    @FXML
    void Add_Table_Clicked(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(
                    App.class.getResource("popup/popup_add_athletes.fxml"));
            AnchorPane root = (AnchorPane) fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage(); // Create a new Stage
            stage.setScene(scene); // Set the Scene to the Stage
            stage.show(); // Call show() on the Stage
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
