package com.mooney.minesweeper.ui;

import com.mooney.minesweeper.game.Game;
import com.mooney.minesweeper.models.Cell;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.paint.Color;

public class MineCell extends Label {

    private static final Border NORMAL = new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, null, new BorderWidths(1)));
    private static final Border BOMBED = new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, null, new BorderWidths(1)));
    private static final Border REVEALED = new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID, null, new BorderWidths(1)));
    private static final Border MARKED = new Border(new BorderStroke(Color.ORANGE, BorderStrokeStyle.SOLID, null, new BorderWidths(1)));

    private final Cell cell;
    private final Boolean isRevealed = false;
    private Boolean isMarked = false;

    public MineCell(Cell cell) {
        this.cell = cell;

        setMinWidth(Constant.CELL_SIDE_LENGTH);
        setMinHeight(Constant.CELL_SIDE_LENGTH);
        setBorder(NORMAL);

        this.setOnMouseClicked(this::handleClick);
    }

    private void handleClick(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            if (cell.isBomb()) {
                // TODO: Add event to say bomb clicked
                setGraphic(new Bomb());
                setBorder(BOMBED);

            } else {
                var numAdjacentBombs = Game.calculateNumAdjacentBombs(cell);
                if (numAdjacentBombs == 0) {
                    // TODO: Do Cascade logic
                    setBorder(REVEALED);
                } else {
                    setText(String.valueOf(numAdjacentBombs));
                }
            }
        } else if (!isMarked) {
            isMarked = true;
            setGraphic(new Marker());
            setBorder(MARKED);
        } else {
            isMarked = false;
            setGraphic(null);
            setBorder(NORMAL);
        }
    }
}
