package com.mooney.minesweeper.game;

import com.mooney.minesweeper.models.Cell;
import com.mooney.minesweeper.models.DifficultyLevel;
import com.mooney.minesweeper.models.GameState;
import com.mooney.minesweeper.models.Status;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameTest {

    @Test
    void adjacentCellValidation() {
        var gameState = Game.generateGame(DifficultyLevel.SIMPLE);

        // Test adjacent cells off the board arent counted
        var topLeftCorner = gameState.cells()[0][0];
        var adjacentCells = Game.adjacentCells(topLeftCorner);

        assertEquals(3, adjacentCells.size());
        assertTrue(adjacentCells.contains(gameState.cells()[0][1]));
        assertTrue(adjacentCells.contains(gameState.cells()[1][0]));
        assertTrue(adjacentCells.contains(gameState.cells()[1][1]));

        // Normal cell position validation
        var normalCell = gameState.cells()[1][1];
        adjacentCells = Game.adjacentCells(normalCell);

        assertEquals(8, adjacentCells.size());
        assertTrue(adjacentCells.contains(gameState.cells()[0][0]));
        assertTrue(adjacentCells.contains(gameState.cells()[0][1]));
        assertTrue(adjacentCells.contains(gameState.cells()[0][2]));
        assertTrue(adjacentCells.contains(gameState.cells()[1][0]));
        assertTrue(adjacentCells.contains(gameState.cells()[1][2]));
        assertTrue(adjacentCells.contains(gameState.cells()[2][0]));
        assertTrue(adjacentCells.contains(gameState.cells()[2][1]));
        assertTrue(adjacentCells.contains(gameState.cells()[2][2]));
    }

    @Test
    void validateSimpleGame() {
        var gameState = Game.generateGame(DifficultyLevel.SIMPLE);

        assertEquals(64, gameState.cells().length * gameState.cells()[0].length);
        assertEquals(10, countMines(gameState));
    }

    @Test
    void validateModerateGame() {
        var gameState = Game.generateGame(DifficultyLevel.MODERATE);

        assertEquals(256, gameState.cells().length * gameState.cells()[0].length);
        assertEquals(40, countMines(gameState));
    }

    @Test
    void validateDifficultGame() {
        var gameState = Game.generateGame(DifficultyLevel.DIFFICULT);

        assertEquals(480, gameState.cells().length * gameState.cells()[0].length);
        assertEquals(99, countMines(gameState));
    }

    @Test
    void validateGameState() {
        var gameState = Game.generateGame(DifficultyLevel.SIMPLE);

        assertEquals(Status.IN_PLAY, gameState.status());
        assertTrue(gameState.startTime().isBefore(LocalDateTime.now()));
    }

    private int countMines(GameState gameState) {
        int count = 0;
        for (Cell[] row : gameState.cells()) {
            for (Cell cell : row) {
                if (cell.isBomb()) count++;
            }
        }

        return count;
    }
}
