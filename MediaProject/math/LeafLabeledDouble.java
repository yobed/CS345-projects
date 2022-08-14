package math;
/** 
 * A simple, concrete LabeledDouble object.
 * 
 * @author Prof. David Bernstein, James Madison University
 * @version H5
 */
public class LeafLabeledDouble extends AbstractLabeledDouble
{
  private Double        value;


  /**
   * Construct a LabeledDouble with the given key and a value of 0.0.
   *
   * @param label  The key used to identify this LabeledDouble object
   * @throws     IllegalArgumentException if key is null or the empty string
   */
  public LeafLabeledDouble(final String label) throws IllegalArgumentException
  {
    this(label, Double.valueOf(0.0));        
  }

  /**
   * Construct a LabeledDouble with the given key and value.
   *
   * @param label   The key used to identify this LabeledDouble object
   * @param value The value of this LabeledDouble
   * @throws      IllegalArgumentException if key is null or the empty string
   */
  public LeafLabeledDouble(final String label, final double value) 
      throws IllegalArgumentException
  {
    this(label, Double.valueOf(value));
  }

  /**
   * Construct a LabeledDouble with the given key and value.
   *
   * @param label   The key used to identify this LabeledDouble object
   * @param value The value of this LabeledDouble
   * @throws      IllegalArgumentException if key is null or the empty string
   */
  public LeafLabeledDouble(final String label, final Double value) 
      throws IllegalArgumentException
  {
    super(label);
    this.value = value;
  }

  /**
   * Get the numeric value associated with this LabeledDouble object.
   *
   * @return   The numeric value (or null for missing)
   */
  public Double getValue()
  {
    return value;        
  }
}
