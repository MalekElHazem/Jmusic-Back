package com.example.jeemusic.service;

import com.example.jeemusic.entity.Playlist;
import com.example.jeemusic.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    public List<Playlist> getAllPlaylists() {
        return playlistRepository.findAll();
    }

    public Optional<Playlist> getPlaylistById(Long id) {
        return playlistRepository.findById(id);
    }

    public Playlist savePlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    public Playlist updatePlaylist(Long id, Playlist playlistDetails) {
        Playlist playlist = playlistRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Playlist not found"));
        playlist.setName(playlistDetails.getName());
        playlist.setUser(playlistDetails.getUser());
        playlist.setTracks(playlistDetails.getTracks());
        return playlistRepository.save(playlist);
    }

    public void deletePlaylist(Long id) {
        playlistRepository.deleteById(id);
    }
}
