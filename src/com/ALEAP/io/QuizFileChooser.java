package com.ALEAP.io;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;

import com.ALEAP.objects.Quiz;
import com.ALEAP.quiz.QuizGame;

public class QuizFileChooser extends JPanel implements ActionListener{
	static private final String newline = "\n";
	JButton openButton;
	JTextArea log;
	JFileChooser fc;
	JFrame frame;
	
	public QuizFileChooser(){
		super(new BorderLayout());
		
		log = new JTextArea(5,20);
		log.setEditable(false);
		JScrollPane logScrollPane = new JScrollPane(log);
		
		fc = new JFileChooser();
		
		openButton = new JButton("Select a Quiz");
		openButton.addActionListener(this);
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(openButton);
        add(buttonPanel, BorderLayout.PAGE_START);
        add(logScrollPane, BorderLayout.CENTER);
	} 
	
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource() == openButton){
			
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Quiz Files", "ser", "ser");
			fc.setFileFilter(filter);
			
			int returnVal = fc.showOpenDialog(QuizFileChooser.this);
			
			if(returnVal == JFileChooser.APPROVE_OPTION){
				File file = fc.getSelectedFile();
				try{
					QuizGame.GetQuiz(QuizIO.readQuiz(file));
				}catch(Exception f){
					log.append("Error: " + f + newline);
				};
			}else{
				log.append("Open command cancelled by user." + newline);
			}
			log.setCaretPosition(log.getDocument().getLength());
		}
	}
	
    public void createAndShowGUI() {
        frame = new JFrame("A-LEAP Quiz Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new QuizFileChooser());
        frame.pack();
        frame.setVisible(true);
    }
    
    @Override
    public void setVisible(boolean x){
    	frame.setVisible(x);
    }

}
