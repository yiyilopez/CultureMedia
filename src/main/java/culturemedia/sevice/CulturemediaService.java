package culturemedia.sevice;

import culturemedia.model.Video;
import culturemedia.model.View;
import culturemedia.exception.VideoNotFoundException;

import java.util.List;

public interface CulturemediaService {
    List<Video> findAll() throws VideoNotFoundException;
    Video add(Video video);
    View add(View view);
    List<Video> findByTitle(String title) throws VideoNotFoundException;
    List<Video> findByDuration(Double fromDuration, Double toDuration) throws VideoNotFoundException;
}
