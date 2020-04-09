package com.mooney.minesweeper.game;

import com.mooney.minesweeper.models.Cell;
import com.mooney.minesweeper.models.DifficultyLevel;
import com.mooney.minesweeper.models.GameState;
import com.mooney.minesweeper.models.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.*;

public class Game {

    private static final Random rand = new Random();
    private static final Logger logger = LoggerFactory.getLogger(Game.class);
    private static GameState ACTIVE_GAME;

    public static GameState generateGame(DifficultyLevel difficultyLevel) {
        return generateGame(difficultyLevel.getNumRows(), difficultyLevel.getNumCols(), difficultyLevel.getNumMines());
    }

    public static GameState generateGame(int numRows, int numCols, int numMines) {
        Cell[][] cells = new Cell[numRows][numCols];
        var minePositions = generateRandomMinePlacement(numRows, numCols, numMines);
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {
                cells[r][c] = new Cell(minePositions.contains(convertCellPositionToCellNum(r, c, numCols)), r, c);
            }
        }

        ACTIVE_GAME = new GameState(cells, LocalDateTime.now(), Status.IN_PLAY);
        return ACTIVE_GAME;
    }

    public static int calculateNumAdjacentBombs(Cell cell) {
        if (ACTIVE_GAME == null) {
            logger.debug("Trying to find adjacent bombs when game is inactive");
            return -1;
        } else {
            return (int) adjacentCells(cell).stream().filter(Cell::isBomb).count();
        }
    }

    public static List<Cell> adjacentCells(Cell cell) {
        var adjacentCells = new ArrayList<Cell>(8);
        for (var x = -1; x <= 1; x++) {
            for (var y = -1; y <= 1; y++) {
                var r = cell.xCoord() + x;
                var c = cell.yCoord() + y;
                if (r >= 0 && r < ACTIVE_GAME.cells()[0].length && c >= 0 && c < ACTIVE_GAME.cells().length) {
                    if (!(r == cell.xCoord() && c == cell.yCoord()))
                        adjacentCells.add(ACTIVE_GAME.cells()[r][c]);
                }
            }
        }

        return adjacentCells;
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
