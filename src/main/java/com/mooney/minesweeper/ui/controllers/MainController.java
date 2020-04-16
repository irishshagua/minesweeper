package com.mooney.minesweeper.ui.controllers;

import com.mooney.minesweeper.game.Game;
import com.mooney.minesweeper.models.Cell;
import com.mooney.minesweeper.models.DifficultyLevel;
import com.mooney.minesweeper.models.GameState;
import com.mooney.minesweeper.ui.components.MineCell;
import com.mooney.minesweeper.ui.components.Timer;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.Set;

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
                gameTiles.add(new MineCell(row[c], this::performCascade), c, r);
            }
        }

        gameTiles.setVisible(true);
    }

    private Boolean performCascade(Set<Cell> cells) {
        for (Cell cell : cells) {
            getMineCellAtCoords(cell.xCoord(), cell.yCoord()).ifPresent(cascadeCell -> cascadeCell.performReveal(false));
        }

        return true;
    }

    private Optional<MineCell> getMineCellAtCoords(int row, int col) {
        for (Node node : gameTiles.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row && node instanceof MineCell mineCell) {
                return Optional.of(mineCell);
            }
        }
        return Optional.empty();
    }
}
