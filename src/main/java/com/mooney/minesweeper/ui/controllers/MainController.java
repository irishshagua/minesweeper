package com.mooney.minesweeper.ui.controllers;

import com.mooney.minesweeper.game.Game;
import com.mooney.minesweeper.models.Cell;
import com.mooney.minesweeper.models.DifficultyLevel;
import com.mooney.minesweeper.models.GameState;
import com.mooney.minesweeper.ui.MineCell;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    private GameState gameState;

    @FXML
    private GridPane gameTiles;

    public void createNewGame() {
        gameState = Game.generateGame(DifficultyLevel.SIMPLE);
        buildGameTiles(gameState.cells());
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
