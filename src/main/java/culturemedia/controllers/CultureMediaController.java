package culturemedia.controllers;

import java.util.List;

import culturemedia.exception.CultureMediaException;
import culturemedia.model.Video;
import culturemedia.sevice.CulturemediaService;

public class CultureMediaController {

    private final CulturemediaService culturemediaService;


    public CultureMediaController(CulturemediaService cultureMediaService) {
        this.culturemediaService = cultureMediaService;
    }


    public List<Video> find_allVideos() throws CultureMediaException {
        List<Video> videos =  culturemediaService.findAll();
        return videos;
    }


}
