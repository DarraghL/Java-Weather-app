package com.example.javafxshell;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private Stage stage;

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        showMainMenu();
    }

    public void showMainMenu() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            HelloController controller = fxmlLoader.getController();
            controller.setApplication(this);  // This line is important
            stage.setTitle("Main Menu");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showConnaughtMenu() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("connaughtMenu.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Connaught Menu");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
