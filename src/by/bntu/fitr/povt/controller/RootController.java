package by.bntu.fitr.povt.controller;

import java.io.IOException;

import by.bntu.fitr.povt.assanoooovi4k.model.animation.*;
import by.bntu.fitr.povt.model.animation.AnalogueClock;
import by.bntu.fitr.povt.model.animation.DigitalClock;
import by.bntu.fitr.povt.model.animation.DigitalDate;
import by.bntu.fitr.povt.model.animation.DigitalTimeZone;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class RootController {


    @FXML
    private Group analogueClock;

    @FXML
    private Circle face;

    @FXML
    private Group ticks;

    @FXML
    private Line hourHand;

    @FXML
    private Line minuteHand;

    @FXML
    private Line secondHand;

    @FXML
    private Circle spindle;

    @FXML
    private Button changeTimeButton;

    @FXML
    private Button changeDateButton;

    @FXML
    private Button changeTimeZoneButton;

    @FXML
    private Label timeField;

    @FXML
    private Label dateField;

    @FXML
    private Label timeZoneField;

    @FXML
    private Label timeZoneLabel;

    @FXML
    private Label dateLabel;

    @FXML
    private Label timeLabel;

    @FXML
    void initialize() {
        initializeTicks();
        changeTimeButton.setOnAction(event -> openNewWindow("/view/changeTime.fxml"));
        changeDateButton.setOnAction(event -> openNewWindow("/view/changeDate.fxml"));
        changeTimeZoneButton.setOnAction(event -> openNewWindow("/view/changeTimeZone.fxml"));

        DigitalClock digitalClock = new DigitalClock(timeField);
        DigitalDate digitalDate = new DigitalDate(dateField);
        DigitalTimeZone digitalTimeZone = new DigitalTimeZone(timeZoneField);
        AnalogueClock analogueClock = new AnalogueClock(hourHand, minuteHand, secondHand);


    }

    void openNewWindow(String filePath) {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource(filePath));
        try {
            loader.load();
        } catch (IOException e) {
            //exception
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        MainController.initializeTitleAndIcon(stage);
        stage.setScene(new Scene(root));
        stage.show();
    }

    private void initializeTicks() {
        for (int i = 0; i < 12; i++) {
            Line tick = new Line(0, -83, 0, -93);
            tick.setTranslateX(0);
            tick.setTranslateY(0);
            tick.getTransforms().add(new Rotate(i * (360 / 12)));
            ticks.getChildren().add(tick);
        }
    }
}

