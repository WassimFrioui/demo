package com.example.controllers.dashboard;

import com.example.App;
import com.example.models.Discipline;
import com.example.models.Event;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.stage.StageStyle;

public class Events_table {
    @FXML
    private Button button_add_tab;

    @FXML
    private Button button_delete_tab;

    @FXML
    private Button button_modify_tab;

    @FXML
    private Button page_1;

    @FXML
    private TableView<Event> tableview_show;

    @FXML
    private Text title;

    @FXML
    public void initialize() {
        title.setText("Disciplines");
        addColumnsToTableView(tableview_show, "Id", "Nom", "Description", "Active", "Discipline");

    }

    private void addColumnsToTableView(TableView<Event> tableView, String... columnNames) {
        for (String columnName : columnNames) {
            TableColumn<Event, String> column = new TableColumn<>(columnName);
            tableView.getColumns().add(column);
        }
    }

    @FXML
    void Add_Table_Clicked(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("popup/popup_add_events.fxml"));
            AnchorPane root = (AnchorPane) fxmlLoader.load();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(App.class.getResource("style.css").toExternalForm());
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.show();

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
