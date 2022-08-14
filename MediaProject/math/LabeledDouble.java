package math;

/**
 * The requirements of a LabeledDouble.
 * 
 * @author Prof. David Bernstein, James Madison University
 * @version H5
 */
public interface LabeledDouble extends Comparable<LabeledDouble> 
{
  /**
   * Get the label associated with this LabeledDouble object.
   *
   * @return   The label
   */
  public abstract String getLabel();

  /**
   * Get the numeric value associated with this LabeledDouble object.
   *
   * @return   The numeric value (or null for missing)
   */
  public abstract Double getValue();
  
  /**
   * Create a String representation of this LabeledDouble.
   *
   * @param verbose   true to return a verbose representation; false for terse
   * @return  The String representation
   */
  public abstract String toString(final boolean verbose);
  
  /**
   * Create a terse String representation of this LabeledDouble.
   *
   * @return  The String representation
   */
  public abstract String toString();
}
