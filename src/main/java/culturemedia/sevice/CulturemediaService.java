package culturemedia.sevice;

import culturemedia.model.Video;
import culturemedia.model.View;

import java.util.List;

public interface CulturemediaService {
    List<Video> findAll();
    Video add(Video video);
    View add(View view);
}
