package com.codingdojo.firstproject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;
@Controller
@RequestMapping("/server")
public class CounterController {
	@RequestMapping("")
	public String index() {
		return "countMain.jsp";
	}
	@RequestMapping("/count")
	public String ShowCount(HttpSession session, Model model) {
		if(session.getAttribute("counter") == null) {
			session.setAttribute("counter", 1);
		}else {
			Integer currCount = (Integer) session.getAttribute("counter");
			session.setAttribute("counter", currCount+1);
		}
		Integer totalCount = (Integer) session.getAttribute("counter");
		model.addAttribute("showCount", totalCount); 
		return "displayCount.jsp";
	}
}
