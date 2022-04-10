package by.bntu.fitr.povt.model.animation;

import by.bntu.fitr.povt.model.collection.TimeZoneList;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.time.ZoneId;
import java.util.*;

public class DigitalTimeZone {
    private static List<TimeZoneList.TimeZoneWithDisplayNames> returnedZones = TimeZoneList.getInstance().getTimeZones();

    public DigitalTimeZone(Label label) {
        bindToTime(label);
    }


    private static void bindToTime(Label label) {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0),
                        actionEvent -> {
                            String string = ZoneId.systemDefault().toString();

                            for (TimeZoneList.TimeZoneWithDisplayNames zone : returnedZones) {
                                if (zone.getTimeZone().getID().equals(string)) {
                                    string = zone.getDisplayName();
                                }
                            }

                            label.setText(string);
                        }
                ),
                new KeyFrame(Duration.seconds(1))
        );

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}
