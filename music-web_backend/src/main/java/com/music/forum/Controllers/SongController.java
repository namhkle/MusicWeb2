package com.music.forum.Controllers;

import java.util.*;

import com.music.forum.Models.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SongController {
    static ArrayList<Song> songs = new ArrayList<>();

    @RequestMapping(value="")
    public String home(Model model){
        model.addAttribute("songs",songs);
        model.addAttribute("pagetitle","Home");
        return "home";
    }
    @RequestMapping(value="addsong", method = RequestMethod.GET)
    public String displaySongs(Model model){
        model.addAttribute("songs", songs);
        model.addAttribute("pagetitle","Add Songs");
        return "addsong";
    }
    @RequestMapping(value="removesong", method = RequestMethod.GET)
    public String displaySongs2(Model model){
        model.addAttribute("songs", songs);
        model.addAttribute("pagetitle","Remove Songs");
        return "removesong";
    }
    @RequestMapping(value="addsong", method = RequestMethod.POST)
    public void addSong(Model model, @RequestParam String songName, @RequestParam String artistName){
        model.addAttribute("songs", songs);
        songs.add(new Song(songName, artistName));
    }

    @RequestMapping(value="removesong", method = RequestMethod.POST)
    public String removeSong(@RequestParam String songName){
        for(Song song : songs){
            if(songName.compareTo(song.getName()) == 0){
                songs.remove(song);
            }
        }
        return "removesong";
    }

    @RequestMapping(value="addsong")
    public List<Song> getSongs(){
        return songs;
    }
}
