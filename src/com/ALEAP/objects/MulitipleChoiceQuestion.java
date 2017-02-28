package com.ALEAP.objects;
import java.awt.Image;

import javax.sound.sampled.Clip;

public class MulitipleChoiceQuestion extends Question {
	private String[] options;
	private String type;
	
	public MulitipleChoiceQuestion(int id, int difficulty, String text, String correct, String[] options) {
		//super(text, audio, image, correct);
		super(id, difficulty, text, correct);
		this.type = "MC";
		this.options = options;
	}
	
	public String[] getOptions(){
		return options;
	}
	
	public void setOptions(String[] options){
		this.options = options;
	}

}
