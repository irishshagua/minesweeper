package com.mooney.minesweeper;

import com.mooney.minesweeper.ui.Display;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        var mainDisplay = new Display().mainDisplay();
        stage.setScene(mainDisplay);
        stage.setTitle("Minesweeper");
        stage.show();
    }
}