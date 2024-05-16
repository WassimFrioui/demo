package com.example.controllers.dashboard;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

public class Analytiques_table {
    @FXML
    private Button button_add_tab;

    @FXML
    private Button button_delete_tab;

    @FXML
    private Button button_modify_tab;

    @FXML
    private Button page_1;

    @FXML
    private TableView<?> tableview_show;

    @FXML
    private Text title;

    @FXML
    public void initialize() {
        title.setText("Analytiques");
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
