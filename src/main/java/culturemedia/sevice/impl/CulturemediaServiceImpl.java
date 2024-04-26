package culturemedia.sevice.impl;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.model.View;
import culturemedia.repository.ViewRepository;
import culturemedia.sevice.CulturemediaService;
import culturemedia.repository.VideoRepository;

import java.util.List;

public class CulturemediaServiceImpl implements CulturemediaService {

    private VideoRepository videoRepository;
    private ViewRepository viewRepository;

    public CulturemediaServiceImpl(VideoRepository videoRepository, ViewRepository viewRepository) {
        this.videoRepository = videoRepository;
        this.viewRepository = viewRepository;
    }

    @Override
    public List<Video> findAll() throws VideoNotFoundException {
        List<Video> videos = this.videoRepository.findAll();
        if (videos.isEmpty()) {
            throw new VideoNotFoundException();
        }
        return videos;
    }

    @Override
    public Video add(Video video) {
        this.videoRepository.save(video);
        return video;
    }

    @Override
    public View add(View view) {
        this.viewRepository.addView(view);
        return view;
    }

    @Override
    public List<Video> findByTitle(String title) throws VideoNotFoundException {
        List<Video> videos = this.videoRepository.find(title);
        if (videos == null) {
            throw new VideoNotFoundException();
        }
        return videos;
    }

    @Override
    public List<Video> findByDuration(Double fromDuration, Double toDuration) throws VideoNotFoundException {
        List<Video> videos = this.videoRepository.find(fromDuration, toDuration);
        if (videos.isEmpty()) {
            throw new VideoNotFoundException();
        }
        return videos;
    }
}
