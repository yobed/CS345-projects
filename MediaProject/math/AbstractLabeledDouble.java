package math;
/**
 * An abstract parent for classes that must implement the LabeledDouble
 * interface.
 * 
 * @author Prof. David Bernstein, James Madison University
 * @version H5
 */
public abstract class AbstractLabeledDouble implements LabeledDouble
{
  private static final String NA = "N/A";

  protected String       label;

  /**
   * Initialize the label of this AbstractLabeledDouble.
   * 
   * @param label    The label
   * @throws IllegalArgumentException if the label is null or empty
   */
  protected AbstractLabeledDouble(final String label) throws IllegalArgumentException
  {
    if ((label == null) || label.equals("")) throw new IllegalArgumentException();

    this.label = label;
  }

  /**
   * Compare this LabeledDouble object with the specified LabeledDouble object for order
   * (required by LabeledDouble).
   *
   * @param other  The object to compare to
   * @return       -1/0/1 depending on whether this </==/> other
   */
  public int compareTo(final LabeledDouble other)
  {
    int result;

    if ((this.getValue() == null) && (other.getValue() == null)) result = 0;
    else if (this.getValue() == null) result = -1;
    else if (other.getValue() == null) result = 1;
    else result = Numerics.signum(this.getValue().compareTo(other.getValue()));

    return result;        
  }

  /**
   * Get the label associated with this LabeledDouble object
   * (required by LabeledDouble).
   *
   * @return   The label
   */
  @Override
  public String getLabel()
  {
    return label;        
  }

  /**
   * Create a String representation of this LabeledDouble.
   *
   * @param verbose   true to return a verbose representation; false for terse
   * @return  The String representation
   */
  @Override
  public String toString(final boolean verbose)
  {
    Double value = getValue();
    String result;

    if (verbose)
    {
      if ((value == null) || value.isNaN()) result = String.format("%s: %s",   label, NA);
      else                                  result = String.format("%s: %f", label, value);
    }
    else
    {
      if ((value == null) || value.isNaN()) result = String.format("%s",   NA);
      else                                  result = String.format("%f", value);
    }

    return result;
  }

  /**
   * Create a terse String representation of this LabeledDouble.
   *
   * @return  The String representation
   */
  @Override
  public String toString()
  {
    return toString(false);
  }
}
