package com.mooney.minesweeper.ui.controllers;

import com.mooney.minesweeper.game.Game;
import com.mooney.minesweeper.models.Cell;
import com.mooney.minesweeper.models.DifficultyLevel;
import com.mooney.minesweeper.models.GameState;
import com.mooney.minesweeper.ui.components.MineCell;
import com.mooney.minesweeper.ui.components.Timer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    private GameState gameState;
    private Timer timer;

    @FXML
    private GridPane gameTiles;
    @FXML
    private Label gameTimer;

    public void createNewGame() {
        gameState = Game.generateGame(DifficultyLevel.SIMPLE);
        buildGameTiles(gameState.cells());
        timer = new Timer(gameState.startTime(), gameTimer);
        gameTimer.setVisible(true);
        logger.debug("New game created: {}", gameState);
    }

    private void buildGameTiles(Cell[][] cells) {
        for (int r = 0; r < cells.length; r++) {
            var row = cells[r];
            for (int c = 0; c < row.length; c++) {
                gameTiles.add(new MineCell(row[c]), c, r);
            }
        }

        gameTiles.setVisible(true);
    }
}
