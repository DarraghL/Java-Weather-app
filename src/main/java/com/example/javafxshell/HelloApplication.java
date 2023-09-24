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
            stage.setTitle("Main Menu");
            stage.setScene(scene);
            stage.show();

            HelloController controller = fxmlLoader.getController();
            if (controller != null) {
                controller.setStage(stage);
            } else {
                System.err.println("Controller is null");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showConnachtMenu() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("connachtMenu.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Connacht Menu");
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
