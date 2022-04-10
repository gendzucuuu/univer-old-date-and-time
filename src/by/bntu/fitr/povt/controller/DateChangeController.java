package by.bntu.fitr.povt.controller;

import by.bntu.fitr.povt.model.formater.DataFormatter;
import com.jfoenix.controls.JFXDatePicker;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DateChangeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button applyDateButton;

    @FXML
    private JFXDatePicker datePicker;

    @FXML
    void initialize() {
        applyDateButton.setOnAction(event -> {
            try {
                LocalDate localDate = datePicker.getValue();
                String formattedDate = DataFormatter.formatDateForChange(localDate);

                ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/C", "date", formattedDate);
                builder.start();

                Stage stage = (Stage) applyDateButton.getScene().getWindow();
                stage.close();
            } catch (NullPointerException e) {
                RootController rootController = new RootController();
                rootController.openNewWindow("/view/invalidData.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}
