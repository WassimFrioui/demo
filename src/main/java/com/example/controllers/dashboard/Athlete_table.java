package com.example.controllers.dashboard;

import com.example.App;
import com.example.models.*;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
        addColumnsToTableView(tableview_show, "Id", "LastName", "FirstName", "Country", "Sex", "Age", "Discipline");
    }

    private void addColumnsToTableView(TableView<Athlete> tableView, String... columnNames) {
        for (String columnName : columnNames) {
            TableColumn<Athlete, String> column = new TableColumn<>(columnName);
            if (columnName.equalsIgnoreCase("Sex")) {
                // Utilisation d'une PropertyValueFactory personnalisée pour la colonne "Sex"
                column.setCellValueFactory(cellData -> {
                    Athlete athlete = cellData.getValue();
                    return new SimpleStringProperty(String.valueOf(athlete.getSex()));
                });
            } else if (columnName.equalsIgnoreCase("FirstName")) {
                // Utilisation de PropertyValueFactory avec "firstName" pour la colonne
                // "FirstName"
                column.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            } else if (columnName.equalsIgnoreCase("LastName")) {
                // Utilisation de PropertyValueFactory avec "lastName" pour la colonne
                // "LastName"
                column.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            } else {
                // Utilisation de PropertyValueFactory pour les autres colonnes
                column.setCellValueFactory(new PropertyValueFactory<>(columnName.toLowerCase()));
            }
            tableView.getColumns().add(column);
        }
    }

    @FXML
    void Add_Table_Clicked(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("popup/popup_add_athletes.fxml"));
            AnchorPane root = (AnchorPane) fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.show();

            stage.setOnHidden(e -> {
                Athlete athlete = (Athlete) stage.getUserData();
                if (athlete != null) {
                    tableview_show.getItems().add(athlete);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Delete_Table_Clicked(ActionEvent event) {
        // Implementation for deleting selected item
    }

    @FXML
    void Modify_Table_Clicked(ActionEvent event) {
        // Implementation for modifying selected item
    }
}
