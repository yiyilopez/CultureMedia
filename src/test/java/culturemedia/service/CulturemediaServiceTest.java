package culturemedia.service;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.repository.VideoRepository;
import culturemedia.repository.ViewRepository;
import culturemedia.repository.impl.VideoRepositoryImpl;
import culturemedia.repository.impl.ViewRepositoryImpl;
import culturemedia.sevice.CulturemediaService;
import culturemedia.sevice.impl.CulturemediaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CulturemediaServiceTest {
    private CulturemediaService culturemediaService;

    @BeforeEach
    void init() {
        VideoRepository videoRepository = new VideoRepositoryImpl();
        ViewRepository viewRepository = new ViewRepositoryImpl();
        culturemediaService = new CulturemediaServiceImpl(videoRepository, viewRepository);
    }

    private void createVideos(){
        List<Video> videos = List.of(new Video("01", "Título 1", "----", 4.5),
                new Video("02", "Title 2", "----", 5.5),
                new Video("03", "Title 3", "----", 4.4),
                new Video("04", "Title 4", "----", 3.5),
                new Video("05", "Title 5", "----", 5.7),
                new Video("06", "Title 6", "----", 5.1));

        for (Video video : videos) {
             culturemediaService.add(video);
        }

    }

    @Test
    void when_FindAllVideos_returns_all_videos_successfully() throws VideoNotFoundException {
        createVideos();
        List<Video> videos = culturemediaService.findAll();
        assertEquals(6, videos.size());
    }

    @Test
    void when_FindAllVideos_throws_the_exception_successfully() {
        VideoNotFoundException thrown = assertThrows(
                VideoNotFoundException.class,
                () -> culturemediaService.findAll()
        );
    }
}
