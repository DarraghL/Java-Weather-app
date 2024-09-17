package com.example.javafxshell;

import com.example.Leinster.*;
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

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class LeinsterMenuController {

    private HelloApplication application;


    private SoundHandler soundHandler;




    @FXML
    private ImageView carlowImageView, dublinImageView, kildareImageView, kilkennyImageView,
            laoisImageView, longfordImageView, louthImageView, meathImageView, offalyImageView,
            westmeathImageView, wexfordImageView, wicklowImageView, backButtonImageView,
            carlowButton, dublinButton, kildareButton, kilkennyButton, laoisButton, longfordButton,
            louthButton, meathButton, offalyButton, westmeathButton, wexfordButton, wicklowButton;




    @FXML
    public void initialize() {
        soundHandler = new SoundHandler("/com/example/javafxshell/sounds/click.wav");
        loadImages();
        setupHoverEffect();
        setupBackButton();

        setupCountyClickHandler(carlowImageView, "Carlow");
        setupCountyClickHandler(carlowButton, "Carlow");
        setupCountyClickHandler(dublinImageView, "Dublin");
        setupCountyClickHandler(dublinButton, "Dublin");
        setupCountyClickHandler(kildareImageView, "Kildare");
        setupCountyClickHandler(kildareButton, "Kildare");
        setupCountyClickHandler(kilkennyImageView, "Kilkenny");
        setupCountyClickHandler(kilkennyButton, "Kilkenny");
        setupCountyClickHandler(laoisImageView, "Laois");
        setupCountyClickHandler(laoisButton, "Laois");
        setupCountyClickHandler(longfordImageView, "Longford");
        setupCountyClickHandler(longfordButton, "Longford");
        setupCountyClickHandler(louthImageView, "Louth");
        setupCountyClickHandler(louthButton, "Louth");
        setupCountyClickHandler(meathImageView, "Meath");
        setupCountyClickHandler(meathButton, "Meath");
        setupCountyClickHandler(offalyImageView, "Offaly");
        setupCountyClickHandler(offalyButton, "Offaly");
        setupCountyClickHandler(westmeathImageView, "Westmeath");
        setupCountyClickHandler(westmeathButton, "Westmeath");
        setupCountyClickHandler(wexfordImageView, "Wexford");
        setupCountyClickHandler(wexfordButton, "Wexford");
        setupCountyClickHandler(wicklowImageView, "Wicklow");
        setupCountyClickHandler(wicklowButton, "Wicklow");
    }

    private void loadImages() {
        String basePath = "/com/example/javafxshell/images/Leinster/";

        carlowImageView.setImage(new Image(getClass().getResource(basePath + "Carlow.png").toString()));
        dublinImageView.setImage(new Image(getClass().getResource(basePath + "Dublin.png").toString()));
        kildareImageView.setImage(new Image(getClass().getResource(basePath + "Kildare.png").toString()));
        kilkennyImageView.setImage(new Image(getClass().getResource(basePath + "Kilkenny.png").toString()));
        laoisImageView.setImage(new Image(getClass().getResource(basePath + "Laois.png").toString()));
        longfordImageView.setImage(new Image(getClass().getResource(basePath + "Longford.png").toString()));
        louthImageView.setImage(new Image(getClass().getResource(basePath + "Louth.png").toString()));
        meathImageView.setImage(new Image(getClass().getResource(basePath + "Meath.png").toString()));
        offalyImageView.setImage(new Image(getClass().getResource(basePath + "Offaly.png").toString()));
        westmeathImageView.setImage(new Image(getClass().getResource(basePath + "Westmeath.png").toString()));
        wexfordImageView.setImage(new Image(getClass().getResource(basePath + "Wexford.png").toString()));
        wicklowImageView.setImage(new Image(getClass().getResource(basePath + "Wicklow.png").toString()));


        carlowButton.setImage(new Image(getClass().getResource(basePath + "CarlowButton.png").toString()));
        dublinButton.setImage(new Image(getClass().getResource(basePath + "DublinButton.png").toString()));
        kildareButton.setImage(new Image(getClass().getResource(basePath + "KildareButton.png").toString()));
        kilkennyButton.setImage(new Image(getClass().getResource(basePath + "KilkennyButton.png").toString()));
        laoisButton.setImage(new Image(getClass().getResource(basePath + "LaoisButton.png").toString()));
        longfordButton.setImage(new Image(getClass().getResource(basePath + "LongfordButton.png").toString()));
        louthButton.setImage(new Image(getClass().getResource(basePath + "LouthButton.png").toString()));
        meathButton.setImage(new Image(getClass().getResource(basePath + "MeathButton.png").toString()));
        offalyButton.setImage(new Image(getClass().getResource(basePath + "OffalyButton.png").toString()));
        westmeathButton.setImage(new Image(getClass().getResource(basePath + "WestmeathButton.png").toString()));
        wexfordButton.setImage(new Image(getClass().getResource(basePath + "WexfordButton.png").toString()));
        wicklowButton.setImage(new Image(getClass().getResource(basePath + "WicklowButton.png").toString()));

        backButtonImageView.setImage(new Image(getClass().getResource(basePath + "BackButton.png").toString()));
    }

    private void setupHoverEffect() {
        DropShadow highlightEffect = new DropShadow(20, Color.YELLOW);

        Map<ImageView, ImageView> associations = new HashMap<>();
        associations.put(carlowButton, carlowImageView);
        associations.put(dublinButton, dublinImageView);
        associations.put(kildareButton, kildareImageView);
        associations.put(kilkennyButton, kilkennyImageView);
        associations.put(laoisButton, laoisImageView);
        associations.put(longfordButton, longfordImageView);
        associations.put(louthButton, louthImageView);
        associations.put(meathButton, meathImageView);
        associations.put(offalyButton, offalyImageView);
        associations.put(westmeathButton, westmeathImageView);
        associations.put(wexfordButton, wexfordImageView);
        associations.put(wicklowButton, wicklowImageView);

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



    //Click handlers




    // Define the method with a method body
    private void setupCountyClickHandler(ImageView imageView, String countyName) {
        imageView.setOnMouseClicked(event -> {
            try {
                String fxmlFile = String.format("/com/example/javafxshell/leinsterFxml/%sMenu.fxml", countyName);
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

