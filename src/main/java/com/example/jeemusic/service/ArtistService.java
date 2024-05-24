package com.example.jeemusic.service;

import com.example.jeemusic.entity.Artist;
import com.example.jeemusic.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    public Optional<Artist> getArtistById(Long id) {
        return artistRepository.findById(id);
    }

    public Artist saveArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    public Artist updateArtist(Long id, Artist artistDetails) {
        Artist artist = artistRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Artist not found"));
        artist.setName(artistDetails.getName());
        artist.setBio(artistDetails.getBio());
        return artistRepository.save(artist);
    }

    public void deleteArtist(Long id) {
        artistRepository.deleteById(id);
    }
}
