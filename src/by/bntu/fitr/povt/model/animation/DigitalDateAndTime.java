package by.bntu.fitr.povt.model.animation;

import by.bntu.fitr.povt.model.formater.DataFormatter;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.time.LocalDateTime;


public class DigitalDateAndTime {
    public DigitalDateAndTime(Label label) {
        bindToTime(label);
    }


    private static void bindToTime(Label label) {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0),
                        actionEvent -> {
                            LocalDateTime localDateTime = LocalDateTime.now();
                            String formattedDateTime = DataFormatter.formatDateTimeForView(localDateTime);
                            label.setText(formattedDateTime);
                        }
                ),
                new KeyFrame(Duration.seconds(1))
        );

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}
