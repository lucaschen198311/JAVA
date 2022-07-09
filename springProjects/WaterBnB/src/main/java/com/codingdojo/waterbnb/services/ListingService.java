package com.codingdojo.waterbnb.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.codingdojo.waterbnb.models.Listing;
import com.codingdojo.waterbnb.models.Review;
import com.codingdojo.waterbnb.models.User;
import com.codingdojo.waterbnb.repositories.ListingRepository;

@Service
public class ListingService {
	private final ListingRepository listingRepository;
	public ListingService(ListingRepository listingRepository) {
		this.listingRepository = listingRepository;
	}
	
	public List<Listing> searchListingByAddress(String input){
		return listingRepository.findByAddressContainingIgnoreCase(input);
	}
	
	public Listing findListing(Long id) {
		return listingRepository.findById(id).orElse(null);
	}
	
	public Listing editListing(String address, Listing listing, User user, List<Review> reviews) {
		listing.setUser(user);
		listing.setReviews(reviews);
		listing.setAddress(address);
		return listingRepository.save(listing);
	}
	
	public Listing createNewListing(Listing listing, User user) {
		listing.setUser(user);
		return listingRepository.save(listing);
	}
}
