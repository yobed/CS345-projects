package testing;
import math.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import math.LeafLabeledDouble;

/**
 * LabeledDouble Testing class.
 * 
 * This work complies with the JMU Honor Code.
 * 
 * @author Patrick DeBoy
 * @version H1
 */
class LabeledDoubleTest
{

  String na = "N/A";
  
  /**
   * Tests the explicit constructor, one parameter, method.
   */
  @Test
  void testLabeledDoubleString()
  {
    LeafLabeledDouble j = new LeafLabeledDouble("Testing");
    assertThrows(IllegalArgumentException.class, () -> 
    {
      LeafLabeledDouble a = new LeafLabeledDouble(null);

    });
    assertThrows(IllegalArgumentException.class, () -> 
    {
      LeafLabeledDouble a = new LeafLabeledDouble("");

    });
  }

  /**
   * Tests the explicit constructor, two parameter (double Object), method.
   */
  @Test
  void testLabeledDoubleStringDouble()
  {
    LeafLabeledDouble j = new LeafLabeledDouble("StringDouble", 1.0);
    assertThrows(IllegalArgumentException.class, () -> 
    {
      LeafLabeledDouble a = new LeafLabeledDouble(null, 1.0);

    });
    assertThrows(IllegalArgumentException.class, () -> 
    {
      LeafLabeledDouble a = new LeafLabeledDouble("", 1.0);

    });
  }

  /**
   * Tests the explicit constructor, two parameter, method.
   */
  @Test
  void testLabeledDoubleStringDouble1()
  {
    Double test = new Double(1);
    LeafLabeledDouble j = new LeafLabeledDouble("StringDouble1", test);

    assertThrows(IllegalArgumentException.class, () -> 
    {
      LeafLabeledDouble a = new LeafLabeledDouble(null, test);

    });
    assertThrows(IllegalArgumentException.class, () -> 
    {
      LeafLabeledDouble a = new LeafLabeledDouble("", test);

    });
  }

  /**
   * Tests the compareTo method.
   */
  @Test
  void testCompareTo()
  {
    LeafLabeledDouble test0 = new LeafLabeledDouble("Pat");
    LeafLabeledDouble test3 = new LeafLabeledDouble("ASi", 1.0);
    LeafLabeledDouble test1 = new LeafLabeledDouble("CS", 3.0);
    Double nullDouble = null;
    LeafLabeledDouble testNull = new LeafLabeledDouble("proo", null);
    // Testing
    assertEquals(1, test0.compareTo(testNull));
    assertEquals(-1, testNull.compareTo(test0));
    assertEquals(0, testNull.compareTo(testNull));
    assertEquals(-1, test0.compareTo(test1));
    assertEquals(1, test1.compareTo(test0));
    assertEquals(0, test1.compareTo(test1));
    assertEquals(-1, testNull.compareTo(test1));
    assertEquals(1, test1.compareTo(testNull));
    assertEquals(1, test1.compareTo(test3));
    assertEquals(1, test3.compareTo(testNull));
    assertEquals(-1, testNull.compareTo(test3));
  }

  /**
   * Tests the getLabel method.
   */
  @Test
  void testGetLabel()
  {
    String label = "Label";
    LeafLabeledDouble test1 = new LeafLabeledDouble(label, 5.0);
    assertEquals(label, test1.getLabel());
  }

  /**
   * Tests the toString boolean method.
   */
  @Test
  void testToStringBoolean()
  {
    LeafLabeledDouble test1 = new LeafLabeledDouble("gettingValue", 2.0);
    assertEquals(2.0, test1.getValue());
  }

  /**
   * Tests the toString method.
   */
  @Test
  void testToString()
  {
    
    LeafLabeledDouble test1 = new LeafLabeledDouble("Three", 3.0);
    LeafLabeledDouble test4 = new LeafLabeledDouble("Four", 4.0);
    LeafLabeledDouble test2 = new LeafLabeledDouble("ErrorTest1", null);
    LeafLabeledDouble test3 = new LeafLabeledDouble("ErrorTest2", Double.NaN);
    assertEquals("4.000000", test4.toString(false));
    assertEquals("Three: 3.000000", test1.toString(true));
    assertEquals("ErrorTest1: N/A", test2.toString(true));
    assertEquals("ErrorTest2: N/A", test3.toString(true));
    assertEquals(na, test2.toString(false));
    assertEquals(na, test3.toString(false));
  }

  /**
   * Tests the terse toString method.
   */
  @Test
  void testToStringActual()
  {
    LeafLabeledDouble test1 = new LeafLabeledDouble("Pro", 2.0);
    LeafLabeledDouble nullTest = new LeafLabeledDouble("Pro", null);
    LeafLabeledDouble nanTest = new LeafLabeledDouble("ErrorTest2", Double.NaN);
    assertEquals("2.000000", test1.toString());
    assertEquals(na, nullTest.toString());
    assertEquals(na, nanTest.toString());
  }

}
