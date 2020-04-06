package com.mooney.minesweeper.models;

public enum DifficultyLevel {

    SIMPLE(8, 8, 10),
    MODERATE(16, 16, 40),
    DIFFICULT(30, 16, 99);

    private int numRows;
    private int numCols;
    private int numMines;

    DifficultyLevel(int rows, int cols, int mines) {
        this.numRows = rows;
        this.numCols = cols;
        this.numMines = mines;
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public int getNumMines() {
        return numMines;
    }
}
