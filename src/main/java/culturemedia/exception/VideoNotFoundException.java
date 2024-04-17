package culturemedia.exception;

import java.text.MessageFormat;

public class VideoNotFoundException extends cultureMediaException {
    public VideoNotFoundException() {
        super("can't find any video");
    }

    public VideoNotFoundException(String title) {
        super(MessageFormat.format("the video with the title {0} was not found", title));
    }
}
