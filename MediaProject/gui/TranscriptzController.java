package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Transcriptz Controller.
 * 
 * This work complies with the JMU Honor Code.
 * 
 * @author Patrick DeBoy
 * @version H6
 */
public class TranscriptzController implements ActionListener
{
  public static final String FILE = "File";
  public static final String GRADES = "Grades";
  public static final String QUIT = "Exit";
  public static final String RESET = "Reset";
  private CompositeGradeEntryPanel entryPanel;

  /**
   * Constructor for the TranscriptzController.
   * 
   * @param entryPanel
   */
  public TranscriptzController(final CompositeGradeEntryPanel entryPanel)
  {
    this.entryPanel = entryPanel;
  }

  @Override
  public void actionPerformed(final ActionEvent e)
  {
    
    String ac;

    ac = e.getActionCommand();

    if (ac.equals(QUIT))
    {
      System.exit(0);
    }
    if (ac.equals(RESET))
    {
      entryPanel.reset();
    }

  }

}
