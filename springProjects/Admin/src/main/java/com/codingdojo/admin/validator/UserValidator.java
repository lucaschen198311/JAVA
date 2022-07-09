package com.codingdojo.admin.validator;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.codingdojo.admin.models.User;
import com.codingdojo.admin.repositories.UserRepositories;


@Component
public class UserValidator implements Validator{
	private UserRepositories userRepositories;
	public UserValidator(UserRepositories userRepositories) {
		this.userRepositories = userRepositories;
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
	    
	    if(userRepositories.findByUsername(username) != null) {
	    	errors.rejectValue("username", "Exist");
	    }
	}
}
