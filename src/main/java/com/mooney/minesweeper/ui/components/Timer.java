package com.mooney.minesweeper.ui.components;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.time.LocalDateTime;

public class Timer {

    private final Timeline timeline;

    public Timer(LocalDateTime ldt, Label label) {
        label.setAlignment(Pos.CENTER);
        label.setVisible(true);

        timeline = new Timeline(
                new KeyFrame(
                        Duration.seconds(1),
                        event -> {
                            var duration = java.time.Duration.between(ldt, LocalDateTime.now());
                            var formattedDuration = String.format("%02d:%02d:%02d",
                                    duration.toHours(),
                                    duration.toMinutesPart(),
                                    duration.toSecondsPart());
                            label.setText(formattedDuration);
                        }
                )
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}
