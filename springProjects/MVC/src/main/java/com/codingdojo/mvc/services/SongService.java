package com.codingdojo.mvc.services;

//import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.codingdojo.mvc.models.Song;
import com.codingdojo.mvc.repositories.SongRepository;

@Service
public class SongService {
	private final SongRepository songRepository;
    
    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }
    
    // returns all the songs
    public List<Song> allSongs() {
        return songRepository.findAll();
    }
    // creates a song
    public Song createSong(Song s) {
        return songRepository.save(s);
    }
    // retrieves a song
    public Song findSong(Long id) {
        Optional<Song> optionalSong = songRepository.findById(id);
        if(optionalSong.isPresent()) {
            return optionalSong.get();
        } else {
            return null;
        }
    }
    //search by artist
    public List<Song> searchByArtist(String search){
    	return songRepository.findByArtistContaining(search);
    }
    //top 10 song ordered by rating
    public List<Song> topTenSongs(){
    	return songRepository.findTop10ByOrderByRatingDesc();
    }
    //delete a song by id
    public void deleteSong(Long id) {
    	songRepository.deleteById(id);
    }
}
