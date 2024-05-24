package com.example.jeemusic.service;

import com.example.jeemusic.entity.Track;
import com.example.jeemusic.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackService {

    @Autowired
    private TrackRepository trackRepository;

    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    public Optional<Track> getTrackById(Long id) {
        return trackRepository.findById(id);
    }

    public Track saveTrack(Track track) {
        return trackRepository.save(track);
    }

    public Track updateTrack(Long id, Track trackDetails) {
        Track track = trackRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Track not found"));
        track.setTitle(trackDetails.getTitle());
        track.setArtist(trackDetails.getArtist());
        track.setAlbum(trackDetails.getAlbum());
        track.setFilePath(trackDetails.getFilePath());
        return trackRepository.save(track);
    }

    public void deleteTrack(Long id) {
        trackRepository.deleteById(id);
    }
}
