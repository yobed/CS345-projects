package math;

/**
 * A utility class for working with Number objects and numeric values.
 * 
 * @author Prof. David Bernstein, James Madison University
 * @version H5
 */
public class Numerics 
{
  public static final double DEFAULT_MISSING_VALUE = 0.0;

  /**
   * Return the global default value if the given Double is null. Otherwise return its double value.
   * 
   * @param   number  The number to check
   * @return  The appropriate double value
   */
  public static double doubleValueOf(final Double number)
  {
    return doubleValueOf(number, DEFAULT_MISSING_VALUE);
  }

  /**
   * Return the given missing value if the given Double is null. Otherwise return its double value.
   * This method should only be used when the DEFAULT_MISSING_VALUE is inappropriate.
   * 
   * @param   number  The number to check
   * @param   missingValue The value to use in place of missing
   * @return  The appropriate double value
   */
  public static double doubleValueOf(final Double number, final double missingValue)
  {
    return doubleValueOf(number, missingValue, Double.NEGATIVE_INFINITY);
  }

  /**
   * Return the given missing value if the given Double is null or its double value is less than 
   * the given bound. Otherwise return its double value.
   * 
   * @param   number  The number to check
   * @param   missingValue The value to use in place of missing
   * @param   lowerBound  The lower bound of valid values
   * @return  The appropriate double value
   */
  public static double doubleValueOf(final Double number, final double missingValue, 
      final double lowerBound)
  {
    if ((number == null) || (number.doubleValue() < lowerBound)) return missingValue;
    else                                                         return number.doubleValue();
  }
  
  /**
   * Return the sign of the given int.
   * 
   * @param n  The int of interest
   * @return   The sign
   */
  public static int signum(final int n)
  {
    if      (n < 0) return -1;
    else if (n > 0) return  1;
    else            return  0;
  }

}
