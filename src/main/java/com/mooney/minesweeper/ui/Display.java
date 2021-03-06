package com.mooney.minesweeper.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class Display {

    private static final String MAIN_FRAME_FXML = "assets/fxml/mainFrame.fxml";

    public Scene mainDisplay() {
        var root = (BorderPane) getFxmlResource(MAIN_FRAME_FXML);
        return new Scene(root);
    }

    private Object getFxmlResource(String fxmlName) {
        try {
            var fxml = this.getClass().getClassLoader().getResource(MAIN_FRAME_FXML);
            return FXMLLoader.load(fxml);
        } catch (IOException e) {
            throw new RuntimeException("Failed loading FXML resource", e);
        }
    }
}
