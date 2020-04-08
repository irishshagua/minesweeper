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

    private static Bomb TSAR_BOMBA = new Bomb();

    private Cell cell;
    private Boolean isRevealed = false;

    public MineCell(Cell cell) {
        this.cell = cell;

        setMinWidth(Constant.CELL_SIDE_LENGTH);
        setMinHeight(Constant.CELL_SIDE_LENGTH);
        setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));

        this.setOnMouseClicked(this::handleClick);
    }

    private void handleClick(MouseEvent event) {
        if (cell.isBomb()) {
            // TODO: Add event to say bomb clicked
            setGraphic(TSAR_BOMBA);
            setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
        } else
            setText("OK"); // TODO: Need to generate num near bombs
    }
}
