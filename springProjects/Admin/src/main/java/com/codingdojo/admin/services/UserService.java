package com.codingdojo.admin.services;

import org.springframework.stereotype.Service;
import com.codingdojo.admin.repositories.RoleRepositories;
import com.codingdojo.admin.repositories.UserRepositories;
import com.codingdojo.admin.models.Role;
import com.codingdojo.admin.models.User;
import java.util.Date;
import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService {
	private final UserRepositories userRepositories;
	private final RoleRepositories roleRepositories;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	public UserService(UserRepositories userRepositories, RoleRepositories roleRepositories, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepositories = userRepositories;
		this.roleRepositories = roleRepositories;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	public List<User> findAllUsers() {
        return this.userRepositories.findAll();
    }
	
	public User findUser(Long id) {
        return this.userRepositories.findById(id).orElse(null);
    }
	
	public User findByUsername(String username) {
        return this.userRepositories.findByUsername(username);
    }
	
	public User updateLoginTime(User user) {
		user.setLastLogin(new Date());
		return userRepositories.save(user);
	}
 
	public void saveUserWithRole(User user) {
		List<User> users = userRepositories.findAll();
		boolean hasAdminRole = false;
		for(User u: users) {
			List<Role> roles = u.getRoles();
			if(roles.get(0).getName().equals("ROLE_ADMIN")){
				hasAdminRole = true;
				break;
			}
		}
		if(hasAdminRole) {
			user.setRoles(roleRepositories.findByName("ROLE_USER"));
		}else {
			user.setRoles(roleRepositories.findByName("ROLE_Admin"));
		}
		
	    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	    user.setLastLogin(new Date());
	    userRepositories.save(user);
	}
	
	public void convertRoleToAdmin(User user) {
		user.setRoles(roleRepositories.findByName("ROLE_ADMIN"));
		userRepositories.save(user);
	}
	
	public void deleteUser(Long id) {
		userRepositories.deleteById(id);
	}
}
