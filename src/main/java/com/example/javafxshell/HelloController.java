package com.example.javafxshell;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class HelloController {
    private Stage stage;
    private HelloApplication application;
    private SoundHandler soundHandler;

    public void setApplication(HelloApplication application) {
        this.application = application;
    }

    @FXML
    private ImageView ulsterImageView, munsterImageView, leinsterImageView, connachtImageView,
            ulsterCoAImageView, munsterCoAImageView, leinsterCoAImageView, connachtCoAImageView;

    @FXML
    private Label weatherLabel;

    private DropShadow highlightEffect = new DropShadow(20, Color.YELLOW);

    @FXML
    public void initialize() {
        try {
            soundHandler = new SoundHandler("/com/example/javafxshell/sounds/click.wav"); // Assuming the audio file path
            loadImages();
            setupHoverEffect(ulsterImageView, ulsterCoAImageView, "Ulster");
            setupHoverEffect(munsterImageView, munsterCoAImageView, "Munster");
            setupHoverEffect(leinsterImageView, leinsterCoAImageView, "Leinster");
            setupHoverEffect(connachtImageView, connachtCoAImageView, "Connacht");

            DropShadow borderGlow = new DropShadow();
            borderGlow.setColor(Color.BLACK);
            borderGlow.setOffsetX(1.0);
            borderGlow.setOffsetY(1.0);
            weatherLabel.setEffect(borderGlow);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private Image loadImage(String fileName) {
        String path = "/com/example/javafxshell/images/Main/" + fileName;
        URL url = getClass().getResource(path);
        if (url == null) {
            throw new IllegalArgumentException("Resource not found: " + path);
        }
        return new Image(url.toString());
    }

    private void setupHoverEffect(ImageView imageView, ImageView coaImageView, String province) {
        soundHandler.setupHoverSoundEffectForImage(imageView);  // Set up hover sound effect

        imageView.setOnMouseEntered(event -> {
            imageView.setEffect(highlightEffect);
            coaImageView.setVisible(true);
        });
        imageView.setOnMouseExited(event -> {
            imageView.setEffect(null);
            coaImageView.setVisible(false);
        });
        if (province.equals("Connacht")) {
            imageView.setOnMouseClicked(event -> showConnachtMenu());
        }
        if (province.equals("Munster")) {
            imageView.setOnMouseClicked(event -> showMunsterMenu());
        }
        if (province.equals("Leinster")) {
            imageView.setOnMouseClicked(event -> showLeinsterMenu());
        }
        if (province.equals("Ulster")) {
            imageView.setOnMouseClicked(event -> showUlsterMenu());
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private void showConnachtMenu() {
        try {
            if (stage != null) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("connachtMenu.fxml"));
                Parent root = loader.load();
                ConnachtMenuController connachtMenuController = loader.getController();
                connachtMenuController.setApplication(application); // Pass the application instance
                stage.setScene(new Scene(root));
            } else {
                System.err.println("Stage is null");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void showMunsterMenu() {
        try {
            if (stage != null) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("munsterMenu.fxml"));
                Parent root = loader.load();
                MunsterMenuController munsterMenuController = loader.getController();
                munsterMenuController.setApplication(application); // Pass the application instance
                stage.setScene(new Scene(root));
            } else {
                System.err.println("Stage is null");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showLeinsterMenu() {
        try {
            if (stage != null) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("leinsterMenu.fxml"));
                Parent root = loader.load();
                LeinsterMenuController leinsterMenuController = loader.getController();
                leinsterMenuController.setApplication(application); // Pass the application instance
                stage.setScene(new Scene(root));
            } else {
                System.err.println("Stage is null");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showUlsterMenu() {
        try {
            if (stage != null) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ulsterMenu.fxml"));
                Parent root = loader.load();
                UlsterMenuController ulsterMenuController = loader.getController();
                ulsterMenuController.setApplication(application); // Pass the application instance
                stage.setScene(new Scene(root));
            } else {
                System.err.println("Stage is null");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadImages() throws MalformedURLException {
        ulsterImageView.setImage(loadImage("Ulster.png"));
        munsterImageView.setImage(loadImage("Munster.png"));
        leinsterImageView.setImage(loadImage("Leinster.png"));
        connachtImageView.setImage(loadImage("Connacht.png"));

        ulsterCoAImageView.setImage(loadImage("UlsterCoA.png"));
        munsterCoAImageView.setImage(loadImage("MunsterCoA.png"));
        leinsterCoAImageView.setImage(loadImage("LeinsterCoA.png"));
        connachtCoAImageView.setImage(loadImage("ConnachtCoA.png"));

        ulsterCoAImageView.setVisible(false);
        munsterCoAImageView.setVisible(false);
        leinsterCoAImageView.setVisible(false);
        connachtCoAImageView.setVisible(false);
    }


}
