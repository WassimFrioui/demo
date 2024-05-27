package com.example.controllers.dashboard;

import com.example.App;
import com.example.models.Discipline;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
        addColumnsToTableView(tableview_show, "Id", "Name", "Description");

        // Ajouter un écouteur à la propriété de scène
        tableview_show.sceneProperty().addListener((observable, oldScene, newScene) -> {
            if (newScene != null) {
                Stage stage = (Stage) newScene.getWindow();
                ObservableList<Discipline> data_list_Disciplines = retrieveUserData(stage);

                if (data_list_Disciplines != null) {
                    tableview_show.setItems(data_list_Disciplines);
                } else {
                    data_list_Disciplines = FXCollections.observableArrayList();
                    tableview_show.setItems(data_list_Disciplines);
                }

                stage.setUserData(data_list_Disciplines);
            }
        });
    }

    @SuppressWarnings("unchecked")
    private ObservableList<Discipline> retrieveUserData(Stage stage) {
        Object userData = stage.getUserData();
        if (userData instanceof ObservableList<?>) {
            try {
                return (ObservableList<Discipline>) userData;
            } catch (ClassCastException e) {
                System.err.println("UserData is not of type ObservableList<Discipline>");
            }
        }
        return null;
    }

    private void addColumnsToTableView(TableView<Discipline> tableView, String... columnNames) {
        for (String columnName : columnNames) {
            TableColumn<Discipline, String> column = new TableColumn<>(columnName);
            if (columnName.equalsIgnoreCase("Name")) {
                column.setCellValueFactory(new PropertyValueFactory<>("name"));
            } else if (columnName.equalsIgnoreCase("Description")) {
                column.setCellValueFactory(new PropertyValueFactory<>("description"));
            } else {
                column.setCellValueFactory(new PropertyValueFactory<>(columnName.toLowerCase()));
            }
            tableView.getColumns().add(column);
        }
    }

    @FXML
    void Add_Table_Clicked(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("popup/popup_add_disciplines.fxml"));
            AnchorPane root = (AnchorPane) fxmlLoader.load();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(App.class.getResource("style.css").toExternalForm());
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.show();

            stage.setOnHidden(e -> {
                Discipline discipline = (Discipline) stage.getUserData();
                if (discipline != null) {
                    tableview_show.getItems().add(discipline);
                    ObservableList<Discipline> data_list_Disciplines = FXCollections
                            .observableArrayList(tableview_show.getItems());
                    Stage mainStage = (Stage) tableview_show.getScene().getWindow();
                    mainStage.setUserData(data_list_Disciplines);
                    
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
