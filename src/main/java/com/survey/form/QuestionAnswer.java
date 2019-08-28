package com.survey.form;

import java.util.List;

public class QuestionAnswer {
	private Question question;
	private List<Answer> answers;
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	@Override
	public String toString() {
		return "QuestionAnswer [question=" + question + ", answers=" + answers + "]";
	}
	public QuestionAnswer(Question question, List<Answer> answers) {
		super();
		this.question = question;
		this.answers = answers;
	}
	public QuestionAnswer() {
		super();
	}
	
}
