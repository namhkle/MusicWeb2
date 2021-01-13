package com.music.forum.Models;

import com.sun.istack.NotNull;
import javax.validation.constraints.Size;

public class Song {
    private int songId;
    private static int nextSongId = 1;

    @NotNull
    @Size(min=1, max = 20)
    private String name;

    @NotNull
    @Size(min=1, max = 20)
    private String artist;

    public Song(){
        songId = nextSongId;
        nextSongId++;
    }

    public Song(String name, String artist) {
        this.name = name;
        this.artist = artist;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
