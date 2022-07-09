package com.codingdojo.firstproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.ArrayList;
import java.util.Random;
//import java.text.SimpleDateFormat;

@Controller
public class GoldController {
	@RequestMapping("/gold")
	public String index(HttpSession session, Model model) {
		ArrayList<String> activityList = new ArrayList<String>();
		if(session.getAttribute("list") == null) {
			session.setAttribute("list", activityList);
		}
		if(session.getAttribute("totalCount") == null) {
			session.setAttribute("totalCount", 0);
		}
		Integer totalCount = (Integer) session.getAttribute("totalCount");
		ArrayList<String> list = (ArrayList<String>) session.getAttribute("list");
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		return "gold.jsp";
	}
	
	@RequestMapping("/farm")
	public String farm(HttpSession session) {
		Date d = new Date();
		Random r = new Random();
		int num = r.nextInt(10) + 10;
		Integer totalCount = (Integer) session.getAttribute("totalCount");
		ArrayList<String> list = (ArrayList<String>) session.getAttribute("list");
		list.add("You entered a farm and earned " + num + " gold. (" + d + ")");
		session.setAttribute("totalCount", totalCount+num);
		session.setAttribute("list", list);
		return "redirect:/gold";
	}
	
	@RequestMapping("/cave")
	public String cave(HttpSession session) {
		Date d = new Date();
		Random r = new Random();
		int num = r.nextInt(5) + 5;
		Integer totalCount = (Integer) session.getAttribute("totalCount");
		ArrayList<String> list = (ArrayList<String>) session.getAttribute("list");
		list.add("You entered a cave and earned " + num + " gold. (" + d + ")");
		session.setAttribute("totalCount", totalCount+num);
		session.setAttribute("list", list);
		return "redirect:/gold";
	}
	
	@RequestMapping("/house")
	public String house(HttpSession session) {
		Date d = new Date();
		Random r = new Random();
		int num = r.nextInt(3) + 2;
		Integer totalCount = (Integer) session.getAttribute("totalCount");
		ArrayList<String> list = (ArrayList<String>) session.getAttribute("list");
		list.add("You entered a farm and earned " + num + " gold. (" + d + ")");
		session.setAttribute("totalCount", totalCount+num);
		session.setAttribute("list", list);
		return "redirect:/gold";
	}
	
	@RequestMapping("/casino")
	public String casino(HttpSession session) {
		Date d = new Date();
		Random r = new Random();
		int num = r.nextInt(100) - 50;
		Integer totalCount = (Integer) session.getAttribute("totalCount");
		ArrayList<String> list = (ArrayList<String>) session.getAttribute("list");
		if(num >= 0) {
			list.add("You entered a casino and earned " + num + " gold. (" + d + ")");
		}else {
			list.add("You entered a casino and lost " + num*-1 + " gold Ouch. (" + d + ")");
		}
		
		session.setAttribute("totalCount", totalCount+num);
		session.setAttribute("list", list);
		return "redirect:/gold";
	}
}
