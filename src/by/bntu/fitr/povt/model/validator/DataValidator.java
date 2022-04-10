package by.bntu.fitr.povt.model.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidator {
    private static final String REGEX_TIME =
            "([01]?[0-9]|2[0-3]):[0-5][0-9]";

    public static boolean validateTime(String time) {
        Pattern pattern = Pattern.compile(REGEX_TIME);
        Matcher matcher = pattern.matcher(time);
        return matcher.matches();
    }
}
