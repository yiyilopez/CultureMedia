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
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

public class CulturemediaServiceTest {
    private CulturemediaService culturemediaService;
    private VideoRepository videoRepository = Mockito.mock();
    private ViewRepository viewRepository = new ViewRepositoryImpl();

    @BeforeEach
    void init() {
        culturemediaService = new CulturemediaServiceImpl(videoRepository, viewRepository);
    }

    @Test
    void when_FindAllVideos_returns_all_videos_successfully() throws VideoNotFoundException {
        doReturn(List.of(
                new Video("01", "Título 1", "----", 4.5),
                new Video("02", "Title 2", "----", 5.5),
                new Video("03", "Title 3", "----", 4.4),
                new Video("04", "Title 4", "----", 3.5),
                new Video("05", "Title 5", "----", 5.7),
                new Video("06", "Title 6", "----", 5.1)))
                .when(videoRepository).findAll();
        List<Video> videos = culturemediaService.findAll();
        assertEquals(6, videos.size()); //non-complete way of testing the method
        assertTrue(videos.stream().map(Video::code).toList().equals(List.of("01","02","03","04","05","06")));
    }

    @Test
    void when_FindAllVideos_throws_the_exception_successfully() {
        VideoNotFoundException thrown = assertThrows(
                VideoNotFoundException.class,
                () -> culturemediaService.findAll()
        );
    }

    @Test
    void when_findByTitle_returns_the_videos_successfully() throws VideoNotFoundException {
        doReturn(List.of(
                new Video("03", "Title 3", "----", 4.4)))
                .when(videoRepository).find("title 3");

        List<Video> videos = culturemediaService.findByTitle("title 3");
        assertTrue(videos.stream().map(Video::code).toList().equals(List.of("03")));
    }

    @Test
    void when_findByTitle_throws_the_exception_successfully() {
        assertThrows(VideoNotFoundException.class, () -> culturemediaService.findByTitle("non_existent_title"));
    }

    @Test
    void when_findByDuration_returns_the_videos_successfully() throws VideoNotFoundException {
        //createVideos();
        doReturn( List.of(
                new Video("01", "Título 1", "----", 4.5),
                new Video("03", "Title 3", "----", 4.4),
                new Video("04", "Title 4", "----", 3.5)))
                .when(videoRepository).find(1.0, 4.5);
        List<Video> videos = culturemediaService.findByDuration(1.0, 4.5);
        assertTrue(videos.stream().map(Video::code).toList().equals(List.of("01","03","04")));
    }

    @Test
    void when_findByDuration_throws_the_exception_successfully() {
        assertThrows(VideoNotFoundException.class, () -> culturemediaService.findByDuration(0.0, 0.0));
    }

}
