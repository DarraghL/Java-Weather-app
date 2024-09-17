package com.example.javafxshell;

import com.example.Connacht.*;
import javafx.event.ActionEvent;
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
import java.net.URL;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ConnachtMenuController {

    private HelloApplication application;
    private SoundHandler soundHandler;


    @FXML
    private ImageView leitrimImageView, mayoImageView, galwayImageView, roscommonImageView, sligoImageView,
            roscommonButton, sligoButton, mayoButton, leitrimButton, galwayButton, backButtonImageView;


    @FXML
    public void initialize() {
        soundHandler = new SoundHandler("/com/example/javafxshell/sounds/click.wav");
        loadImages();
        setupHoverEffect();
        setupBackButton();

        setupGalwayClickHandler(galwayImageView);
        setupGalwayClickHandler(galwayButton);

        setupMayoClickHandler(mayoImageView);
        setupMayoClickHandler(mayoButton);

        setupRoscommonClickHandler(roscommonImageView);
        setupRoscommonClickHandler(roscommonButton);

        setupLeitrimClickHandler(leitrimImageView);
        setupLeitrimClickHandler(leitrimButton);

        setupSligoClickHandler(sligoImageView);
        setupSligoClickHandler(sligoButton);


    }

    private void loadImages() {
        String basePath = "/com/example/javafxshell/images/Connacht/";

        roscommonImageView.setImage(new Image(getClass().getResource(basePath + "Roscommon.png").toString()));
        mayoImageView.setImage(new Image(getClass().getResource(basePath + "Mayo.png").toString()));
        leitrimImageView.setImage(new Image(getClass().getResource(basePath + "Leitrim.png").toString()));
        sligoImageView.setImage(new Image(getClass().getResource(basePath + "Sligo.png").toString()));
        galwayImageView.setImage(new Image(getClass().getResource(basePath + "Galway.png").toString()));

        roscommonButton.setImage(new Image(getClass().getResource(basePath + "RoscommonButton.png").toString()));
        sligoButton.setImage(new Image(getClass().getResource(basePath + "SligoButton.png").toString()));
        mayoButton.setImage(new Image(getClass().getResource(basePath + "mayoButton.png").toString()));
        leitrimButton.setImage(new Image(getClass().getResource(basePath + "LeitrimButton.png").toString()));
        galwayButton.setImage(new Image(getClass().getResource(basePath + "GalwayButton.png").toString()));

        backButtonImageView.setImage(new Image(getClass().getResource(basePath + "BackButton.png").toString()));

    }

    private void setupHoverEffect() {
        DropShadow highlightEffect = new DropShadow(20, Color.YELLOW);

        Map<ImageView, ImageView> associations = new HashMap<>();
        associations.put(roscommonButton, roscommonImageView);
        associations.put(sligoButton, sligoImageView);
        associations.put(mayoButton, mayoImageView);
        associations.put(leitrimButton, leitrimImageView);
        associations.put(galwayButton, galwayImageView);

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




    private void setupGalwayClickHandler(ImageView imageView) {
        imageView.setOnMouseClicked(event -> {
            try {

                URL fxmlLocation = getClass().getResource("/com/example/javafxshell/connachtFxml/GalwayMenu.fxml");
                FXMLLoader loader = new FXMLLoader(fxmlLocation);
                Parent galwayMenu = loader.load();

                GalwayMenuController galwayMenuController = loader.getController();
                galwayMenuController.setApplication(this.application); // Assuming this.application is a reference to HelloApplication

                Scene scene = new Scene(galwayMenu);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void setupMayoClickHandler(ImageView imageView) {
        imageView.setOnMouseClicked(event -> {
            try {
                URL fxmlLocation = getClass().getResource("/com/example/javafxshell/connachtFxml/MayoMenu.fxml");
                FXMLLoader loader = new FXMLLoader(fxmlLocation);
                Parent mayoMenu = loader.load();

                MayoMenuController mayoMenuController = loader.getController();
                mayoMenuController.setApplication(this.application);

                Scene scene = new Scene(mayoMenu);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }



    private void setupLeitrimClickHandler(ImageView imageView) {
        imageView.setOnMouseClicked(event -> {
            try {
                URL fxmlLocation = getClass().getResource("/com/example/javafxshell/connachtFxml/LeitrimMenu.fxml");
                FXMLLoader loader = new FXMLLoader(fxmlLocation);
                Parent leitrimMenu = loader.load();

                LeitrimMenuController leitrimMenuController = loader.getController();
                leitrimMenuController.setApplication(this.application);

                Scene scene = new Scene(leitrimMenu);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }


    private void setupSligoClickHandler(ImageView imageView) {
        imageView.setOnMouseClicked(event -> {
            try {
                URL fxmlLocation = getClass().getResource("/com/example/javafxshell/connachtFxml/SligoMenu.fxml");
                FXMLLoader loader = new FXMLLoader(fxmlLocation);
                Parent sligoMenu = loader.load();

                SligoMenuController sligoMenuController = loader.getController();
                sligoMenuController.setApplication(this.application);

                Scene scene = new Scene(sligoMenu);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }


    private void setupRoscommonClickHandler(ImageView imageView) {
        imageView.setOnMouseClicked(event -> {
            try {
                URL fxmlLocation = getClass().getResource("/com/example/javafxshell/connachtFxml/RoscommonMenu.fxml");
                FXMLLoader loader = new FXMLLoader(fxmlLocation);
                Parent roscommonMenu = loader.load();

                RoscommonMenuController roscommonMenuController = loader.getController();
                roscommonMenuController.setApplication(this.application);

                Scene scene = new Scene(roscommonMenu);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}




