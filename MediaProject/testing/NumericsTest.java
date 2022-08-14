package testing;
import math.Numerics;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Numerics Testing class.
 * 
 * This work complies with the JMU Honor Code.
 * 
 * @author Patrick DeBoy
 * @version H1
 */
class NumericsTest
{

  /**
   * Tests the doubleValueOf, one parameter, method.
   */
  @Test
  void testDoubleValueOfDouble()
  {
    //Coverage
    Numerics a = new Numerics() {
    };
    
    double num = 10.0;
    Double obj = 10.0;
    Double objNull = null;
    assertEquals(Numerics.doubleValueOf(obj), num);
    assertEquals(Numerics.doubleValueOf(objNull), 0.0);
  }

  /**
   * Tests the doubleValueOf, two parameter, method.
   */
  @Test
  void testDoubleValueOfDoubleDouble()
  {
    double num = 10.0;
    double missingVal = 2.0;
    Double obj = 10.0;
    Double objNull = null;
    assertEquals(Numerics.doubleValueOf(obj, missingVal), num);
    assertEquals(Numerics.doubleValueOf(objNull, missingVal), missingVal);
  }

  /**
   * Tests the doubleValueOf, three parameter, method.
   */
  @Test
  void testDoubleValueOfDoubleDoubleDouble()
  {
    double num = 10.0;
    double missingVal = 2.0;
    double threshold = 11;
    double threshold2 = 5;
    Double obj = 10.0;
    Double objNull = null;
    assertEquals(Numerics.doubleValueOf(obj, missingVal, threshold), missingVal);
    assertEquals(Numerics.doubleValueOf(objNull, missingVal, threshold), missingVal);
    assertEquals(Numerics.doubleValueOf(obj, missingVal, threshold2), num);
  }

  /**
   * Tests the sigNum method.
   */
  @Test
  void testSignum()
  {
    int n1 = -1;
    int n2 = 0;
    int n3 = 3;
    assertEquals(Numerics.signum(n1), -1);
    assertEquals(Numerics.signum(n2), 0);
    assertEquals(Numerics.signum(n3), 1);
  }

}
