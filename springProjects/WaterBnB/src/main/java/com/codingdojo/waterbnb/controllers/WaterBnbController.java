package com.codingdojo.waterbnb.controllers;

import java.security.Principal;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.codingdojo.waterbnb.models.Listing;
import com.codingdojo.waterbnb.models.Review;
import com.codingdojo.waterbnb.models.User;
import com.codingdojo.waterbnb.services.ListingService;
import com.codingdojo.waterbnb.services.ReviewService;
import com.codingdojo.waterbnb.services.UserService;
import com.codingdojo.waterbnb.validator.UserValidator;

@Controller
public class WaterBnbController {
	private final UserService userService;
	private final ListingService listingService;
	private final ReviewService reviewService;
	private UserValidator userValidator;
	public WaterBnbController(UserService userService, ListingService listingService, ReviewService reviewService, UserValidator userValidator) {
		this.userService = userService;
		this.listingService = listingService;
		this.reviewService = reviewService;
		this.userValidator = userValidator;
	}
	
	@RequestMapping("/home")
	public String home() {
		return "homePage.jsp";
	}
	
	@RequestMapping("/registlogin")
    public String registerForm(@Valid @ModelAttribute("user") User user) {
        return "registloginPage.jsp";
    }
	
	@RequestMapping(value = "/registlogin", method = RequestMethod.POST)
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
		userValidator.validate(user, result);
		if (result.hasErrors()) {
            return "registloginPage.jsp";
        }
        userService.createUser(user);
        return "redirect:/login";
    }
	
	@RequestMapping("/login")
    public String login(@Valid @ModelAttribute("user") User user, @RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
        return "registloginPage.jsp";
    }
	
	@RequestMapping(value = {"/search", "/"})
	public String dashboard(Principal principal, Model model) {
		//principal (current user) via the .getName() method has been available since Spring 3+
		String username = principal.getName();
		User user = userService.findByUsername(username);
		//String role = user.getRole();
		model.addAttribute("user", user);
		return "guestPage.jsp";
	    //return "/redirect:/host/dashboard";
	}
	
	@RequestMapping(value="/search" , method=RequestMethod.POST)
	public String searchListings(@RequestParam(value="search", required = false) String search, Model model, Principal principal) {
		List<Listing> results = listingService.searchListingByAddress(search);
		model.addAttribute("results", results);
		if(principal != null) {
			String username = principal.getName();
			User user = userService.findByUsername(username);
			model.addAttribute("user", user);
		}
		
		return "guestPage.jsp";
	}
	
	@RequestMapping("/host/dashboard")
	public String hostDashBoard(@Valid @ModelAttribute("listing") Listing listing, Principal principal, Model model) {
		String username = principal.getName();
		User user = userService.findByUsername(username);
		model.addAttribute("user", user);
		return "hostPage.jsp";
	}
	
	@RequestMapping(value="/host/dashboard/addlisting" , method=RequestMethod.POST)
	public String addNewListing(@Valid @ModelAttribute("listing") Listing listing, BindingResult result, Model model, Principal principal) {
		String username = principal.getName();
		User user = userService.findByUsername(username);
		model.addAttribute("user", user);
		if(result.hasErrors()) {
			return "hostPage.jsp";
		}
		listingService.createNewListing(listing, user);
		return "redirect:/host/dashboard";
	}
	
	@RequestMapping("/host/listing/{id}/edit")
	public String showEditListing(@PathVariable("id") Long id, @Valid @ModelAttribute("listing") Listing listing, Model model) {
		Listing currListing = listingService.findListing(id);
		model.addAttribute("currListing", currListing);
		return "editListingPage.jsp";
	}
	
	@RequestMapping(value="/host/listing/{id}/edit", method = RequestMethod.POST)
	public String editListing(@PathVariable("id") Long id,@Valid @ModelAttribute("listing") Listing listing, BindingResult result, Model model, Principal principal) {
		Listing currListing = listingService.findListing(id);
		model.addAttribute("currListing", currListing);
		if(result.hasErrors()) {
			return "editListingPage.jsp";
		}
		String username = principal.getName();
		User user = userService.findByUsername(username);
		List<Review> reviews = currListing.getReviews();
		String address = currListing.getAddress();
		listingService.editListing(address, listing, user, reviews);
		return "redirect:/host/dashboard";
	}
	
	@RequestMapping("/listings/view/{id}")
	public String showListing(@PathVariable("id") Long id, Principal principal, Model model) {
		if(principal != null) {
			String username = principal.getName();
			User user = userService.findByUsername(username);
			model.addAttribute("user", user);
		}
		Listing currListing = listingService.findListing(id);
		model.addAttribute("currListing", currListing);
		return "listingPage.jsp";
	}
	
	@RequestMapping("/listings/addreview/{id}")
	public String showAddReview(@Valid @ModelAttribute("review") Review review, @PathVariable("id") Long id, Model model) {
		Listing currListing = listingService.findListing(id);
		model.addAttribute("currListing", currListing);
		return "addReviewPage.jsp";
	}
	
	@RequestMapping(value = "/listings/addreview/{id}", method = RequestMethod.POST)
	public String addReviewToListing(@Valid @ModelAttribute("review") Review review, BindingResult result, @PathVariable("id") Long id, Model model, Principal principal) {
		Listing currListing = listingService.findListing(id);
		model.addAttribute("currListing", currListing);
		if(result.hasErrors()) {
			return "addReviewPage.jsp";
		}
		
		String username = principal.getName();
		User user = userService.findByUsername(username);
		reviewService.addNewReview(review, user, currListing);
		return "redirect:/listings/view/{id}";
	}
}
