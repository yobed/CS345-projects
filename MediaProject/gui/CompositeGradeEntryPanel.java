package gui;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import math.*;
import javax.swing.*;

import grading.LetterGrade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * CompositeGradeEntryPanel.
 * 
 * This work complies with the JMU Honor Code.
 * 
 * @author Patrick DeBoy
 * @version H6
 */
public class CompositeGradeEntryPanel extends JPanel implements CompositeGradeSubject
{
  private static final long serialVersionUID = 1L;
  private String[] courses;
  private Collection<GradeEntryPanel> aggregate;

  /**
   * The constructor for CompositeGradeEntryPanel sets up the panel for multiple GradeEntryPanel(s).
   * 
   * @param courses
   *          String
   * @param map
   *          Map
   */
  public CompositeGradeEntryPanel(final String[] courses, final Map<String, Double> map)
  {
    this.courses = courses;
    aggregate = new ArrayList<GradeEntryPanel>();
    for (String course : courses)
    {
      aggregate.add(new GradeEntryPanel(course, map.get(course)));
    }
    GridLayout lay = new GridLayout(1, aggregate.size());
    lay.setHgap(10);
    setLayout(lay);

    for (GradeEntryPanel a : aggregate)
    {
      add(a);
    }

  }

  /**
   * Adds the listener to panel.
   * 
   * @param listener
   *          listener
   */
  public void addActionListener(final ActionListener listener)
  {
    for (GradeEntryPanel a : aggregate)
    {
      a.addActionListener(listener);
    }
  }

  /**
   * Resets the selection for all panels.
   */
  public void reset()
  {
    for (GradeEntryPanel a : aggregate)
    {
      a.reset();
    }
  }

  /**
   * Returns the CompositeLabeledDouble of panels.
   * 
   * @return CompositeLabeledDouble Object
   */
  @Override
  public CompositeLabeledDouble getGradeHistory()
  {
    CompositeLabeledDouble a = new CompositeLabeledDouble("Grades", null,
        new WeightedAverageCalculator());
    for (GradeEntryPanel gep : aggregate)
    {
      if (LetterGrade.fromCode(gep.getGrade()) != null)
      {
        a.add(new LeafLabeledDouble("Grade", LetterGrade.fromCode(gep.getGrade()).getValue()));
      }

    }
    return a;

  }
}
