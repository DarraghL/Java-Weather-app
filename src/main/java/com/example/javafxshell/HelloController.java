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
import java.io.File;

public class HelloController {

    private Stage stage;

    @FXML
    private ImageView ulsterImageView, munsterImageView, leinsterImageView, connachtImageView,
            ulsterCoAImageView, munsterCoAImageView, leinsterCoAImageView, connachtCoAImageView;

    @FXML
    private Label weatherLabel;

    private DropShadow highlightEffect = new DropShadow(20, Color.YELLOW);

    @FXML
    public void initialize() {
        try {
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
        if (province.equals("Connacht")) {
            imageView.setOnMouseClicked(event -> showConnachtMenu());
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
