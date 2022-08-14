package testing;
import math.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * ThresholdFilter testing class.
 * 
 * This work complies with the JMU Honor Code.
 * 
 * @author Patrick DeBoy
 * @version H1
 */
class ThresholdFilterTest
{
  /**
   * Simple constructor test.
   */
  @Test
  void testThresholdFilter()
  {
    ThresholdFilter temp = new ThresholdFilter(5.0, 1, 0);
  }

  /**
   * Tests the apply method for ThresholdFilter.
   * @throws SizeException
   */
  @Test
  void testApply() throws SizeException
  {
    ThresholdFilter temp = new ThresholdFilter(92.0, 1, 0);
    ThresholdFilter tempAll = new ThresholdFilter(90.0, 1, 0);
    ThresholdFilter tempData = new ThresholdFilter(92.0, -1);
    List<LabeledDouble> data = new ArrayList<LabeledDouble>();
    LeafLabeledDouble temp0 = new LeafLabeledDouble("CS149", 100.0);
    LeafLabeledDouble temp1 = new LeafLabeledDouble("CS159", 90.0);
    LeafLabeledDouble temp2 = new LeafLabeledDouble("CS227", 90.0);
    LeafLabeledDouble temp3 = new LeafLabeledDouble("MATH", 100);
    List<LeafLabeledDouble> dataNew = new ArrayList<LeafLabeledDouble>();
    data.add(temp0);
    data.add(temp1);
    data.add(temp2);
    data.add(temp3);
    dataNew.add(temp0);
    dataNew.add(temp3);
    List<LabeledDouble> dataLess = new ArrayList<LabeledDouble>();
    dataLess.add(temp1);
    dataLess.add(temp2);
    assertThrows(SizeException.class, () -> 
    {
      temp.apply(null);
    });
    assertEquals(dataNew, temp.apply(data));
    assertEquals(data, tempAll.apply(data));
    assertEquals(dataLess, tempData.apply(data));  
    List<LabeledDouble> dataClear = new ArrayList<LabeledDouble>();
    ThresholdFilter tempNull = new ThresholdFilter(92.0, null);
    assertEquals(dataClear, tempNull.apply(data));
  }
}
