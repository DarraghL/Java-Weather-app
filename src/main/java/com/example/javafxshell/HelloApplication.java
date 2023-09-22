package com.example.javafxshell;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        primaryStage.setTitle("Resizable JavaFX App");
        Scene scene = new Scene(root, 950, 975);  // Set the initial dimensions here
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);  // Allow resizing
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
