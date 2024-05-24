package com.example.jeemusic.service;

import com.example.jeemusic.entity.Album;
import com.example.jeemusic.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    public Optional<Album> getAlbumById(Long id) {
        return albumRepository.findById(id);
    }

    public Album saveAlbum(Album album) {
        return albumRepository.save(album);
    }

    public Album updateAlbum(Long id, Album albumDetails) {
        Album album = albumRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Album not found"));
        album.setName(albumDetails.getName());
        album.setArtist(albumDetails.getArtist());
        album.setReleaseDate(albumDetails.getReleaseDate());
        return albumRepository.save(album);
    }

    public void deleteAlbum(Long id) {
        albumRepository.deleteById(id);
    }
}
