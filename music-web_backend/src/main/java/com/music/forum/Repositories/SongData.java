package com.music.forum.Repositories;

import com.music.forum.Models.Song;

import java.util.ArrayList;

public class SongData {
    static ArrayList<Song> songs = new ArrayList<>();

    public static ArrayList<Song> findAll(){
        return songs;
    }

    public static void add(String song, String artist){
        songs.add(new Song(song, artist));
    }

    public static void remove(String song){

    }

    public static Song getById(int id){
        Song theSong = null;

        for( Song targetSong : songs){
            if (targetSong.getSongId() == id){
                theSong = targetSong;
            }
        }
        return theSong;
    }
}
