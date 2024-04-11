package culturemedia.model;

import java.time.LocalDateTime;

public record View(String userFullName, LocalDateTime createdAt, LocalDateTime startPlayingTime, Integer Age, Video video) {
}
