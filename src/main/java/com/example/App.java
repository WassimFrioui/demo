package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import com.example.models.Athlete;
import com.example.models.Discipline;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("start/start"), 740, 480);
        scene.getStylesheets().add(App.class.getResource("style.css").toExternalForm());
        stage.getIcons().add(new Image(App.class.getResourceAsStream("views/images/logo.png")));
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setTitle("Jeux olympiques de Paris 2024");
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.sizeToScene();
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static void closeStage(String string) throws IOException {
        scene.getWindow().hide();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();

    }

}
