package com.mooney.minesweeper.models;

public record Cell(Boolean isBomb, int xCoord, int yCoord, Boolean revealed) {
}
