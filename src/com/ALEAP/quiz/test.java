package com.ALEAP.quiz;
import java.awt.*;

import javax.sound.sampled.Clip;
import javax.swing.*;

import com.ALEAP.objects.Display;
import com.ALEAP.objects.MulitipleChoiceQuestion;

public class test {

	public static void main(String[] args) {  
		String[] x = {"1","2","3","4"};
	    Display d = new Display(new MulitipleChoiceQuestion(1,1,"Choose Option \"1\"", "1",x));
	}
	public static void answer(boolean result){
		if(result){
			System.out.println("Correct");
		}else{
			System.out.println("Incorrect");
		}
	}
}
