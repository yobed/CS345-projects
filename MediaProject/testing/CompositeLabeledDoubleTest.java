package testing;
import math.*;


import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;
import org.junit.jupiter.api.Test;


public class CompositeLabeledDoubleTest
{

  @Test
  public void testConstructor() throws SizeException {
    CompositeLabeledDouble a = new CompositeLabeledDouble("Result", new ThresholdFilter(50, 1), new WeightedAverageCalculator());
    String cs149 = "CS149";
    String math = "MATH";
    String cs159 = "CS159";
    String cs227 = "CS227";
    String resultLabel = "Pat";
    // end
    List<LabeledDouble> data = new ArrayList<LabeledDouble>();
    LeafLabeledDouble temp0 = new LeafLabeledDouble(cs149, 100.0);
    LeafLabeledDouble temp1 = new LeafLabeledDouble(math, 25.0);
    LeafLabeledDouble temp2 = new LeafLabeledDouble(cs159, 25.0);
    LeafLabeledDouble temp3 = new LeafLabeledDouble(cs227, 90);
    a.add(temp0);
    a.add(temp1);
    a.add(temp2);
    a.add(temp3);
    data.add(temp0);
    data.add(temp3);
    CompositeLabeledDouble a2 = new CompositeLabeledDouble("Result", null, null);
    assertEquals(data.size(), a.filter().size());
    Double temp = 95.0;
    assertEquals(temp, a.getValue());
    data.clear();
    a2.add(temp0);
    a2.add(temp1);
    a2.add(temp2);
    a2.add(temp3);
    data.add(temp0);
    
    data.add(temp1);
    data.add(temp2);
    data.add(temp3);
    System.out.print(a2.compareTo(a));
    assertEquals(data, a2.filter());
    assertEquals(null, a2.getValue());
    
    
  }
}
