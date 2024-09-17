package com.example.javafxshell;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import com.example.Munster.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class UlsterMenuController {

    private HelloApplication application;
    private SoundHandler soundHandler;



    @FXML
    private ImageView antrimImageView, armaghImageView, cavanImageView, downImageView, fermanaghImageView, monaghanImageView,
            derryImageView, tyroneImageView, donegalImageView, backButtonImageView, antrimButton, armaghButton, downButton, donegalButton,
            fermanaghButton, derryButton, tyroneButton, monaghanButton, cavanButton;




    @FXML
    public void initialize() {
        soundHandler = new SoundHandler("/com/example/javafxshell/sounds/click.wav");
        loadImages();
        setupHoverEffect();
        setupBackButton();

        setupCountyClickHandler(antrimImageView, "Antrim");
        setupCountyClickHandler(antrimButton, "Antrim");
        setupCountyClickHandler(armaghImageView, "Armagh");
        setupCountyClickHandler(armaghButton, "Armagh");
        setupCountyClickHandler(cavanImageView, "Cavan");
        setupCountyClickHandler(cavanButton, "Cavan");
        setupCountyClickHandler(derryImageView, "Derry");
        setupCountyClickHandler(derryButton, "Derry");
        setupCountyClickHandler(downImageView, "Down");
        setupCountyClickHandler(downButton, "Down");
        setupCountyClickHandler(donegalImageView, "Donegal");
        setupCountyClickHandler(donegalButton, "Donegal");
        setupCountyClickHandler(fermanaghImageView, "Fermanagh");
        setupCountyClickHandler(fermanaghButton, "Fermanagh");
        setupCountyClickHandler(monaghanImageView, "Monaghan");
        setupCountyClickHandler(monaghanButton, "Monaghan");
        setupCountyClickHandler(tyroneImageView, "Tyrone");
        setupCountyClickHandler(tyroneButton, "Tyrone");

    }

    private void loadImages() {
        String basePath = "/com/example/javafxshell/images/Ulster/";

        antrimImageView.setImage(new Image(getClass().getResource(basePath + "Antrim.png").toString()));
        armaghImageView.setImage(new Image(getClass().getResource(basePath + "Armagh.png").toString()));
        derryImageView.setImage(new Image(getClass().getResource(basePath + "Derry.png").toString()));
        downImageView.setImage(new Image(getClass().getResource(basePath + "Down.png").toString()));
        donegalImageView.setImage(new Image(getClass().getResource(basePath + "Donegal.png").toString()));
        fermanaghImageView.setImage(new Image(getClass().getResource(basePath + "Fermanagh.png").toString()));
        cavanImageView.setImage(new Image(getClass().getResource(basePath + "Cavan.png").toString()));
        monaghanImageView.setImage(new Image(getClass().getResource(basePath + "Monaghan.png").toString()));
        tyroneImageView.setImage(new Image(getClass().getResource(basePath + "Tyrone.png").toString()));

        antrimButton.setImage(new Image(getClass().getResource(basePath + "AntrimButton.png").toString()));
        armaghButton.setImage(new Image(getClass().getResource(basePath + "ArmaghButton.png").toString()));
        donegalButton.setImage(new Image(getClass().getResource(basePath + "DonegalButton.png").toString()));
        downButton.setImage(new Image(getClass().getResource(basePath + "DownButton.png").toString()));
        fermanaghButton.setImage(new Image(getClass().getResource(basePath + "FermanaghButton.png").toString()));
        derryButton.setImage(new Image(getClass().getResource(basePath + "DerryButton.png").toString()));
        monaghanButton.setImage(new Image(getClass().getResource(basePath + "MonaghanButton.png").toString()));
        cavanButton.setImage(new Image(getClass().getResource(basePath + "CavanButton.png").toString()));
        tyroneButton.setImage(new Image(getClass().getResource(basePath + "TyroneButton.png").toString()));

        backButtonImageView.setImage(new Image(getClass().getResource(basePath + "BackButton.png").toString()));
    }

    private void setupHoverEffect() {
        DropShadow highlightEffect = new DropShadow(20, Color.YELLOW);

        Map<ImageView, ImageView> associations = new HashMap<>();
        associations.put(antrimButton, antrimImageView);
        associations.put(armaghButton, armaghImageView);
        associations.put(downButton, downImageView);
        associations.put(fermanaghButton, fermanaghImageView);
        associations.put(derryButton, derryImageView);
        associations.put(tyroneButton, tyroneImageView);
        associations.put(donegalButton, donegalImageView);
        associations.put(cavanButton, cavanImageView);
        associations.put(monaghanButton, monaghanImageView);


        for (Map.Entry<ImageView, ImageView> entry : associations.entrySet()) {
            ImageView button = entry.getKey();
            ImageView imageView = entry.getValue();

            EventHandler<MouseEvent> mouseEnteredHandler = event -> {
                button.setEffect(highlightEffect);
                imageView.setEffect(highlightEffect);
                soundHandler.playHoverSound();
            };

            EventHandler<MouseEvent> mouseExitedHandler = event -> {
                button.setEffect(null);
                imageView.setEffect(null);
            };

            button.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEnteredHandler);
            button.addEventHandler(MouseEvent.MOUSE_EXITED, mouseExitedHandler);
            imageView.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEnteredHandler);
            imageView.addEventHandler(MouseEvent.MOUSE_EXITED, mouseExitedHandler);
        }

        // Separate handlers for backButtonImageView
        EventHandler<MouseEvent> backBtnMouseEnteredHandler = event -> {
            backButtonImageView.setEffect(highlightEffect);
            soundHandler.playHoverSound(); // assuming you also want the sound here
        };

        EventHandler<MouseEvent> backBtnMouseExitedHandler = event -> {
            backButtonImageView.setEffect(null);
        };

        backButtonImageView.addEventHandler(MouseEvent.MOUSE_ENTERED, backBtnMouseEnteredHandler);
        backButtonImageView.addEventHandler(MouseEvent.MOUSE_EXITED, backBtnMouseExitedHandler);
    }

    private void setupBackButton() {
        DropShadow highlightEffect = new DropShadow(20, Color.YELLOW);

        backButtonImageView.setOnMouseEntered(event -> {
            backButtonImageView.setEffect(highlightEffect);
            soundHandler.playHoverSound();
        });

        backButtonImageView.setOnMouseExited(event -> backButtonImageView.setEffect(null));
        backButtonImageView.setOnMouseClicked(event -> handleBackButtonClick());
    }

    private void handleBackButtonClick() {
        if (application != null) {
            application.showMainMenu();
        } else {
            System.out.println("Application is null");
        }
    }


    public void setApplication(HelloApplication application) {
        this.application = application;
    }

     private void setupCountyClickHandler(ImageView imageView, String countyName) {
        imageView.setOnMouseClicked(event -> {
            try {
                String fxmlFile = String.format("/com/example/javafxshell/ulsterFxml/%sMenu.fxml", countyName);
                URL fxmlLocation = getClass().getResource(fxmlFile);
                FXMLLoader loader = new FXMLLoader(fxmlLocation);
                Parent countyMenu = loader.load();

                Object countyMenuController = loader.getController();
                Method setApplicationMethod = countyMenuController.getClass().getMethod("setApplication", HelloApplication.class);
                setApplicationMethod.invoke(countyMenuController, this.application);

                Scene scene = new Scene(countyMenu);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });
    }
}