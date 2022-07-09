package com.codingdojo.mvc.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.codingdojo.mvc.models.Song;
import com.codingdojo.mvc.services.SongService;

@RestController
public class SongsApi {
	private final SongService songService;
    public SongsApi(SongService songService){
        this.songService = songService;
    }
    
    @RequestMapping("/api/songs")
    public List<Song> index() {
        return songService.allSongs();
    }
    
    @RequestMapping("/api/songs/topten")
    public List<Song> topten() {
        return songService.topTenSongs();
    }
    
    @RequestMapping("/api/songs/search/{searchartist}")
    public List<Song> search(@PathVariable("searchartist") String searchartist) {
        return songService.searchByArtist(searchartist);
    }
    
    @RequestMapping(value="/api/songs", method=RequestMethod.POST)
    public Song create(@RequestParam(value="title") String title, @RequestParam(value="artist") String artist, @RequestParam(value="rating") Integer rating) {
        Song song = new Song(title, artist, rating);
        return songService.createSong(song);
    }
    
    @RequestMapping("/api/songs/{id}")
    public Song show(@PathVariable("id") Long id) {
        Song song = songService.findSong(id);
        return song;
    }
    
    @RequestMapping(value="/api/songs/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        songService.deleteSong(id);
    }
}
