package by.bntu.fitr.povt.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class MainController extends Application {
    private static final String TITLE_OF_WINDOW = "Date and time";
    private static final String ICON_PATH = "/images/calendar_clock_icon.png";

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/root.fxml"));

        initializeTitleAndIcon(primaryStage);

        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void initializeTitleAndIcon(Stage stage) {
        stage.setTitle(TITLE_OF_WINDOW);
        stage.getIcons().add(new Image(ICON_PATH));
    }
}
