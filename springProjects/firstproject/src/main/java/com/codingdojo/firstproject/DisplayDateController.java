package com.codingdojo.firstproject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.Date;
import java.text.SimpleDateFormat;
@Controller
public class DisplayDateController {
	@RequestMapping("/main")
	public String index() {
		return "displayMain.jsp";
	}
	@RequestMapping("/date")
	public String displaydate(Model model) {
		Date d = new Date();
		SimpleDateFormat dateStr = new SimpleDateFormat("EEEE, 'the' dd 'of' MMMM, YYYY");
		model.addAttribute("dateStr", dateStr.format(d));
		return "displayDate.jsp";
	}
	@RequestMapping("/time")
	public String displaytime(Model model) {
		Date d = new Date();
		SimpleDateFormat timeStr = new SimpleDateFormat("h:mm a");
		model.addAttribute("timeStr", timeStr.format(d));
		return "displayTime.jsp";
	}
}
