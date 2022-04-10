package by.bntu.fitr.povt.model.animation;

import by.bntu.fitr.povt.model.formater.DataFormatter;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.time.LocalDate;


public class DigitalDate {

    public DigitalDate(Label label) {
        bindToTime(label);
    }


    private static void bindToTime(Label label) {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0),
                        actionEvent -> {
                            LocalDate date = LocalDate.now();
                            String formattedDate = DataFormatter.formatDateForView(date);
                            label.setText(formattedDate);
                        }
                ),
                new KeyFrame(Duration.seconds(1))
        );

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}
