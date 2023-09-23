package com.example.javafxshell;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.net.MalformedURLException;
import java.io.File;

public class HelloController {



    @FXML
    private ImageView ulsterImageView, munsterImageView, leinsterImageView, connaughtImageView;
    @FXML
    private ImageView ulsterCoAImageView, munsterCoAImageView, leinsterCoAImageView, connaughtCoAImageView;
    @FXML
    private Label weatherLabel;

    private DropShadow highlightEffect = new DropShadow(20, Color.YELLOW);
    private HelloApplication application;

    public void setApplication(HelloApplication application) {
        this.application = application;
    }

    @FXML
    public void initialize() {
        try {
            loadImages();
            setupHoverEffect(ulsterImageView, ulsterCoAImageView, "Ulster");
            setupHoverEffect(munsterImageView, munsterCoAImageView, "Munster");
            setupHoverEffect(leinsterImageView, leinsterCoAImageView, "Leinster");
            setupHoverEffect(connaughtImageView, connaughtCoAImageView, "Connaught");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private void loadImages() throws MalformedURLException {
        ulsterImageView.setImage(loadImage("Ulster.png"));
        munsterImageView.setImage(loadImage("Munster.png"));
        leinsterImageView.setImage(loadImage("Leinster.png"));
        connaughtImageView.setImage(loadImage("Connaught.png"));
    }

    private Image loadImage(String fileName) throws MalformedURLException {
        File file = new File("C:\\Users\\darra\\Desktop\\" + fileName);
        String localUrl = file.toURI().toURL().toString();
        return new Image(localUrl);
    }

    private void setupHoverEffect(ImageView imageView, ImageView coaImageView, String province) {
        imageView.setOnMouseEntered(event -> {
            imageView.setEffect(highlightEffect);

            coaImageView.setVisible(true);
        });
        imageView.setOnMouseExited(event -> {
            imageView.setEffect(null);
            coaImageView.setVisible(false);
        });

        if (province.equals("Connaught")) {
            imageView.setOnMouseClicked(event -> {
                try {
                    application.showConnaughtMenu();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }



}
