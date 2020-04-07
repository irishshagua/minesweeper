package com.mooney.minesweeper.ui;

import com.mooney.minesweeper.models.Cell;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.paint.Color;

public class MineCell extends Label {

    private Cell cell;
    private Boolean isRevealed = false;

    public MineCell(Cell cell) {
        this.cell = cell;

        setMinWidth(40);
        setMinHeight(40);
        setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));

        this.setOnMouseClicked(this::handleClick);
    }

    private void handleClick(MouseEvent event) {
        if (cell.isBomb())
            setText("X"); // TODO: Add event to say bomb clicked
        else
            setText("OK"); // TODO: Need to generate num near bombs
    }
}
