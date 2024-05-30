package com.example.controllers.dashboard;

import java.util.Timer;

import com.example.App;
import com.example.models.*;

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
    private TableView<EventResult> tableview_show;

    @FXML
    private Text title;

    @FXML
    private Text error_text;

    @FXML
    public void initialize() {
        title.setText("Event Results");
        addColumnsToTableView(tableview_show, "Id", "Name", "Description", "Date", "RankList", "TempList", "ScoreList",
                "Event");
    }

    private void addColumnsToTableView(TableView<EventResult> tableView, String... columnNames) {
        for (String columnName : columnNames) {
            TableColumn<EventResult, String> column = new TableColumn<>(columnName);
            if (columnName.equals("Id")) {
                column.setCellValueFactory(new PropertyValueFactory<>(columnName.toLowerCase()));
            } else if (columnName.equals("Name")) {
                column.setCellValueFactory(new PropertyValueFactory<>(columnName.toLowerCase()));
            } else if (columnName.equals("Description")) {
                column.setCellValueFactory(new PropertyValueFactory<>(columnName.toLowerCase()));
            } else if (columnName.equals("Date")) {
                column.setCellValueFactory(new PropertyValueFactory<>(columnName.toLowerCase()));
            } else if (columnName.equals("RankList")) {
                column.setCellValueFactory(cellData -> {
                    SimpleStringProperty property = new SimpleStringProperty();
                    property.set(cellData.getValue().getRankList().toString());
                    return property;
                });
            } else if (columnName.equals("TempList")) {
                column.setCellValueFactory(cellData -> {
                    SimpleStringProperty property = new SimpleStringProperty();
                    property.set(cellData.getValue().getTempList().toString());
                    return property;
                });
            } else if (columnName.equals("ScoreList")) {
                column.setCellValueFactory(cellData -> {
                    SimpleStringProperty property = new SimpleStringProperty();
                    property.set(cellData.getValue().getScoreList().toString());
                    return property;
                });
            }

            tableView.getColumns().add(column);
        }
    }

    @FXML
    void Add_Table_Clicked(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("popup/popup_add_eventresult.fxml"));
            AnchorPane root = (AnchorPane) fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.show();

            stage.setOnHidden(e -> {
                EventResult neweventresult = (EventResult) stage.getUserData();
                if (neweventresult != null) {
                    tableview_show.getItems().add(neweventresult);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Delete_Table_Clicked(ActionEvent event) {
        EventResult selectedEventResult = tableview_show.getSelectionModel().getSelectedItem();
        if (selectedEventResult != null) {
            tableview_show.getItems().remove(selectedEventResult);
            ObservableList<EventResult> data_list_EventResults = FXCollections
                    .observableArrayList(tableview_show.getItems());
            Stage mainStage = (Stage) tableview_show.getScene().getWindow();
            mainStage.setUserData(data_list_EventResults);
            error_text.setText("Event Result deleted");
            error_text.setStyle("-fx-fill: green;");
            Timer timer = new Timer();
            timer.schedule(new java.util.TimerTask() {
                @Override
                public void run() {
                    error_text.setText("");
                }
            }, 2000);
        } else {
            error_text.setText("Please select an event to delete");
            error_text.setStyle("-fx-fill: red;");
            System.out.println("error");
            Timer timer = new Timer();
            timer.schedule(new java.util.TimerTask() {

                @Override
                public void run() {
                    error_text.setText("");
                }

            }, 2000);

        }
    }

    @FXML
    void Modify_Table_Clicked(ActionEvent event) {
        EventResult selectedEventResult = tableview_show.getSelectionModel().getSelectedItem();
        if (selectedEventResult != null) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("popup/popup_add_athletes.fxml"));
                AnchorPane root = (AnchorPane) fxmlLoader.load();
                Scene scene = new Scene(root);
                scene.getStylesheets().add(App.class.getResource("style.css").toExternalForm());
                Stage stage = new Stage();
                stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(scene);
                stage.show();
                stage.setOnHidden(e -> {
                    EventResult modifiedEventResult = (EventResult) stage.getUserData();
                    if (modifiedEventResult != null) {
                        int selectedIndex = tableview_show.getSelectionModel().getSelectedIndex();
                        tableview_show.getItems().set(selectedIndex, modifiedEventResult);
                        ObservableList<EventResult> data_list_Events = FXCollections
                                .observableArrayList(tableview_show.getItems());
                        Stage mainStage = (Stage) tableview_show.getScene().getWindow();
                        mainStage.setUserData(data_list_Events);
                        System.out.println("Event modified");
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            error_text.setText("Please select an event to modify");
            error_text.setStyle("-fx-fill: red;");
            System.out.println("error");
            Timer timer = new Timer();
            timer.schedule(new java.util.TimerTask() {
                @Override
                public void run() {
                    error_text.setText("");
                }
            }, 2000);
        }
    }
}