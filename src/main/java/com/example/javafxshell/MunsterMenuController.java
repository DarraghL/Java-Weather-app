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

public class MunsterMenuController {

    private HelloApplication application;
    private SoundHandler soundHandler;


    @FXML
    private ImageView tipperaryImageView, waterfordImageView, kerryImageView, clareImageView, corkImageView, limerickImageView,
            tipperaryButton, waterfordButton, kerryButton, clareButton, corkButton, limerickButton, backButtonImageView;



    @FXML
    public void initialize() {
        soundHandler = new SoundHandler("/com/example/javafxshell/sounds/click.wav");
        loadImages();
        setupHoverEffect();
        setupBackButton();
        setupCountyClickHandler(tipperaryImageView, "Tipperary");
        setupCountyClickHandler(tipperaryButton, "Tipperary");
        setupCountyClickHandler(corkImageView, "Cork");
        setupCountyClickHandler(corkButton, "Cork");
        setupCountyClickHandler(kerryImageView, "Kerry");
        setupCountyClickHandler(kerryButton, "Kerry");
        setupCountyClickHandler(waterfordImageView, "Waterford");
        setupCountyClickHandler(waterfordButton, "Waterford");
        setupCountyClickHandler(clareImageView, "Clare");
        setupCountyClickHandler(clareButton, "Clare");
        setupCountyClickHandler(limerickImageView, "Limerick");
        setupCountyClickHandler(limerickButton, "Limerick");
        
    }

    private void loadImages() {
        String basePath = "/com/example/javafxshell/images/Munster/";

        tipperaryImageView.setImage(new Image(getClass().getResource(basePath + "Tipperary.png").toString()));
        waterfordImageView.setImage(new Image(getClass().getResource(basePath + "Waterford.png").toString()));
        kerryImageView.setImage(new Image(getClass().getResource(basePath + "Kerry.png").toString()));
        clareImageView.setImage(new Image(getClass().getResource(basePath + "Clare.png").toString()));
        corkImageView.setImage(new Image(getClass().getResource(basePath + "Cork.png").toString()));
        limerickImageView.setImage(new Image(getClass().getResource(basePath + "Limerick.png").toString()));

        tipperaryButton.setImage(new Image(getClass().getResource(basePath + "TipperaryButton.png").toString()));
        waterfordButton.setImage(new Image(getClass().getResource(basePath + "WaterfordButton.png").toString()));
        kerryButton.setImage(new Image(getClass().getResource(basePath + "KerryButton.png").toString()));
        clareButton.setImage(new Image(getClass().getResource(basePath + "ClareButton.png").toString()));
        corkButton.setImage(new Image(getClass().getResource(basePath + "CorkButton.png").toString()));
        limerickButton.setImage(new Image(getClass().getResource(basePath + "LimerickButton.png").toString()));

        backButtonImageView.setImage(new Image(getClass().getResource(basePath + "BackButton.png").toString()));


    }

    private void setupHoverEffect() {
        DropShadow highlightEffect = new DropShadow(20, Color.YELLOW);

        Map<ImageView, ImageView> associations = new HashMap<>();
        associations.put(tipperaryButton, tipperaryImageView);
        associations.put(waterfordButton, waterfordImageView);
        associations.put(kerryButton, kerryImageView);
        associations.put(clareButton, clareImageView);
        associations.put(corkButton, corkImageView);
        associations.put(limerickButton, limerickImageView);


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
                String fxmlFile = String.format("/com/example/javafxshell/munsterFxml/%sMenu.fxml", countyName);
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

