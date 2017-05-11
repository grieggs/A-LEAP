/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ALEAP.Studentgui;

import com.ALEAP.objects.*;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 *
 * @author Sam
 */
public class QuizHost implements Runnable{
        ArrayList<Question> Questions;
        boolean toggle;
        int correct;
        int incorrect;
        int counter;
        String[] yourAnswers;
        String[] correctAnswers;
        boolean[] right;
        QuizFrame[] q;
    
       public QuizHost(Topic t){
           Questions = t.getQuestionList();
           this.toggle = false;
           this.correct = 0;
           this.incorrect = 0;
           this.counter = 0;
           this.yourAnswers = new String[this.Questions.size()];
           System.out.println(yourAnswers.length);
           this.correctAnswers = new String[this.Questions.size()];
           this.right = new boolean[this.Questions.size()];
           
       }
       public QuizHost(Quiz q){
           this.Questions = q.allQuestions();
           this.toggle = false;
           this.correct = 0;
           this.incorrect = 0;
           this.counter = 0;
           this.yourAnswers = new String[this.Questions.size()];
           System.out.println(yourAnswers.length);
           this.correctAnswers = new String[this.Questions.size()];
           this.right = new boolean[this.Questions.size()];
           
       }
       
       public void run(){
           Collections.shuffle(this.Questions);
           counter = 0;
           q = new QuizFrame[this.Questions.size()];
           for(int x = 0; x < this.Questions.size(); x++){
               
               toggle = true;
               q[x] = new QuizFrame(this, this.Questions.get(x));
           }
           q[0].setVisible(true);
           
       }
       
       public void toggleListener(String answer){
           Question active = this.Questions.get(this.counter);
           this.yourAnswers[this.counter] = answer;
           this.correctAnswers[this.counter] = active.getCorrect();
           
           this.right[this.counter] = active.evaluateAnswer(answer);
           if(right[this.counter]){
               this.correct++;
               JOptionPane.showMessageDialog(null, "Correct!");
           }else{
               this.incorrect++;
               JOptionPane.showMessageDialog(null, "Incorrect!");
           }
           this.toggle = false;
           this.counter++;
           if(this.counter < this.Questions.size()){
                this.q[this.counter].setVisible(true);
           }else{
               ResultsCase out = new ResultsCase(Questions,correct,incorrect,yourAnswers,correctAnswers,right);
               out.setVisible(true);
           }
           
       }
}
