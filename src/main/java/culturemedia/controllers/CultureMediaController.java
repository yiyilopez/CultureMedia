package culturemedia.controllers;

import java.util.*;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.sevice.impl.CulturemediaServiceImpl;

public class CultureMediaController {

    private final CulturemediaServiceImpl culturemediaService;


    public CultureMediaController(CulturemediaServiceImpl cultureMediaService) {
        this.culturemediaService = cultureMediaService;
    }


    public List<Video> find_allVideos() throws VideoNotFoundException {
        List<Video> videos = null;
        videos = culturemediaService.findAll();
        return videos;
    }


}
