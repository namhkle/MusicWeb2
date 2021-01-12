package com.music.forum.Models;

public class Song {
    private int songID;
    private static int nextSongID = 1;
    private String name;
    private String artist;


    public Song(){
        songID = nextSongID;
        nextSongID++;
    }

    public Song(String name, String artist) {
        this.name = name;
        this.artist = artist;
    }

    public int getSongID() {
        return songID;
    }

    public void setSongID(int songID) {
        this.songID = songID;
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
