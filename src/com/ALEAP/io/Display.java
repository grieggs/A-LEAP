package com.ALEAP.io;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import java.util.*;

import javax.swing.*;

import com.ALEAP.objects.MultipleChoiceQuestion;
import com.ALEAP.objects.Question;
import com.ALEAP.quiz.QuizGame;


public class Display {
	private JFrame f;
	public Display() {

	}

	public Display(Question q) {
		f = new JFrame();
		f.setLayout(new BorderLayout());
		JPanel p = getTopPanel(q);
		p.setBackground(Color.red);
		f.add(p, BorderLayout.PAGE_START);
		//Question panel
		JPanel p1 = new JPanel();
		p1.setBackground(Color.blue);
		final JTextField textField = new JTextField();
		p1.add(textField);
		p1.add(new JPanel());
		JButton button = new JButton("Submit");
		button.addActionListener(new ActionListener()
		{
			   public void actionPerformed(ActionEvent e)
			   {
			            QuizGame.answer(q.evaluateAnswer(textField.getText()));
			   }
			});
		
		p1.add(button);
		
		
		f.add(p1, BorderLayout.CENTER);
		p1.setLayout(new GridLayout(4, 1));
		p1.setSize(300, 300);
		p1.setVisible(true);
		
		
		
		f.setSize(300, 500);
		f.setVisible(true);
	}

	public Display(MultipleChoiceQuestion q) {
		f = new JFrame();
		f.setLayout(new BorderLayout());
		JPanel p = getTopPanel(q);
		p.setBackground(Color.red);
		f.add(p, BorderLayout.PAGE_START);
		
		//Button panel
		JPanel p1 = new JPanel();
		p1.setBackground(Color.blue);
		String[] options = q.getOptions();
		int noOptions = options.length;
		ArrayList<JButton> buttons = new ArrayList<JButton>();

		for(int x = 0; x < noOptions; x++){
			buttons.add(new JButton(options[x]));
		}
		
		Collections.shuffle(buttons);
		
		for(int x = 0; x < noOptions; x++){
			p1.add(buttons.get(x));
			buttons.get(x).addActionListener(new ActionListener()
			{
			   public void actionPerformed(ActionEvent e)
			   {
			        Object source = e.getSource();
			        if (source instanceof JButton) {
			            JButton btn = (JButton)source;
			            QuizGame.answer(q.evaluateAnswer(btn.getText()));
			        }
			   }
			});
			buttons.get(x).setVisible(true);
		}
		f.add(p1, BorderLayout.CENTER);
		p1.setLayout(new GridLayout(4, 1));
		p1.setSize(300, 300);
		p1.setVisible(true);
		
		
		
		f.setSize(300, 500);
		f.setVisible(true);
	}
	
	public void close(){
		f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
	}
	
	private JPanel getTopPanel(Question q){
		JPanel out = new JPanel();
		
		JLabel text = new JLabel();
		
		text.setText(q.getText());
		
		text.setVisible(true);
		out.add(text);
		
		out.setSize(100,300);
		return out;
	}
}
