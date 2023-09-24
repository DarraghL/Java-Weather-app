package com.example.javafxshell;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ConnachtMenuController {

    private HelloApplication application;

    public void setApplication(HelloApplication application) {
        this.application = application;
    }

    @FXML
    public void goBack(ActionEvent event) {
        application.showMainMenu();
    }
}
