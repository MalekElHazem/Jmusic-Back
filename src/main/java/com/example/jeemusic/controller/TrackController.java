package com.example.jeemusic.controller;

import com.example.jeemusic.entity.Track;
import com.example.jeemusic.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tracks")
public class TrackController {

    @Autowired
    private TrackService trackService;

    @GetMapping
    public List<Track> getAllTracks() {
        return trackService.getAllTracks();
    }

    @GetMapping("/{id}")
    public Optional<Track> getTrackById(@PathVariable Long id) {
        return trackService.getTrackById(id);
    }

    @PostMapping
    public Track createTrack(@RequestBody Track track) {
        return trackService.saveTrack(track);
    }

    @PutMapping("/{id}")
    public Track updateTrack(@PathVariable Long id, @RequestBody Track track) {
        return trackService.updateTrack(id, track);
    }

    @DeleteMapping("/{id}")		
    public void deleteTrack(@PathVariable Long id) {
        trackService.deleteTrack(id);
    }
}
