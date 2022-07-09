package com.codingdojo.authentication.services;

import java.util.Optional;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import com.codingdojo.authentication.models.LoginUser;
import com.codingdojo.authentication.models.User;
import com.codingdojo.authentication.repositories.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    //register user
    public User register(User newUser, BindingResult result) {
        if(userRepository.findByEmail(newUser.getPasswordConfirmation()).isPresent()) {
            result.rejectValue("email", "Unique", "This email is already in use!");
        }
        if(!newUser.getPassword().equals(newUser.getPasswordConfirmation())) {
            result.rejectValue("passwordConfirmation", "Matches", "The Confirm Password must match Password!");
        }
        if(result.hasErrors()) {
            return null;
        } else {
            String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
            newUser.setPassword(hashed);
            return userRepository.save(newUser);
        }
    }
    
    //login
    public User login(LoginUser newLogin, BindingResult result) {
        if(result.hasErrors()) {
            return null;
        }
        Optional<User> potentialUser = userRepository.findByEmail(newLogin.getEmail());
        if(!potentialUser.isPresent()) {
            result.rejectValue("email", "Unique", "Invalid email or password!");
            return null;
        }
        User user = potentialUser.get();
        if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
            result.rejectValue("password", "Matches", "Invalid email or password!");
        }
        if(result.hasErrors()) {
            return null;
        } else {
            return user;
        }
    }
    
    
    // find user by email
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
    
    // find user by id
    public User findUserById(Long id) {
    	return userRepository.findById(id).orElse(null);
    }
}
