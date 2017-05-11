package com.ALEAP.io;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import com.ALEAP.objects.MultipleChoiceQuestion;
import com.ALEAP.objects.Question;
import com.ALEAP.objects.Quiz;
import com.ALEAP.objects.Topic;

public class QuizIO {
	public static Quiz readQuiz(File quizLocation) throws Exception{
			// read object from file
			FileInputStream fis = new FileInputStream(quizLocation);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Quiz result = (Quiz) ois.readObject();
			ois.close();
			return result;
	}
	public static boolean writeQuiz(File quizLocation, Quiz q){
		ObjectOutputStream oos = null;
		try{
			// write the quiz object to a file
			FileOutputStream fos = new FileOutputStream(quizLocation);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(q);
			oos.close();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	    return true;
	}
	public static Quiz readQuizFromCSV(File quizLocation) throws Exception{
		Scanner in = new Scanner(quizLocation);
		Quiz q = new Quiz(in.nextLine());
		while(in.hasNextLine()){
			String[] input = in.nextLine().split(",");
			Topic t = new Topic(input[0]);
			q.addTopic(t);
			int qindex = 0;
			for(int i = 1; i < input.length;  i++){
				System.out.println(input[i]);
				if(input[i].toUpperCase().equals("Q")){
					t.addQuestion(new Question(qindex++, Integer.parseInt(input[i+3]), input[i+1], input[i+2],Integer.parseInt(input[i+3]),Integer.parseInt(input[i+4])));
					System.out.println(input[i+2]);
					i=i+3;
				}else if(input[i].toUpperCase().equals("MC")){
					String[] answers = {input[i+2],input[i+3],input[i+4],input[i+5]};
					t.addQuestion(new MultipleChoiceQuestion(qindex++, Integer.parseInt(input[i+6]), input[i+1], input[i+2], answers,Integer.parseInt(input[i+7]),Integer.parseInt(input[i+8])));
					System.out.println(input[i+2]);
					i=i+6;
				}
			}
		}
		return q;
	}
}
