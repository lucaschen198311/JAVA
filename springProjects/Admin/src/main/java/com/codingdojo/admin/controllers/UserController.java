package com.codingdojo.admin.controllers;

import java.security.Principal;
import java.util.Date;
//import java.util.Date;
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
import com.codingdojo.admin.services.UserService;
import com.codingdojo.admin.validator.UserValidator;
import com.codingdojo.admin.models.User;

@Controller
public class UserController {
	private UserService userService;
	private UserValidator userValidator;
    public UserController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
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
        userService.saveUserWithRole(user);
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
	
	@RequestMapping(value = {"/", "/bashboard"})
	public String home(Principal principal, Model model) {
		//principal (current user) via the .getName() method has been available since Spring 3+
		String username = principal.getName();
		User user = userService.findByUsername(username);
		model.addAttribute("lastLoginTime", user.getLastLogin());
		User currUser = userService.updateLoginTime(user);
	    model.addAttribute("currentUser", currUser);
	    return "dashboardPage.jsp";
	}
	 
	@RequestMapping("/admin")
	public String adminAccess(Principal principal, Model model) {
		//principal (current user) via the .getName() method has been available since Spring 3+
		String username = principal.getName();
		List<User> users = userService.findAllUsers();
	    model.addAttribute("currentUser", userService.findByUsername(username));
	    model.addAttribute("users", users);
	    return "adminPage.jsp";
	}
	
	@RequestMapping(value = "/admin/{id}", method = RequestMethod.POST)
	public String addAdminRole(@PathVariable("id") Long id) {
		User user = userService.findUser(id);
		userService.convertRoleToAdmin(user);
		return "redirect:/admin";
	}
	
	@RequestMapping(value = "/admin/{id}/delete", method = RequestMethod.POST)
	public String removeUser(@PathVariable("id") Long id) {
		userService.deleteUser(id);
		return "redirect:/admin";
	}
}
