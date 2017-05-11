/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ALEAP.Studentgui;

import com.ALEAP.objects.Question;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Sam
 */
public class ResultsCase extends javax.swing.JFrame {
    ArrayList<Question> Questions;
    int correct;
    int incorrect;
    int counter;
    String[] yourAnswers;
    String[] correctAnswers;
    boolean[] right;
    /**
     * Creates new form ResultsCase
     */
    public ResultsCase(ArrayList<Question> Questions,int correct, int incorrect, String[] yourAnswers, String[] correctAnswers, boolean[]right) {
        initComponents();
        this.Questions = Questions;
        this.correct = correct;
        this.incorrect = incorrect;
        this.yourAnswers = yourAnswers;
        this.correctAnswers = correctAnswers;
        this.right = right;
        DefaultListModel out = new DefaultListModel();
        for(int x = 0; x< Questions.size(); x++){
            String zed = "Question "  + (x+1) + " " + Questions.get(x).getText() + " " + ((right[x]) ? "correct " : "incorrect") + "Your Answer : " + yourAnswers[x];
            out.addElement(zed);
        }
        resultsList.setModel(out);
        resultsLabel.setText("Totals: " + correct + " Correct, "+ incorrect + " incorrect");
        this.repaint();
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        resultsList = new javax.swing.JList<>();
        resultsLabel = new javax.swing.JLabel();
        Title = new javax.swing.JLabel();
        caButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(resultsList);

        resultsLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        resultsLabel.setText("Totals:");

        Title.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        Title.setText("Results");

        caButton.setText("See Correct Answer");
        caButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(Title)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(resultsLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(caButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
                        .addGap(51, 51, 51))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(Title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(caButton)
                .addGap(25, 25, 25)
                .addComponent(resultsLabel)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void caButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caButtonActionPerformed
        // TODO add your handling code here:
        int index = this.resultsList.getSelectedIndex();
        if(index != -1){
            JOptionPane.showMessageDialog(null, Questions.get(index).getText() +"\nYour Answer: "+yourAnswers[index] + "\nCorrect Answer: " + correctAnswers[index]);
        }
       
    }//GEN-LAST:event_caButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ResultsCase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResultsCase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResultsCase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResultsCase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new ResultsCase(null,null,).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Title;
    private javax.swing.JButton caButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel resultsLabel;
    private javax.swing.JList<String> resultsList;
    // End of variables declaration//GEN-END:variables
}
