package com.example.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;

import com.example.App;

public class Start_controller {
    @FXML
    private ProgressBar progressbar;

    public void initialize() {
        progressbar.setProgress(0.1);

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(progressbar.progressProperty(), 0)),
                new KeyFrame(Duration.seconds(1), new KeyValue(progressbar.progressProperty(), 1)));
        timeline.setOnFinished(event -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("dashboard.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.getIcons().add(new Image(App.class.getResourceAsStream("views/images/logo.png")));
                stage.setTitle("Jeux olympiques de Paris 2024");
                stage.centerOnScreen();
                stage.setScene(scene);
                stage.setWidth(1200);
                stage.setHeight(800);
                stage.show();

                App.closeStage("start/start");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        timeline.play();
    }

}
