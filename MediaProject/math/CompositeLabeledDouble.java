package math;
import java.util.*;


/**
 * A composite (in the sense of the Composite Pattern) of LabeledDouble objects.
 *
 * @author  Prof. David Bernstein, James Madison University
 * @version H5
 */
public class CompositeLabeledDouble extends AbstractLabeledDouble
{
  private List<LabeledDouble> components;
  private Filter filter;    
  private Calculator calculator;    

  /**
   * Explicit Value Constructor.
   *
   * @param label    The key for this CompositeLabeledDouble object
   * @param filter   The Filter to apply (or null to not apply a Filter)
   * @param calculator The Calculator to use (or null if the value should always be missing/null)
   * @throws       IllegalArgumentException if key is null or the empty string
   */
  public CompositeLabeledDouble(final String label, final Filter filter,
      final Calculator calculator) throws IllegalArgumentException
  {
    super(label);
    this.filter   = filter;
    this.calculator = calculator;
    components  = new ArrayList<LabeledDouble>();
  }

  /**
   * Add a LabeledDouble object to this CompositeLabeledDoubled.
   *
   * @param labeledDouble   The LabeledDouble object to add
   */
  public void add(final LabeledDouble labeledDouble)
  {
    components.add(labeledDouble);
  }
  
  /**
   * Get a filtered copy of the components.
   * 
   * Note that if the filter is null, this method returns a copy of the
   * complete List.
   * 
   * @return A List containing the components after applying the filter
   */
  public List<LabeledDouble> filter() throws SizeException
  {
    List<LabeledDouble> result;
    if (filter == null)
    {
      result = new ArrayList<LabeledDouble>();
      for (LabeledDouble element: components) result.add(element);
    }
    else
    {
      result = filter.apply(components);
    }
    return result;
  }
  
  // NOTE: We can't cover the catch block since the List will never be null!!
  /**
   * Get the value of this LabeledDouble object (required by LabeledDouble).
   * 
   * If there is no Filter then all of the components are used by the Calculator, otherwise
   * the result of Filter.apply() is used by the Calculator.
   *
   * If there is no Calculator then null is returned.
   * 
   * If Filter.apply() or Calculator.calculate() throws a SizeException then null is returned.
   *
   * @return   The value of this LabeledDouble object (or null for missing)
   */
  public Double getValue()
  {
    Double result;
    List<LabeledDouble> filtered;

    result   = null;
    filtered = components;
    try
    {
      if (filter   != null) filtered = filter.apply(components);
      if (calculator != null) 
      {
        LabeledDouble s = calculator.calculate(getLabel(), filtered);
        result   = s.getValue();
      }
    }
    catch (SizeException se)
    {
      // Return null (the default)
    }
    return result;
  }
}
