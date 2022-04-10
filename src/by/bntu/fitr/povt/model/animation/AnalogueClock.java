package by.bntu.fitr.povt.model.animation;

import javafx.animation.*;
import javafx.beans.property.DoubleProperty;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.time.LocalTime;

public class AnalogueClock {
    public AnalogueClock(Line hourHand, Line minuteHand, Line secondHand) {
        bindClockHandsToTime(hourHand, minuteHand, secondHand);
    }


    private void bindClockHandsToTime(Line hourHand, Line minuteHand, Line secondHand) {

        LocalTime localTime = LocalTime.now();
        double initialHourHandDegrees = calculateHourHandDegrees(localTime);
        double initialMinuteHandDegrees = calculateMinuteHandDegrees(localTime);
        double initialSecondHandDegrees = calculateSecondHandDegrees(localTime);


        createRotationTimeline(
                createRotate(hourHand, initialHourHandDegrees).angleProperty(),
                Duration.hours(12),
                initialHourHandDegrees
        );
        createRotationTimeline(
                createRotate(minuteHand, initialMinuteHandDegrees).angleProperty(),
                Duration.minutes(60),
                initialMinuteHandDegrees
        );
        createRotationTimeline(
                createRotate(secondHand, initialSecondHandDegrees).angleProperty(),
                Duration.seconds(60),
                initialSecondHandDegrees
        );
    }

    private Rotate createRotate(Line hand, double initialHandDegrees) {
        Rotate rotate = new Rotate(initialHandDegrees);
        hand.getTransforms().add(rotate);
        return rotate;
    }

    private void createRotationTimeline(DoubleProperty angleProperty, Duration duration, double initialRotation) {
        Timeline timeline = new Timeline(
                new KeyFrame(
                        duration,
                        new KeyValue(
                                angleProperty,
                                360 + initialRotation,
                                Interpolator.LINEAR
                        )
                )
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private int calculateSecondHandDegrees(LocalTime localTime) {
        return localTime.getSecond() * (360 / 60);
    }

    private double calculateMinuteHandDegrees(LocalTime localTime) {
        return (localTime.getMinute() + calculateSecondHandDegrees(localTime) / 360.0) * (360 / 60);
    }

    private double calculateHourHandDegrees(LocalTime localTime) {
        return (localTime.getHour() + calculateMinuteHandDegrees(localTime) / 360.0) * (360 / 12);
    }
}
