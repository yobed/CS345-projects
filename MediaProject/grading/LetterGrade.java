package grading;

/**
 * An encapsulation of a letter grade (e.g., in a college course).
 * 
 * @author Prof. David Bernstein, James Madison University
 * @version H1
 */
public enum LetterGrade
{
  F ("F", 0.0),
  DMINUS ("D-", 0.7),
  D ("D", 1.0),
  DPLUS ("D+", 1.3),
  CMINUS ("C-", 1.7),
  C ("C", 2.0),
  CPLUS ("C+", 2.3),
  BMINUS ("B-", 2.7),
  B ("B", 3.0),
  BPLUS ("B+", 3.3),
  AMINUS ("A-", 3.7),
  A ("A", 4.0);
  
  private String label;
  private Double points;
  
  /**
   * Explicit value constructor.
   * 
   * @param label  The label for the LetterGrade
   * @param points The numeric points associated with the LetterGrade
   */
  private LetterGrade(final String label, final double points)
  {
    this.label = label;
    this.points = Double.valueOf(points);
  }
  
  /**
   * Get the LetterGrade associated with a particular code.
   * 
   * @param code  The code of interest
   * @return The corresponding LetterGrade (or null)
   */
  public static LetterGrade fromCode(final String code)
  {
    for (LetterGrade p: values())
    {
      if (code.equals(p.label)) return p;
    }
    return null;
  }
  
  /**
   * Get the label of this LetterGrade.
   * 
   * @return The label
   */
  public String getLabel()
  {
    return label;
  }
  
  /**
   * Get the numeric value of this LetterGrade.
   * 
   * @return  The numeric value
   */
  public Double getValue()
  {
    return points;
  }
  
  /**
   * Get the String representation of this LetterGrade.
   * 
   * @return The String representation
   */
  @Override
  public String toString()
  {
    return String.format("%-2s (%3.1f)", label, points.doubleValue());
  }
}
