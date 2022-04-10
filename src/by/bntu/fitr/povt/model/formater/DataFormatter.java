package by.bntu.fitr.povt.model.formater;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DataFormatter {
    private static final String TIME_FORMAT_PATTERN =
            "hh:mm:ss a";
    private static final String DATE_FORMAT_FOR_VIEW_PATTERN =
            "EEEE, MMMM dd/MM/yyyy";
    private static final String DATE_FORMAT_FOR_CHANGE_PATTERN =
            "MM/dd/yyyy";
    private static final String DATE_TIME_PATTERN =
            "EEEE, MMMM dd/MM/yyyy hh:mm a";


    public static String formatTimeForView(LocalTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(TIME_FORMAT_PATTERN);
        return time.format(formatter);
    }

    public static String formatDateForView(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT_FOR_VIEW_PATTERN);
        return date.format(formatter);
    }

    public static String formatDateForChange(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT_FOR_CHANGE_PATTERN);
        return date.format(formatter);
    }

    public static String formatDateTimeForView(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);
        return dateTime.format(formatter);
    }

}
