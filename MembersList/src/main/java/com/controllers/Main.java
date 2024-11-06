package com.controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

public class Main extends Application {

    public double x, y = 0;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root;
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
        Scene sc = new Scene(root);
        stage.initStyle(StageStyle.UNDECORATED);

        root.setOnMousePressed(evt -> {
            x = evt.getSceneX();
            y = evt.getSceneY();
        });

        root.setOnMouseDragged(evt -> {
            stage.setX(evt.getScreenX() - x);
            stage.setY(evt.getScreenY() - y);
        });

        stage.setScene(sc);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}