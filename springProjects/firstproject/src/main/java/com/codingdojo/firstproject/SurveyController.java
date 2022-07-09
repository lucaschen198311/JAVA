package com.codingdojo.firstproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpSession;

@Controller
public class SurveyController {
	@RequestMapping("/survey")
	public String index() {
		return "surveyForm.jsp";
	}
	
	@RequestMapping(value="/fillsurvey", method=RequestMethod.POST)
	public String fillform(@RequestParam(value="name") String name, @RequestParam(value="location") String location, @RequestParam(value="lan") String lan, @RequestParam(value="comment") String comment, HttpSession session) {
		session.setAttribute("name", name);
		session.setAttribute("location", location);
		session.setAttribute("lan", lan);
		session.setAttribute("comment", comment);
		return "redirect:/survey/result";
	}
	
	@RequestMapping("/survey/result")
	public String showsurvey(Model model, HttpSession session) {
		String name = (String) session.getAttribute("name");
		String location = (String) session.getAttribute("location");
		String language = (String) session.getAttribute("lan");
		String comment = (String) session.getAttribute("comment");
		model.addAttribute("name", name);
		model.addAttribute("location", location);
		model.addAttribute("language", language);
		model.addAttribute("comment", comment);
		return "showSurveyResult.jsp";
	}
}
