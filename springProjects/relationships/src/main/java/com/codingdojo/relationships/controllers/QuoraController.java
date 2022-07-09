package com.codingdojo.relationships.controllers;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.codingdojo.relationships.models.Answer;
import com.codingdojo.relationships.models.QuestionWithTag;
import com.codingdojo.relationships.services.QuoraService;

@Controller
public class QuoraController {
	private final QuoraService quoraService;
	public QuoraController(QuoraService service) {
		this.quoraService = service;
	}
	
	@RequestMapping("/questions")
	public String dashboard(Model model) {
		model.addAttribute("questions", this.quoraService.findAllQuestions());
		return "/quora/index.jsp";
	}
	
	@RequestMapping("/questions/{id}")
	public String showQuestion(@PathVariable("id") Long id, @ModelAttribute("answer") Answer answer, Model model) {
		model.addAttribute("question", this.quoraService.findQuestion(id));
		return "/quora/showquestion.jsp";
	}
	
	@RequestMapping(value="/questions/{id}/addanswer", method=RequestMethod.POST)
	public String addAnswerToQuestion(@PathVariable("id") Long id, @Valid @ModelAttribute("answer") Answer answer, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("question", this.quoraService.findQuestion(id));
			return "/quora/showquestion.jsp";
		}
		quoraService.createAnswer(answer);
		return "redirect:/questions/{id}";
	}
	
	@RequestMapping("/questions/new")
	public String newQuestion(@ModelAttribute("questionwithtag") QuestionWithTag questionwithtag) {
		return "/quora/newquestion.jsp";
	}
	
	@RequestMapping(value="/questions", method=RequestMethod.POST)
	public String addNewQuestion(@Valid @ModelAttribute("questionwithtag") QuestionWithTag questionwithtag, BindingResult result) {
		if(result.hasErrors()) {
			return "/quora/newquestion.jsp";
		}
		this.quoraService.createQuestionWithTags(questionwithtag);
		return "redirect:/questions";
	}
}
