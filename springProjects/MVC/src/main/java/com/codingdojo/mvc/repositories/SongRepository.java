package com.codingdojo.mvc.repositories;

import java.util.List;
//import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.codingdojo.mvc.models.Song;


@Repository
public interface SongRepository extends CrudRepository<Song, Long>{
	//list all songs 
	List<Song> findAll();
	//search all songs created by artist
	List<Song> findByArtistContaining(String search);
	//top 10 songs ordered by rating
	List<Song> findTop10ByOrderByRatingDesc();
}
