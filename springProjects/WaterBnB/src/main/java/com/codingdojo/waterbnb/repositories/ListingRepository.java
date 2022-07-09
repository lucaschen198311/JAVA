package com.codingdojo.waterbnb.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.codingdojo.waterbnb.models.Listing;

public interface ListingRepository extends CrudRepository<Listing, Long>{
	List<Listing> findAll();
	List<Listing> findByAddressContainingIgnoreCase(String searchInput);
}
