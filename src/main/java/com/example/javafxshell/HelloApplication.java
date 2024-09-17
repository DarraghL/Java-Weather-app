package com.example.javafxshell;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {

    private Stage stage;
    private final int WIDTH = 1880;
    private final int HEIGHT = 1000;

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        stage.setWidth(WIDTH);
        stage.setHeight(HEIGHT);
        stage.setResizable(false);
        showMainMenu();
    }

    public void showMainMenu() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), WIDTH, HEIGHT);
            stage.setTitle("Main Menu");
            stage.setScene(scene);
            stage.show();

            HelloController controller = fxmlLoader.getController();
            if (controller != null) {
                controller.setStage(stage);
                controller.setApplication(this);
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
            Scene scene = new Scene(fxmlLoader.load(), WIDTH, HEIGHT);
            stage.setTitle("Connacht Menu");
            stage.setScene(scene);
            stage.show();

            ConnachtMenuController controller = fxmlLoader.getController();
            if (controller != null) {
                controller.setApplication(this);
            } else {
                System.err.println("Controller is null");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showLeinsterMenu() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("leinsterMenu.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), WIDTH, HEIGHT);
            stage.setTitle("Leinster Menu");
            stage.setScene(scene);
            stage.show();

            LeinsterMenuController controller = fxmlLoader.getController();
            if (controller != null) {
                controller.setApplication(this);
            } else {
                System.err.println("Controller is null");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showMunsterMenu() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("munsterMenu.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), WIDTH, HEIGHT);
            stage.setTitle("Munster Menu");
            stage.setScene(scene);
            stage.show();

            MunsterMenuController controller = fxmlLoader.getController();
            if (controller != null) {
                controller.setApplication(this);
            } else {
                System.err.println("Controller is null");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showUlsterMenu() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ulsterMenu.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), WIDTH, HEIGHT);
            stage.setTitle("Ulster Menu");
            stage.setScene(scene);
            stage.show();

            UlsterMenuController controller = fxmlLoader.getController();
            if (controller != null) {
                controller.setApplication(this);
            } else {
                System.err.println("Controller is null");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}