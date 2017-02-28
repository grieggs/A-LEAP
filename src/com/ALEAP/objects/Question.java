package com.ALEAP.objects;
import java.awt.*;
import java.io.Serializable;

import javax.sound.sampled.*;


public class Question implements Comparable<Question>, Serializable {
	private int ID;
	private int difficulty;
	private String type;
	private String text;
	private Clip audio;
	private Image image;
	private String correct;
	
	public Question(int ID, int difficulty, String text, String correct){
		this.type = "SA";
		this.text = text;
		//this.audio = audio;
		//this.image = image;
		this.correct = correct;
	}
	
	
	public boolean evaluateAnswer(String response){
		return response.toUpperCase().equals(correct);
	}
	private Display genDisplay(){
		return new Display();
	}
	public Display getDisplay(){
		return genDisplay();
	}
	
	public String getType(){
		return type;
	}
	public String getText(){
		return text;
	}
	public Clip getAudio(){
		return audio;
	}
	public Image getImage(){
		return image;
	}
	public void setText(String text){
		this.text = text;
	}
	public void setAudio(Clip audio){
		this.audio = audio;
	}
	public void setImage(Image image){
		this.image = image;
	}


	@Override
	public int compareTo(Question arg0) {
		return Integer.compare(this.difficulty, arg0.difficulty);
	}
}
