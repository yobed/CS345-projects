package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

/**
 * GPAPanel.
 * 
 * This work complies with the JMU Honor Code.
 * 
 * @author Patrick DeBoy
 * @version H6
 */
public class GPAPanel extends JLabel implements ActionListener
{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private CompositeGradeSubject subject;
  private String na = "N/A";
  private String gpa = "GPA: ";

  /**
   * Constructor for GPA panel.
   */
  public GPAPanel()
  {

    setText(gpa + na);
  }

  /**
   * Reacts to the Action Event.
   * @param evt Event
   */
  public void actionPerformed(final ActionEvent evt)
  {
    updateLayout();
  }

  /**
   * Sets the subject to parameter subj.
   * 
   * @param subj
   *          Object
   */
  public void setCompositeGradeSubject(final CompositeGradeSubject subj)
  {
    this.subject = subj;
  }

  /**
   * Updates the layout.
   */
  private void updateLayout()
  {
    if (subject.getGradeHistory().getValue() != null)
    {
      setText(gpa + subject.getGradeHistory().getValue());
    }
    else
    {
      setText(gpa + na);
    }

  }
}
