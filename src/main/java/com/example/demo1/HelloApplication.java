package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        StackPane root = new StackPane();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("GamePlay.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 900, 600);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        Image icon =null;
        try {
            icon = new Image(new FileInputStream("toPutInProject\\coin.jpg"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        stage.getIcons().add(icon);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}