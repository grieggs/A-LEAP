package com.ALEAP.objects;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Topic implements Serializable{
	
	private String name;
	private ArrayList<Question> questions;
	private int index;
	private int size;
	
	
	public Topic(String name){
		this.name = name;
		this.questions = new ArrayList<Question>();
		index = 0;
		size = 0;
	}
	
        
        public String getName(){
            return name;
        }
        
        public int getSize(){
            return questions.size();
        }
        
	public void addQuestion(Question q){
		size++;
		questions.add(q);
		Collections.sort(questions);
	}
	public Question getQuestion(int x){
		if(x >=0 && x < questions.size()){
			return questions.get(x);
		}else if( x < 0){
			return questions.get(0);
		}else{
			return questions.get(questions.size()-1);
		}
	}
	public boolean hasNextQuestion(){
		return index < size;
	}
	public Question nextQuestion(){
		if(hasNextQuestion()){
			return questions.get(index++);
		}
		else{
			resetIndex();
			return nextQuestion();
		}
	}
        
        public ArrayList<Question> getQuestionList(){
            return questions;
        }
	public void resetIndex(){
		index = 0;
	}
	
}
