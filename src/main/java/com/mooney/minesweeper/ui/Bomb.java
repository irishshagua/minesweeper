package com.mooney.minesweeper.ui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;
import java.util.Objects;

public class Bomb extends ImageView {

    private static InputStream BOMG_IMAGE_RESOURCE = Objects.requireNonNull(
            Bomb.class.getClassLoader().getResourceAsStream("assets/images/bomb.png")
    );
    private static Image BOMB_IMAGE = new Image(BOMG_IMAGE_RESOURCE);

    public Bomb() {
        super(BOMB_IMAGE);

        setFitWidth(Constant.CELL_SIDE_LENGTH);
        setFitHeight(Constant.CELL_SIDE_LENGTH);
        setPreserveRatio(true);
    }
}
