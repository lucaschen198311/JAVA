package com.codingdojo.mvc.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.mvc.models.Song;
import com.codingdojo.mvc.services.SongService;

@Controller
public class SongsController {
	private final SongService songService;
    
    public SongsController(SongService songService) {
        this.songService = songService;
    }
    
    @RequestMapping("/lookyfi")
    public String introduce() {
    	return "/songs/introduce.jsp";
    }
    
    @RequestMapping("/songs/dashboard")
    public String index(Model model) {
    	List<Song> songs = songService.allSongs();
    	model.addAttribute("songs", songs);
    	return "/songs/index.jsp";
    }
    
    @RequestMapping("/songs/topten")
    public String topten(Model model) {
    	List<Song> songs = songService.topTenSongs();
    	model.addAttribute("songs", songs);
    	return "/songs/topten.jsp";
    }
    
    @RequestMapping("/songs/search")
    public String searchArtist(@RequestParam("artist") String artist, Model model) {
        List<Song> songs = songService.searchByArtist(artist);
        model.addAttribute("artist", artist);
        model.addAttribute("songs", songs);
        return "/songs/search.jsp";
    }
    
    @RequestMapping("/songs/new")
    public String newSong(@ModelAttribute("song") Song song) {
    	return "/songs/newsong.jsp";
    }
    
    @RequestMapping(value="/songs", method=RequestMethod.POST)
    public String createsong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
    	if(result.hasErrors()) {
    		return "/songs/newsong.jsp";
    	}else {
    		songService.createSong(song);
    		return "redirect:/songs/dashboard";
    	}
    }
    
    @RequestMapping("/songs/{id}")
    public String showsong(@PathVariable("id") Long id, Model model) {
    	Song song = songService.findSong(id);
    	if(song != null) {
    		model.addAttribute("song", song);
        	return "/songs/showsong.jsp";
    	}
    	return null;
    }
        
    @RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
    public String deletesong(@PathVariable("id") Long id) {
        songService.deleteSong(id);
        return "redirect:/songs/dashboard";
    }   
}
