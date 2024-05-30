package com.example.controllers.dashboard;

import java.util.Timer;

import com.example.App;
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
import javafx.scene.control.cell.PropertyValueFactory;
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
    private Text error_text;

    @FXML
    public void initialize() {
        title.setText("Events");
        addColumnsToTableView(tableview_show, "id", "name", "description", "active", "discipline");

        // Ajout d'un écouteur à la propriété de scène qui permet de récupérer les
        // données de la scène principale et de les afficher dans le tableau
        tableview_show.sceneProperty().addListener((observable, oldScene, newScene) -> {
            if (newScene != null) {
                Stage stage = (Stage) newScene.getWindow();
                ObservableList<Event> data_list_Events = retrieveUserData(stage);

                if (data_list_Events != null) {
                    tableview_show.setItems(data_list_Events);
                } else {
                    data_list_Events = FXCollections.observableArrayList();
                    tableview_show.setItems(data_list_Events);
                }

                stage.setUserData(data_list_Events);
            }
        });
    }

    @SuppressWarnings("unchecked")
    private ObservableList<Event> retrieveUserData(Stage stage) {
        Object userData = stage.getUserData();
        if (userData instanceof ObservableList<?>) {
            try {
                return (ObservableList<Event>) userData;
            } catch (ClassCastException e) {
                System.err.println("Error casting user data to ObservableList<Event>");
            }
        }
        return null;
    }

    private void addColumnsToTableView(TableView<Event> tableView, String... columnNames) {
        for (String columnName : columnNames) {
            TableColumn<Event, String> column = new TableColumn<>(
                    columnName.substring(0, 1).toUpperCase() + columnName.substring(1));
            if (columnName.equalsIgnoreCase("name")) {
                column.setCellValueFactory(new PropertyValueFactory<>("name"));
            } else {
                column.setCellValueFactory(new PropertyValueFactory<>(columnName));
            }

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
            stage.setOnHidden(e -> {
                Event newEvent = (Event) stage.getUserData();
                System.out.println(newEvent); // Ancien debug
                if (newEvent != null) {
                    tableview_show.getItems().add(newEvent);
                    ObservableList<Event> data_list_Events = FXCollections
                            .observableArrayList(tableview_show.getItems());
                    Stage mainStage = (Stage) tableview_show.getScene().getWindow();
                    mainStage.setUserData(data_list_Events);
                    System.out.println("Event added");
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Delete_Table_Clicked(ActionEvent event) {
        Event selectedEvent = tableview_show.getSelectionModel().getSelectedItem();
        if (selectedEvent != null) {
            tableview_show.getItems().remove(selectedEvent);
            ObservableList<Event> data_list_Events = FXCollections.observableArrayList(tableview_show.getItems());
            Stage mainStage = (Stage) tableview_show.getScene().getWindow();
            mainStage.setUserData(data_list_Events);
            System.out.println("Event deleted");
            error_text.setText("Event deleted");
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
        Event selectedEvent = tableview_show.getSelectionModel().getSelectedItem();
        if (selectedEvent != null) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("popup/popup_add_events.fxml"));
                AnchorPane root = (AnchorPane) fxmlLoader.load();
                Scene scene = new Scene(root);
                scene.getStylesheets().add(App.class.getResource("style.css").toExternalForm());
                Stage stage = new Stage();
                stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(scene);
                stage.show();
                stage.setOnHidden(e -> {
                    Event modifiedEvent = (Event) stage.getUserData();
                    if (modifiedEvent != null) {
                        int selectedIndex = tableview_show.getSelectionModel().getSelectedIndex();
                        tableview_show.getItems().set(selectedIndex, modifiedEvent);
                        ObservableList<Event> data_list_Events = FXCollections
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
