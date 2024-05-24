package com.example.jeemusic.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    
    @ManyToOne
    @JoinColumn(name = "artist_id")
    @JsonIgnoreProperties({"tracks"})
    private Artist artist;

    @ManyToOne
    @JoinColumn(name = "album_id")
    @JsonIgnoreProperties({"tracks"})
    private Album album;

    private String filePath; // Path to the MP3 file stored on the file system

    @ManyToMany(mappedBy = "tracks")
    private Set<Playlist> playlists = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties({"tracks"}) 
    @JoinColumn(name = "genre_id")
    private Genre genre;

    // Constructors
    public Track() {
    	super();
    }

    public Track(String title, Artist artist, Album album, String filePath, Genre genre) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.filePath = filePath;
        this.genre = genre;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Set<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Set<Playlist> playlists) {
        this.playlists = playlists;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
