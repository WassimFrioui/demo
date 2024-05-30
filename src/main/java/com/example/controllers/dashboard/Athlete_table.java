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
    private Text error_text;

    @FXML
    public void initialize() {
        title.setText("Athletes");
        addColumnsToTableView(tableview_show, "Id", "LastName", "FirstName", "Country", "Sex", "Age", "Discipline");
    }

    private void addColumnsToTableView(TableView<Athlete> tableView, String... columnNames) {
        for (String columnName : columnNames) {
            TableColumn<Athlete, String> column = new TableColumn<>(columnName);
            if (columnName.equalsIgnoreCase("Sex")) {
                column.setCellValueFactory(cellData -> {
                    Athlete athlete = cellData.getValue();
                    return new SimpleStringProperty(String.valueOf(athlete.getSex()));
                });
            } else if (columnName.equalsIgnoreCase("FirstName")) {
                column.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            } else if (columnName.equalsIgnoreCase("LastName")) {
                column.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            } else {
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
        Athlete selectedAthlete = tableview_show.getSelectionModel().getSelectedItem();
        if (selectedAthlete != null) {
            tableview_show.getItems().remove(selectedAthlete);
            ObservableList<Athlete> data_list_Athletes = FXCollections.observableArrayList(tableview_show.getItems());
            Stage mainStage = (Stage) tableview_show.getScene().getWindow();
            mainStage.setUserData(data_list_Athletes);
            error_text.setText("Athlete deleted");
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
        Athlete selectedAthlete = tableview_show.getSelectionModel().getSelectedItem();
        if (selectedAthlete != null) {
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
                    Athlete modifiedAthlete = (Athlete) stage.getUserData();
                    if (modifiedAthlete != null) {
                        int selectedIndex = tableview_show.getSelectionModel().getSelectedIndex();
                        tableview_show.getItems().set(selectedIndex, modifiedAthlete);
                        ObservableList<Athlete> data_list_Events = FXCollections
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