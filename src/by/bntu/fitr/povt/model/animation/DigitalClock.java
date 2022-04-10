package by.bntu.fitr.povt.model.animation;


import by.bntu.fitr.povt.model.formater.DataFormatter;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.scene.control.Label;

import java.time.LocalTime;

public class DigitalClock extends Label {

    public DigitalClock(Label label) {
        bindToTime(label);
    }


    void bindToTime(Label label) {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0),
                        actionEvent -> {
                            LocalTime time = LocalTime.now();
                            String formattedTime = DataFormatter.formatTimeForView(time);
                            label.setText(formattedTime);
                        }
                ),
                new KeyFrame(Duration.seconds(1))
        );

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}
