package com.ALEAP.objects;
import java.awt.Image;

import javax.sound.sampled.Clip;

public class MultipleChoiceQuestion extends Question {
	private String[] options;
	private String type;
	
	public MultipleChoiceQuestion(int id, int difficulty, String text, String correct, String[] options, int corAnswers, int inAnswers) {
		//super(text, audio, image, correct);
		super(id, difficulty, text, correct, corAnswers, inAnswers);
		this.type = "MC";
		this.options = options;
	}
        
        @Override
        public String getType(){
            return "MC";
        }
        
	public String[] getOptions(){
		return options;
	}
	
	public void setOptions(String[] options){
		this.options = options;
	}

}
