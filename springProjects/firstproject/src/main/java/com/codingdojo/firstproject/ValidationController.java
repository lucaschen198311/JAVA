package com.codingdojo.firstproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpSession;

@Controller
public class ValidationController {
	@RequestMapping("/validate")
	public String index(HttpSession session) {
		if(session.getAttribute("answer") == null){
			session.setAttribute("answer", "bushido");
		}
		return "inputSecret.jsp";
	}
	
	@RequestMapping(value="/attempt", method=RequestMethod.POST)
	public String validation(@RequestParam(value="guess") String guess, HttpSession session) {
		String realCode = (String) session.getAttribute("answer");
		System.out.println(realCode.getClass().getName());
		if(guess.equals(realCode)) {
			return "redirect:/code";
		}else {
			
			return "redirect:/createError";
		}
	}
	
	@RequestMapping("/code")
	public String dashbord() {
		return "codePage.jsp";
	}
	
	@RequestMapping("/createError")
	public String flashMessages(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("error", "You must train harder!");
		return "redirect:/validate";
	}
}