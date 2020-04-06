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
