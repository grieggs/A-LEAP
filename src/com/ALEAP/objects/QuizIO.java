package com.ALEAP.objects;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class QuizIO {
	public static Quiz readQuiz(File quizLocation){
		try{
			// read object from file
			FileInputStream fis = new FileInputStream("mybean.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Quiz result = (Quiz) ois.readObject();
			ois.close();
			return result;
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
	}
	public static boolean writeQuiz(File quizLocation, Quiz q, String filename){
		try{
			// write the quiz object to a file
			quizLocation = new File(quizLocation.getAbsolutePath() + File.pathSeparator + filename);
			FileOutputStream fos = new FileOutputStream(filename + ".ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(q);
			oos.close();
			return true;
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
	}
}
