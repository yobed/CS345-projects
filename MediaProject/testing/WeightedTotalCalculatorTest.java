package testing;
import math.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

/**
 * WeightedTotalCalculator Testing class.
 * 
 * This work complies with the JMU Honor Code.
 * 
 * @author Patrick DeBoy
 * @version H1
 */
class WeightedTotalCalculatorTest
{

  /**
   * Tests the calculate class.
   * @throws IllegalArgumentException
   * @throws SizeException
   */
  @Test
  void testCalculate() throws IllegalArgumentException, SizeException
  {
    String labeledResult = "Testing";
    String cs149 = "CS149";
    String math = "MATH";
    String cs159 = "CS159";
    String cs227 = "CS227";
    List<LabeledDouble> data = new ArrayList<LabeledDouble>();
    LeafLabeledDouble temp = new LeafLabeledDouble(cs149, 100.0);
    LeafLabeledDouble temp1 = new LeafLabeledDouble(cs159, 90.0);
    LeafLabeledDouble temp2 = new LeafLabeledDouble(cs227, 90.0);
    LeafLabeledDouble temp3 = new LeafLabeledDouble(math, 100);
    data.add(temp);
    data.add(temp1);
    data.add(temp2);
    data.add(temp3);
    Map<String, Double> weights = new HashMap<String, Double>();
    weights.put(cs149, 25.0);
    weights.put(cs159, 25.0);
    weights.put(cs227, 25.0);
    weights.put(math, 25.0);
    WeightedTotalCalculator wtc = new WeightedTotalCalculator(weights);
    assertEquals(9500.0, wtc.calculate(labeledResult, data).getValue());
    assertThrows(SizeException.class, () -> 
    {
      wtc.calculate(labeledResult, null);
    });
  }

  /**
   * Tests the constructor.
   */
  @Test
  void testWeightedTotalCalculator()
  {
    WeightedTotalCalculator wtc = new WeightedTotalCalculator();
  }

  /**
   * Tests the explicit constructor.
   */
  @Test
  void testWeightedTotalCalculatorMapOfStringDouble()
  {
    Map<String, Double> weights = new HashMap<String, Double>();
    WeightedAverageCalculator wtc = new WeightedAverageCalculator();
  }

}
