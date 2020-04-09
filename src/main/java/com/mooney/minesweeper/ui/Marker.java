package com.mooney.minesweeper.ui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;
import java.util.Objects;

public class Marker extends ImageView {

    private static final InputStream STAR_IMAGE_RESOURCE = Objects.requireNonNull(
            Marker.class.getClassLoader().getResourceAsStream("assets/images/star.png")
    );
    private static final Image STAR_IMAGE = new Image(STAR_IMAGE_RESOURCE);

    public Marker() {
        super(STAR_IMAGE);

        setFitWidth(Constant.CELL_SIDE_LENGTH);
        setFitHeight(Constant.CELL_SIDE_LENGTH);
        setPreserveRatio(true);
    }
}
