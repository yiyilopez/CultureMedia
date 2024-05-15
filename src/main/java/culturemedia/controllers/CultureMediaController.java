package culturemedia.controllers;

import java.util.Collections;
import java.util.List;

import culturemedia.exception.CultureMediaException;
import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.repository.impl.VideoRepositoryImpl;
import culturemedia.repository.impl.ViewRepositoryImpl;
import culturemedia.sevice.CulturemediaService;
import culturemedia.sevice.impl.CulturemediaServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CultureMediaController {

    private final CulturemediaService culturemediaService;

    public CultureMediaController() {
        this.culturemediaService = new CulturemediaServiceImpl( new VideoRepositoryImpl(), new ViewRepositoryImpl());

    }

    public CultureMediaController(CulturemediaService cultureMediaService) {
        this.culturemediaService = cultureMediaService;
    }

    @GetMapping
    public List<Video> findAllVideos() {
        try {
            return culturemediaService.findAll();
        }
        catch (VideoNotFoundException e) {
            return Collections.emptyList();
        }
    }

    @PostMapping
    public Video addVideo(@RequestBody Video video) {
        return culturemediaService.add(video);
    }
}
