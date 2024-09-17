package com.example.Munster;

import com.example.javafxshell.HelloApplication;
import com.example.javafxshell.SoundHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.image.ImageView;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;
import org.json.JSONArray;

public class ClareMenuController {

    @FXML
    private ImageView backButtonImageView;

    @FXML
    private Label weatherLabel;

    private HelloApplication application;
    private SoundHandler soundHandler;

    @FXML
    public void initialize() {
        loadImages();
        soundHandler = new SoundHandler("/com/example/javafxshell/sounds/click.wav");
        setupBackButton();
        fetchWeatherData();
    }

    private void loadImages() {
        String basePath = "/com/example/javafxshell/images/Munster/";
        backButtonImageView.setImage(new Image(getClass().getResource(basePath + "MunsterBackButton.png").toString()));
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
            application.showMunsterMenu();
        } else {
            System.out.println("Application reference is null");
        }
    }

    public void setApplication(HelloApplication application) {
        this.application = application;
    }

    private void fetchWeatherData() {
        String apiUrl = "https://api.open-meteo.com/v1/forecast?latitude=52.8436&longitude=-8.9864&hourly=temperature_2m,relative_humidity_2m,apparent_temperature,precipitation_probability,precipitation,rain,showers,visibility,wind_speed_10m";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(this::parseWeatherData)
                .exceptionally(e -> {
                    e.printStackTrace();
                    return null;
                });
    }

    private void parseWeatherData(String responseBody) {
        try {
            JSONObject json = new JSONObject(responseBody);
            JSONObject hourly = json.getJSONObject("hourly");

            double temperature = hourly.getJSONArray("temperature_2m").getDouble(0);
            int humidity = hourly.getJSONArray("relative_humidity_2m").getInt(0);
            double apparentTemperature = hourly.getJSONArray("apparent_temperature").getDouble(0);
            int precipitationProbability = hourly.getJSONArray("precipitation_probability").getInt(0);
            double precipitation = hourly.getJSONArray("precipitation").getDouble(0);
            double rain = hourly.getJSONArray("rain").getDouble(0);
            double showers = hourly.getJSONArray("showers").getDouble(0);
            double visibility = hourly.getJSONArray("visibility").getDouble(0);
            double windSpeed = hourly.getJSONArray("wind_speed_10m").getDouble(0);

            String weatherInfo = String.format(
                "Current weather in Ennis:\n\n" +
                "Temperature: %.1f°C\n\n" +
                "Relative Humidity: %d%%\n\n" +
                "Apparent Temperature: %.1f°C\n\n" +
                "Precipitation Probability: %d%%\n\n" +
                "Precipitation: %.2f mm\n\n" +
                "Rain: %.2f mm\n\n" +
                "Showers: %.2f mm\n\n" +
                "Visibility: %.1f meters\n\n" +
                "Wind Speed: %.1f km/h",
                temperature, humidity, apparentTemperature, precipitationProbability,
                precipitation, rain, showers, visibility, windSpeed
            );
    
            javafx.application.Platform.runLater(() -> weatherLabel.setText(weatherInfo));
        } catch (Exception e) {
            e.printStackTrace();
            javafx.application.Platform.runLater(() -> weatherLabel.setText("Weather data unavailable"));
        }
    
    }
}