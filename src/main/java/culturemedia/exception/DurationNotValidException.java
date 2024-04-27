package culturemedia.exception;

import java.text.MessageFormat;

public class DurationNotValidException extends CultureMediaException {
    public DurationNotValidException(String title, Double duration) {
        super(MessageFormat.format("the title {0} with duration {1} was not found", title, duration));

    }
}
