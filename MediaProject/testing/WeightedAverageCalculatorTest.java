package testing;
import math.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

/**
 * WeightedAverageCalculator Testing class.
 * 
 * This work complies with the JMU Honor Code.
 * 
 * @author Patrick DeBoy
 * @version H1
 */
class WeightedAverageCalculatorTest
{

  /**
   * Simply tests the constructor.
   */
  @Test
  void testWeightedAverageCalculator()
  {
    WeightedAverageCalculator wac = new WeightedAverageCalculator();
  }

  @Test
  void testWeightedAverageCalculatorMapOfStringDouble()
  {
    Map<String, Double> weights = new HashMap<String, Double>();
    WeightedAverageCalculator wac = new WeightedAverageCalculator(weights);
  }

  /**
   * Tests the calculate method.
   * 
   * @throws IllegalArgumentException
   * @throws SizeException
   */
  @Test
  void testCalculate() throws IllegalArgumentException, SizeException
  {
    String cs149 = "CS149";
    String math = "MATH";
    String cs159 = "CS159";
    String cs227 = "CS227";
    String resultLabel = "Pat";
    Map<String, Double> weights = new HashMap<String, Double>();
    weights.put(cs149, 25.0);
    weights.put(math, 25.0);
    weights.put(cs227, 25.0);
    weights.put(cs159, 25.0);
    List<LabeledDouble> data = new ArrayList<LabeledDouble>();
    LeafLabeledDouble temp = new LeafLabeledDouble(cs149, 100.0);
    LeafLabeledDouble temp1 = new LeafLabeledDouble(cs159, 90.0);
    LeafLabeledDouble temp2 = new LeafLabeledDouble(cs227, 90.0);
    LeafLabeledDouble temp3 = new LeafLabeledDouble(math, 100);
    data.add(temp);
    data.add(temp1);
    data.add(temp2);
    data.add(temp3);
    WeightedAverageCalculator wac = new WeightedAverageCalculator(weights);
    assertEquals(95.0, wac.calculate(resultLabel, data).getValue());
    assertThrows(SizeException.class, () -> 
    {
      wac.calculate(resultLabel, null);
    });
    // Testing for denom = 0
    weights.clear();
    weights.put(cs149, 0.0);
    weights.put(math, 0.0);
    weights.put(cs227, 0.0);
    weights.put(cs159, 0.0);
    LeafLabeledDouble missingTest = new LeafLabeledDouble("missing", null);
    assertEquals(missingTest.getLabel(), wac.calculate("missing", data).getLabel());
    assertEquals(missingTest.getValue(), wac.calculate(resultLabel, data).getValue());
    
    
  }
  
  /**
   * Tests missing Value.
   * @throws IllegalArgumentException
   * @throws SizeException
   */
  @Test
  void testMissing() throws IllegalArgumentException, SizeException {
    String missing = "MISS";

    LeafLabeledDouble tempMissing = new LeafLabeledDouble(missing, null);
    
    Double m = 0.0;
    Numerics.doubleValueOf(m);
    String cs149 = "CS149";
    String math = "MATH";
    String cs159 = "CS159";
    String cs227 = "CS227";
    String resultLabel = "Pat";
    Map<String, Double> weights = new HashMap<String, Double>();
    weights.put(cs149, 25.0);
    weights.put(math, 25.0);
    weights.put(cs227, 25.0);
    weights.put(cs159, 25.0);
    weights.put(missing, 0.0);
    List<LabeledDouble> data = new ArrayList<LabeledDouble>();
    LeafLabeledDouble temp = new LeafLabeledDouble(cs149, 100.0);
    LeafLabeledDouble temp1 = new LeafLabeledDouble(cs159, 90.0);
    LeafLabeledDouble temp2 = new LeafLabeledDouble(cs227, 90.0);
    LeafLabeledDouble temp3 = new LeafLabeledDouble(math, 100);
    data.add(temp);
    data.add(temp1);
    data.add(temp2);
    data.add(temp3);
    data.add(tempMissing);
    WeightedAverageCalculator wac = new WeightedAverageCalculator(weights);
    assertEquals(95.0, wac.calculate(resultLabel, data).getValue());
  }
  /**
   * Tests the performIntermediateCalculations.
   * 
   * @throws SizeException
   */
  @Test
  void testPerformIntermediateCalculations() throws SizeException
  {
    String mus = "MUS200";
    String math = "MATH100";
    String math2 = "MATH235";
    String art = "ART100";
    List<LabeledDouble> data = new ArrayList<LabeledDouble>();
    LeafLabeledDouble temp = new LeafLabeledDouble(mus, 100.0);
    LeafLabeledDouble temp1 = new LeafLabeledDouble(math, 90.0);
    LeafLabeledDouble temp2 = new LeafLabeledDouble(math2, 90.0);
    LeafLabeledDouble temp3 = new LeafLabeledDouble(art, 100);
    LeafLabeledDouble temp4Null = new LeafLabeledDouble(art, null);
    data.add(temp);
    data.add(temp1);
    data.add(temp2);
    data.add(temp3);
    data.add(temp4Null);
    Map<String, Double> weights = new HashMap<String, Double>();
    weights.put(mus, 25.0);
    weights.put(math, 25.0);
    weights.put(math2, 25.0);
    weights.put(art, 25.0);
    WeightedAverageCalculator wac = new WeightedAverageCalculator(null);
    assertEquals(95.0, wac.calculate("check", data).getValue());
    weights.clear();
    data.remove(temp);
    data.remove(temp4Null);
    data.add(new LeafLabeledDouble(mus, 100));
    weights.put(mus, null);
    weights.put(math, 25.0);
    weights.put(math2, 25.0);
    weights.put(art, 0.0);
    WeightedAverageCalculator wac2 = new WeightedAverageCalculator(weights);
    assertEquals(90.0, wac2.calculate("check", data).getValue());
    
  }

}
