package com.ALEAP.quiz;
import java.io.File;
import java.util.Scanner;

import com.ALEAP.objects.MulitipleChoiceQuestion;
import com.ALEAP.objects.Question;
import com.ALEAP.objects.Quiz;
import com.ALEAP.objects.QuizIO;
import com.ALEAP.objects.Topic;
public class CLQuizDesigner {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		boolean done = false;
		System.out.print("Please enter a name for your quiz: ");
		String quizName = in.nextLine();
		Quiz newQuiz = new Quiz(quizName);
		while(!done){
			int topicId = 0;
			System.out.print("Add new topic (Y/N): ");
			String input = in.nextLine();
			if(input.toUpperCase().equals("N")){
				done = true;
			}
			else if(input.toUpperCase().equals("Y")){
				System.out.print("Please enter the topic's name: ");
				String topicName = in.nextLine();
				newQuiz.addTopic(new Topic(topicName));
				boolean tDone = false;
				int questId = 0;
				while (!tDone){
					System.out.print("Please enter MC or Q to add a question or D to finish this topic: ");
					String input1 = in.nextLine();
					if(input1.toUpperCase().equals("MC")){
						System.out.print("Please enter the question text: ");
						String question = in.nextLine();
						System.out.print("Please enter 4 possible answers starting with the correct answer: ");
						String[] answers = new String[4];
						for(int x = 0; x < 4; x++){
							answers[x] = in.nextLine();
						}
						System.out.print("Please enter the question's difficulty: ");
						int diff = in.nextInt();
						in.nextLine();
						newQuiz.getTopic(topicId).addQuestion(new MulitipleChoiceQuestion(questId++, diff, question, answers[0], answers));
					}
					else if(input1.toUpperCase().equals("Q")){
						System.out.print("Please enter the question's text: ");
						String quest = in.nextLine();
						System.out.print("Please enter the question's difficulty: ");
						int dif = in.nextInt();
						in.nextLine();
						System.out.print("Please enter the correct Answer: ");
						String answer = in.nextLine();

						newQuiz.getTopic(topicId).addQuestion(new Question(questId++, dif, quest, answer));
					}
					else{
						tDone = true;
					}
				}
				topicId++;
			}
			else{
				System.out.println("Invaild Answer");
			}
		}
		//ystem.out.print("Please input the write location: ");
		//File x = new File(in.nextLine);
		File x = new File("H:\\");
		QuizIO.writeQuiz(x, newQuiz, newQuiz.getName());


	}
}
