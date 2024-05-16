package com.example.controllers;

import java.io.IOException;

import com.example.App;
import com.example.controllers.dashboard.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Dashboard_Controller {

        @FXML
        private BorderPane borderpane_dashboard;

        @FXML
        private Button button_analytiques;

        @FXML
        private Button button_athletes;

        @FXML
        private Button button_disciplines;

        @FXML
        private Button button_events;

        @FXML
        private Button button_help;

        @FXML
        private Button button_overview;

        @FXML
        private Button button_settings;

        @FXML
        public void initialize() {
                try {
                        FXMLLoader fxmlLoader = new FXMLLoader(
                                        App.class.getResource("dashboard/athlete_anchorpane.fxml"));
                        fxmlLoader.setController(new Athlete_table());
                        AnchorPane view = fxmlLoader.load();
                        view.getStylesheets().add(App.class.getResource("style.css").toExternalForm());
                        view.setPrefWidth(1000);
                        view.setPrefHeight(760);
                        borderpane_dashboard.setCenter(view);

                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

        @FXML
        void Overview_Clicked(ActionEvent event) {
                try {
                        FXMLLoader fxmlLoader = new FXMLLoader(
                                        App.class.getResource("dashboard/athlete_anchorpane.fxml"));
                        fxmlLoader.setController(new Overview_table());
                        AnchorPane view = fxmlLoader.load();
                        view.getStylesheets().add(App.class.getResource("style.css").toExternalForm());
                        view.setPrefWidth(1000);
                        view.setPrefHeight(760);
                        borderpane_dashboard.setCenter(view);
                        button_overview
                                        .setStyle(
                                                        "-fx-border-width: 0 5px 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_analytiques
                                        .setStyle(
                                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_athletes.setStyle(
                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_disciplines
                                        .setStyle(
                                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_events.setStyle(
                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_help.setStyle(
                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_settings.setStyle(
                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_analytiques.setStyle(
                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

        @FXML
        void Athletes_Clicked(ActionEvent event) {
                try {
                        FXMLLoader fxmlLoader = new FXMLLoader(
                                        App.class.getResource("dashboard/athlete_anchorpane.fxml"));
                        fxmlLoader.setController(new Athlete_table());
                        AnchorPane view = fxmlLoader.load();
                        view.getStylesheets().add(App.class.getResource("style.css").toExternalForm());
                        view.setPrefWidth(1000);
                        view.setPrefHeight(760);
                        borderpane_dashboard.setCenter(view);
                        button_athletes
                                        .setStyle(
                                                        "-fx-border-width: 0 5px 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_overview.setStyle(
                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_disciplines
                                        .setStyle(
                                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_events.setStyle(
                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_help.setStyle(
                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_settings.setStyle(
                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_analytiques.setStyle(
                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

        @FXML
        void Disciplines_Clicked(ActionEvent event) {
                try {
                        FXMLLoader fxmlLoader = new FXMLLoader(
                                        App.class.getResource("dashboard/athlete_anchorpane.fxml"));
                        fxmlLoader.setController(new Disciplines_table());
                        AnchorPane view = fxmlLoader.load();
                        view.getStylesheets().add(App.class.getResource("style.css").toExternalForm());
                        view.setPrefWidth(1000);
                        view.setPrefHeight(760);
                        borderpane_dashboard.setCenter(view);
                        button_disciplines
                                        .setStyle(
                                                        "-fx-border-width: 0 5px 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_overview.setStyle(
                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_athletes.setStyle(
                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_events.setStyle(
                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_help.setStyle(
                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_settings.setStyle(
                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_analytiques.setStyle(
                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

        @FXML
        void Events_Clicked(ActionEvent event) {
                try {
                        FXMLLoader fxmlLoader = new FXMLLoader(
                                        App.class.getResource("dashboard/athlete_anchorpane.fxml"));
                        fxmlLoader.setController(new Events_table());
                        AnchorPane view = fxmlLoader.load();
                        view.getStylesheets().add(App.class.getResource("style.css").toExternalForm());
                        view.setPrefWidth(1000);
                        view.setPrefHeight(760);
                        borderpane_dashboard.setCenter(view);
                        button_events.setStyle(
                                        "-fx-border-width: 0 5px 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_overview.setStyle(
                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_athletes.setStyle(
                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_disciplines
                                        .setStyle(
                                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_help.setStyle(
                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_settings.setStyle(
                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_analytiques.setStyle(
                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

        @FXML
        void Analytiques_Clicked(ActionEvent event) {
                try {
                        FXMLLoader fxmlLoader = new FXMLLoader(
                                        App.class.getResource("dashboard/athlete_anchorpane.fxml"));
                        fxmlLoader.setController(new Analytiques_table());
                        AnchorPane view = fxmlLoader.load();
                        view.getStylesheets().add(App.class.getResource("style.css").toExternalForm());
                        view.setPrefWidth(1000);
                        view.setPrefHeight(760);
                        borderpane_dashboard.setCenter(view);
                        button_analytiques
                                        .setStyle(
                                                        "-fx-border-width: 0 5px 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_overview.setStyle(
                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_athletes.setStyle(
                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_disciplines
                                        .setStyle(
                                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_events.setStyle(
                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_help.setStyle(
                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_settings.setStyle(
                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

        @FXML
        void Help_Clicked(ActionEvent event) {
                try {
                        FXMLLoader fxmlLoader = new FXMLLoader(
                                        App.class.getResource("dashboard/athlete_anchorpane.fxml"));
                        fxmlLoader.setController(new Help_table());
                        AnchorPane view = fxmlLoader.load();
                        view.getStylesheets().add(App.class.getResource("style.css").toExternalForm());
                        view.setPrefWidth(1000);
                        view.setPrefHeight(760);
                        borderpane_dashboard.setCenter(view);
                        button_help.setStyle(
                                        "-fx-border-width: 0 5px 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_overview.setStyle(
                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_analytiques
                                        .setStyle(
                                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_athletes.setStyle(
                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_disciplines
                                        .setStyle(
                                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_events.setStyle(
                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_settings.setStyle(
                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_analytiques.setStyle(
                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

        @FXML
        void Settings_Clicked(ActionEvent event) {
                try {
                        FXMLLoader fxmlLoader = new FXMLLoader(
                                        App.class.getResource("dashboard/athlete_anchorpane.fxml"));
                        fxmlLoader.setController(new Settings_table());
                        AnchorPane view = fxmlLoader.load();
                        view.getStylesheets().add(App.class.getResource("style.css").toExternalForm());
                        view.setPrefWidth(1000);
                        view.setPrefHeight(760);
                        borderpane_dashboard.setCenter(view);
                        button_settings
                                        .setStyle(
                                                        "-fx-border-width: 0 5px 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_overview.setStyle(
                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_analytiques
                                        .setStyle(
                                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_athletes.setStyle(
                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_disciplines
                                        .setStyle(
                                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_events.setStyle(
                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_help.setStyle(
                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                        button_analytiques.setStyle(
                                        "-fx-border-width: 0 0 0 0; -fx-background-color: transparent; -fx-border-color: #D7C378; -fx-border-style: solid;");
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

}
