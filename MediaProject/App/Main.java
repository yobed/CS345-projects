package app;

import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

import gui.*;
public class Main
{
  public static void main(String[] args) {
    
    JFrame frame = new JFrame("Transcriptz");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel contentPane = (JPanel)frame.getContentPane();
    contentPane.setLayout(new BorderLayout());
    
    String[] courses = {"CS101", "CS227", "CS345", "MATH", "REL"};
    Map<String, Double> weights = new HashMap<String, Double>();
    weights.put("CS101", 3.0);
    weights.put("CS227", 3.0);
    weights.put("CS345", 3.0);
    weights.put("MATH", 3.0);
    weights.put("REL", 3.0);
    CompositeGradeEntryPanel a = new CompositeGradeEntryPanel(courses, weights);
    GPAPanel gpaPanel = new GPAPanel();
    gpaPanel.setCompositeGradeSubject(a); 
    a.addActionListener(gpaPanel);
    
    // Layout the GUI
    contentPane.add(a, BorderLayout.CENTER);
    contentPane.add(gpaPanel, BorderLayout.SOUTH);
    

    frame.setSize(500, 300);
    frame.setVisible(true);
  }
}
