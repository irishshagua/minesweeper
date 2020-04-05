package com.mooney.minesweeper;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        var version = new Version(
            System.getProperty("java.version"),
            System.getProperty("javafx.version")
        );
        var splashMessage = String.format("""
                Splash Page
                                    
                Version Details:
                    Java:   %s
                    JFX:    %s 
                """, version.javaVersion(), version.jfxVersion());
        Label l = new Label(splashMessage);
        Scene scene = new Scene(new StackPane(l), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}