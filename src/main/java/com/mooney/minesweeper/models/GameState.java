package com.mooney.minesweeper.models;

import java.time.LocalDateTime;

public record GameState(Cell[][]cells, LocalDateTime startTime, Status status) {
}
