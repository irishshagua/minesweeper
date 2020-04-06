package com.mooney.minesweeper.game;

import com.mooney.minesweeper.models.Cell;
import com.mooney.minesweeper.models.DifficultyLevel;
import com.mooney.minesweeper.models.GameState;
import com.mooney.minesweeper.models.Status;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Game {

    private static final Random rand = new Random();

    public static GameState generateGame(DifficultyLevel difficultyLevel) {
        return generateGame(difficultyLevel.getNumRows(), difficultyLevel.getNumCols(), difficultyLevel.getNumMines());
    }

    public static GameState generateGame(int numRows, int numCols, int numMines) {
        Cell[][] cells = new Cell[numRows][numCols];
        var minePositions = generateRandomMinePlacement(numRows, numCols, numMines);
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {
                cells[r][c] = new Cell(minePositions.contains(convertCellPositionToCellNum(r, c, numCols)), r, c, false);
            }
        }

        return new GameState(cells, LocalDateTime.now(), Status.IN_PLAY);
    }

    private static Set<Integer> generateRandomMinePlacement(int numRows, int numCols, int numMines) {
        var randos = new HashSet<Integer>(numMines);
        while (randos.size() < numMines) {
            var maxCellNum = convertCellPositionToCellNum(numRows - 1, numCols - 1, numCols);
            randos.add(rand.nextInt(maxCellNum));
        }

        return randos;
    }

    private static int convertCellPositionToCellNum(int rowPos, int colPos, int numCols) {
        return rowPos * numCols + colPos;
    }
}
