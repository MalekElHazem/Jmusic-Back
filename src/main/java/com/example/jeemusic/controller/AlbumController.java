package com.example.jeemusic.controller;

import com.example.jeemusic.entity.Album;
import com.example.jeemusic.service.AlbumService;
import com.example.jeemusic.entity.Artist;
import com.example.jeemusic.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @Autowired
    private ArtistRepository artistRepository;

    @GetMapping
    public List<Album> getAllAlbums() {
        return albumService.getAllAlbums();
    }

    @GetMapping("/{id}")
    public Optional<Album> getAlbumById(@PathVariable Long id) {
        return albumService.getAlbumById(id);
    }

    @PostMapping
    public Album createAlbum(@RequestBody Album album) {
        Optional<Artist> artistOptional = artistRepository.findById(album.getArtist().getId());
        if (artistOptional.isPresent()) {
            album.setArtist(artistOptional.get());
            return albumService.saveAlbum(album);
        } else {	
            throw new IllegalArgumentException("Artist not found");
        }
    }

    @PutMapping("/{id}")
    public Album updateAlbum(@PathVariable Long id, @RequestBody Album album) {
        return albumService.updateAlbum(id, album);
    }

    @DeleteMapping("/{id}")
    public void deleteAlbum(@PathVariable Long id) {
        albumService.deleteAlbum(id);
    }
}
