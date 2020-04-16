package com.mooney.minesweeper.ui.components;

import com.mooney.minesweeper.game.Game;
import com.mooney.minesweeper.models.Cell;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.Set;
import java.util.function.Function;

public class MineCell extends Label {

    private static final Border NORMAL = new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, null, new BorderWidths(1)));
    private static final Border BOMBED = new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, null, new BorderWidths(1)));
    private static final Border MARKED = new Border(new BorderStroke(Color.ORANGE, BorderStrokeStyle.SOLID, null, new BorderWidths(1)));
    private static final Border REVEALED = new Border(new BorderStroke(Color.LIGHTBLUE, BorderStrokeStyle.SOLID, null, new BorderWidths(1)));

    private final Cell cell;
    private Boolean isMarked = false;
    // TODO: Figure out how to use void as the return type here
    private Function<Set<Cell>, Boolean> cascadeCallback;

    public MineCell(Cell cell, Function<Set<Cell>, Boolean> callback) {
        this.cell = cell;

        setMinWidth(Constant.CELL_SIDE_LENGTH);
        setMinHeight(Constant.CELL_SIDE_LENGTH);
        setBorder(NORMAL);
        setAlignment(Pos.CENTER);

        this.setOnMouseClicked(this::handleClick);
        this.cascadeCallback = callback;
    }

    private void handleClick(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            performReveal(true);
        } else
            performMark();
    }

    public void markRevealed() {
        setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        setBorder(REVEALED);
    }

    public void performReveal(Boolean withCascade) {
        if (cell.isBomb()) {
            // TODO: Add event to say bomb clicked
            setGraphic(new Bomb());
            setBorder(BOMBED);
        } else {
            var numAdjacentBombs = Game.calculateNumAdjacentBombs(cell);
            if (numAdjacentBombs == 0) {
                if (withCascade)
                    cascadeCallback.apply(Game.findCascadeCells(cell));
                markRevealed();
            } else {
                setText(String.valueOf(numAdjacentBombs));
            }
        }
    }

    public void performMark() {
        if (!isMarked) {
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
