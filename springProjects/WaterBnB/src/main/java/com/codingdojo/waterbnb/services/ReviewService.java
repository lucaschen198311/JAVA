package com.codingdojo.waterbnb.services;

import org.springframework.stereotype.Service;
import com.codingdojo.waterbnb.models.Listing;
import com.codingdojo.waterbnb.models.Review;
import com.codingdojo.waterbnb.models.User;
import com.codingdojo.waterbnb.repositories.ListingRepository;
import com.codingdojo.waterbnb.repositories.ReviewRepository;
import com.codingdojo.waterbnb.repositories.UserRepository;

@Service
public class ReviewService {
	private final ReviewRepository reviewRepository;
	public ReviewService(ReviewRepository reviewRepository, ListingRepository listingRepository, UserRepository userRepository) {
		this.reviewRepository = reviewRepository;
	}
	
	public Review addNewReview(Review review, User user, Listing listing) {
		String content = review.getContent();
		String rate = review.getRate();
		Long reviewBy = user.getId();
		String reviewName = user.getFirstName() + " " + user.getLastName();
		return reviewRepository.save(new Review(content, rate, reviewBy, reviewName, listing));
	}
	
	
}
