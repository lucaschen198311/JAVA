package com.codingdojo.waterbnb.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.codingdojo.waterbnb.models.User;
import com.codingdojo.waterbnb.repositories.UserRepository;

@Component
public class UserValidator implements Validator{
	private UserRepository userRepository;
	public UserValidator(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	  public boolean supports(Class<?> clazz) {
	      return User.class.equals(clazz);
	  }

	@Override
	public void validate(Object object, Errors errors) {
		User user = (User) object;
		String username = user.getUsername();
	    if (!user.getPasswordConfirmation().equals(user.getPassword())) {
	        errors.rejectValue("passwordConfirmation", "Match");
	    }
	    
	    if(userRepository.findByUsername(username) != null) {
	    	errors.rejectValue("username", "Exist");
	    }
	}
}
