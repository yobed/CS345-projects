package gui;

import grading.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

/**
 * GradeEntryPanel.
 * 
 * This work complies with the JMU Honor Code.
 * 
 * @author Patrick DeBoy
 * @version H6
 */
public class GradeEntryPanel extends JPanel
{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private JComboBox<String> gradeField;
  private JLabel creditLabel;
  private String na = "N/A";

  /**
   * Constructor and Initializer for GradeEntryPanel.
   * 
   * @param course
   *          Course
   * @param credits
   *          Credit
   */
  public GradeEntryPanel(final String course, final double credits)
  {
    gradeField = new JComboBox<String>();
    gradeField.addItem(na);
    for (LetterGrade a : LetterGrade.values())
    {
      gradeField.addItem(a.getLabel());
    }
    JLabel titleCourse;

    // Set course label
    titleCourse = new JLabel();
    titleCourse.setText(course);
    // Set credits
    creditLabel = new JLabel();
    creditLabel.setText(Double.toString(credits) + " credits");
    // Set layout
    Border blackline = BorderFactory.createLineBorder(Color.black);
    JPanel panel = new JPanel();
    setLayout(new GridLayout(2, 1));
    panel.setBorder(blackline);
    Border border = panel.getBorder();
    Border margin = new EmptyBorder(10, 10, 10, 10);
    panel.setBorder(new CompoundBorder(border, margin));
    // Add to panel
    add(titleCourse);
    panel.setLayout(new BorderLayout());
    panel.add(gradeField, BorderLayout.CENTER);
    panel.add(creditLabel, BorderLayout.SOUTH);
    add(panel);

  }

  /**
   * Adds the listener to the JComboBox.
   * 
   * @param listener
   *          Listener
   */
  public void addActionListener(final ActionListener listener)
  {
    gradeField.addActionListener(listener);
  }

  /**
   * Returns the (string) of selected grade.
   * 
   * @return Grade String
   */
  public String getGrade()
  {

    return (String) gradeField.getSelectedItem();
  }

  /**
   * Resets the selection.
   */
  public void reset()
  {
    gradeField.setSelectedItem(na);
  }

}
