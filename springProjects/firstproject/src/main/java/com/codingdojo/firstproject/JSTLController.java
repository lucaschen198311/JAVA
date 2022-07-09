package com.codingdojo.firstproject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
@Controller
public class JSTLController {
	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("dojoName", "San-Jose");
		return "index.jsp";
	}
}
