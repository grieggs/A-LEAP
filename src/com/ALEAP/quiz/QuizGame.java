package com.ALEAP.quiz;
import java.io.File;

import com.ALEAP.io.Display;
import com.ALEAP.io.QuizFileChooser;
import com.ALEAP.objects.*;


public class QuizGame {
	static boolean quizLoaded = false;
	static boolean active = true;
	static Quiz q;
	static Display activeDisplay;
	public static void main(String[] args){
		//QuizFileChooser qfc = new QuizFileChooser();
		//qfc.createAndShowGUI();
		try{GetQuiz(com.ALEAP.io.QuizIO.readQuiz(new File("H:\\xxxx\\quiz.ser")));}
		catch(Exception E){
			System.out.println(E);
		}
		while(!quizLoaded){
			//wait
		}
		System.out.println("Made it");
		//qfc.setVisible(false);
		while(q.hasNextTopic()){
			Topic t = q.nextTopic();
			while(t.hasNextQuestion()){
				Question que = t.nextQuestion();
				if(que instanceof MultipleChoiceQuestion){
					activeDisplay = new Display((MultipleChoiceQuestion)que);
				}else{
					activeDisplay = new Display(que);
				}
				while(active){
					//wait
				}
				active = true;
			}
		}
		
	}
	public static void answer(boolean correct){
		if(correct){
			System.out.println("correct");
			activeDisplay.close();
		}else{
			System.out.println("incorrect");
		}
		active = false;
	}
	public static void GetQuiz(Quiz iq){
		quizLoaded = true;
		q = iq;
	}
}
