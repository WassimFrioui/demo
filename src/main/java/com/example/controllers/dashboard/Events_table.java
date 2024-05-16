package com.example.controllers.dashboard;

import com.example.models.Discipline;
import com.example.models.Event;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

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

        Event event1 = new Event(1, "Event 1", "Description 1", true, null);

        tableview_show.getItems().add(event1);

        
    }

    private void addColumnsToTableView(TableView<Event> tableView, String... columnNames) {
        for (String columnName : columnNames) {
            TableColumn<Event, String> column = new TableColumn<>(columnName);
            tableView.getColumns().add(column);
        }
    }

    @FXML
    void Add_Table_Clicked(ActionEvent event) {
        System.err.println("Add Table Clicked");
    }

    @FXML
    void Delete_Table_Clicked(ActionEvent event) {

    }

    @FXML
    void Modify_Table_Clicked(ActionEvent event) {

    }

}
