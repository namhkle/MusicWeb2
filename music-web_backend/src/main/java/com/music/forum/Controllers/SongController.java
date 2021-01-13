package com.music.forum.Controllers;

import com.music.forum.Models.Song;
import com.music.forum.Repositories.SongData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
public class SongController {
    @RequestMapping(value="")
    public String home(Model model){
        model.addAttribute("songs", SongData.getAll());
        model.addAttribute("pagetitle","Home");
        return "home";
    }
    @RequestMapping(value="addsong", method = RequestMethod.GET)
    public String displaySongs(Model model){
        model.addAttribute("songs", SongData.getAll());
        model.addAttribute("pagetitle","Add Songs");
        return "addsong";
    }
    @RequestMapping(value="removesong", method = RequestMethod.GET)
    public String displaySongs2(Model model){
        model.addAttribute("songs", SongData.getAll());
        model.addAttribute("pagetitle","Remove Songs");
        return "removesong";
    }
    @RequestMapping(value="addsong", method = RequestMethod.POST)
    public String addSong(Model model, @ModelAttribute @Valid Song newSong, Errors errors){
        model.addAttribute("songs", SongData.getAll());
       if(errors.hasErrors()){
           return "addsong";
       }
        SongData.add(newSong);
        System.out.println("Hello " + newSong);
        return "addsong";
    }

    @RequestMapping(value="removesong", method = RequestMethod.POST)
    public String removeSong(@RequestParam int[] songIds){
        for(int songId : songIds){
            SongData.remove(songId);
        }
        return "removesong";
    }

    @RequestMapping(value="addsong")
    public List<Song> getSongs(){
        return SongData.getAll();
    }
}
