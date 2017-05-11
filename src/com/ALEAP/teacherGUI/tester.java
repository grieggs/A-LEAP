/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ALEAP.teacherGUI;

import com.ALEAP.objects.*;

/**
 *
 * @author Sam
 */
public class tester {
    public static void main(String args[]){
        Quiz x = new Quiz("!@#!@#");
        x.addTopic(new Topic("Test Topic, Please Ignore"));
        QuizEditor q = new QuizEditor();
        q.setQuiz(x);
        q.setVisible(true);
        System.out.println("Adfasdfasdfasdf");
    }
}
