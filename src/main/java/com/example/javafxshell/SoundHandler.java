package com.example.javafxshell;

import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class SoundHandler {
    private MediaPlayer mediaPlayer;

    public SoundHandler(String audioFilePath) {
        Media hoverSound = new Media(getClass().getResource(audioFilePath).toExternalForm());
        mediaPlayer = new MediaPlayer(hoverSound);
        mediaPlayer.setVolume(0.05);  // Set volume to half
    }

    public void playHoverSound() {
        mediaPlayer.stop();  // Stop any currently playing sound
        mediaPlayer.seek(Duration.ZERO);  // Reset the sound to the beginning
        mediaPlayer.play();  // Play the sound
    }

    public void setupHoverSoundEffectForImage(javafx.scene.Node node) {
        node.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> playHoverSound());
    }
}
