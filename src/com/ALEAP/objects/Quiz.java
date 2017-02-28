package com.ALEAP.objects;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;


public class Quiz implements Serializable{
	private String name;
	private ArrayList<Topic> topics;
	private int index;
	private int size;
	
	public Quiz(String name){
		this.name = name;
		topics = new ArrayList<Topic>();
		index = 0;
		size = 0;
	}
	
	public void addTopic(Topic t){
		size++;
		topics.add(t);
	}
	public Topic getTopic(int x){
		if(x >=0 && x < size){
			return topics.get(x);
		}else if( x < 0){
			return topics.get(0);
		}else{
			return topics.get(size-1);
		}
	}
	public Question getQuestion(int topic, int question){
		return getTopic(topic).getQuestion(question);
	}
	public boolean hasNext(){
		return index < size;
	}
	public Topic nextTopic(){
		if(hasNext()){
			return topics.get(index++);
		}
		else if(size != 0){
			resetIndex();
			return nextTopic();
		}else{
			return null;
		}
	}
	public void resetIndex(){
		index = 0;
	}
	
	public String getName(){
		return this.name;
	}
}
