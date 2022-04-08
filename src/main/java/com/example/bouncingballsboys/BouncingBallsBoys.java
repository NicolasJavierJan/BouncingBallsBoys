package com.example.bouncingballsboys;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BouncingBallsBoys extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BouncingBallsBoys.class.getResource("balls.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 602, 401);
        stage.setTitle("Bouncing Ball Game");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}