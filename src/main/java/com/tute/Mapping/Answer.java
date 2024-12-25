package com.tute.Mapping;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Answer {
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="answer_id")
	private int answerId;
	private String Answer;
	
	@OneToOne(mappedBy="answer") // Removes the redundancy to add a new column
	private Question question;   // Removes the need to do a get call on Question when answer is fetched,
	                             // SELECT * from QUESTION WHERE answer_id = x
	                             // it removes this call and binds the question with the answer
	
	public int getAnswerId() {
		return answerId;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public String getAnswer() {
		return Answer;
	}
	public void setAnswer(String answer) {
		Answer = answer;
	}
}
