package com.codingdojo.relationships.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.codingdojo.relationships.models.Answer;
import com.codingdojo.relationships.models.Question;
import com.codingdojo.relationships.models.QuestionWithTag;
import com.codingdojo.relationships.models.Tag;
import com.codingdojo.relationships.repositories.AnswerRepository;
import com.codingdojo.relationships.repositories.QuestionRepository;
import com.codingdojo.relationships.repositories.TagRepository;

@Service
public class QuoraService {
	private final QuestionRepository questionRepo;
	private final TagRepository tagRepo;
	private final AnswerRepository answerRepo;
	public QuoraService(QuestionRepository questionRepo, TagRepository tagRepo, AnswerRepository answerRepo) {
		this.questionRepo = questionRepo;
		this.tagRepo = tagRepo;
		this.answerRepo = answerRepo;
	}
	
	public List<Question> findAllQuestions(){
		return questionRepo.findAll();
	}
	
	public Question findQuestion(Long id) {
		return questionRepo.findById(id).orElse(null);
	}
	
	public Tag findTag(Long id) {
		return tagRepo.findById(id).orElse(null);
	}
	
	public void addAnswerToQuestion(Long questionId, Long answerId) {
		//at first get new answer:
		Answer newAnswer = answerRepo.findById(answerId).orElse(null);
		//find the question for answer created:
		Question question = questionRepo.findById(questionId).orElse(null);
		//add new answer into answer list of this question:
		question.getAnswers().add(newAnswer);
		//update the new answer's question part:
		newAnswer.setQuestion(question);
		//reset the question:
		answerRepo.save(newAnswer);
		questionRepo.save(question);
	}
	
	public Question createQuestionWithTags(QuestionWithTag newQuestion) {
		List<Tag> tags = new ArrayList<Tag>();
		for(String subject: newQuestion.splitTags()) {
			Tag tag = tagRepo.findBySubject(subject).orElse(null);
			if(tag == null) {
				tag = new Tag(subject);
				tagRepo.save(tag);
			}
			// prevent duplicate tags
			if(!tags.contains(tag)) {
				tags.add(tag);
			}
		}
		Question question = new Question(newQuestion.getQuestion(), tags);
		return questionRepo.save(question);
	}
	
	public Answer createAnswer(Answer answer) {
		return answerRepo.save(answer);
	} 
}
