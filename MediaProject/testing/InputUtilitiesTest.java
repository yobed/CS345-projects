package testing;

import grading.*;
import math.*;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.*;

public class InputUtilitiesTest
{
  private BufferedReader createBufferedReader(String name)
  {
    InputStream is = getClass().getResourceAsStream(name);
    BufferedReader br = new BufferedReader(new InputStreamReader(is));

    return br;
  }

  @Test
  public void testReadGradeHistory() throws IOException, SizeException
  {
    InputUtilities a = new InputUtilities() {
    };
    String test = "Test";
    BufferedReader in = createBufferedReader("marge.trn");
    ThresholdFilter tempData = new ThresholdFilter(92.0, -1);

    CompositeLabeledDouble testMarge = new CompositeLabeledDouble(test, new ThresholdFilter(0, 1), new WeightedAverageCalculator());
    String cs149 = "CS149";
    String cs159 = "CS159";
    String cs227 = "CS227";
    String cs240 = "CS240";
    String cs261 = "CS261";
    String math235 = "MATH235";

    LeafLabeledDouble marge1 = new LeafLabeledDouble(cs149, 3.0);
    LeafLabeledDouble marge2 = new LeafLabeledDouble(cs159, null);
    LeafLabeledDouble temp3 = new LeafLabeledDouble(cs227, 4.0);
    LeafLabeledDouble temp4 = new LeafLabeledDouble(cs240, 4.0);
    LeafLabeledDouble temp5 = new LeafLabeledDouble(cs261, 4.0);
    LeafLabeledDouble marge3 = new LeafLabeledDouble(math235, 2.7);

    testMarge.add(marge1);
    testMarge.add(marge2);
    testMarge.add(marge3);

    assertEquals(testMarge.getValue(),
        InputUtilities.readGradeHistory(test, in, tempData, new WeightedAverageCalculator())
            .getValue());
  }


  @Test
  public void testReadCohortHistory() throws SizeException, IOException
  {
    String test = "Test2";
    BufferedReader in = createBufferedReader("marge.trn");
    BufferedReader in2 = createBufferedReader("homer.trn");
    ThresholdFilter tempData = new ThresholdFilter(92.0, -1);

    CompositeLabeledDouble testMarge = new CompositeLabeledDouble(test, new ThresholdFilter(0, 1, 0), new WeightedAverageCalculator());
    String cs149 = "CS149";
    String cs159 = "CS159";
    String cs227 = "CS227";
    String cs240 = "CS240";
    String cs261 = "CS261";
    String math235 = "MATH235";

    LeafLabeledDouble marge1 = new LeafLabeledDouble(cs149, 3.0);
    LeafLabeledDouble marge2 = new LeafLabeledDouble(cs159, null);
    LeafLabeledDouble homer1 = new LeafLabeledDouble(cs149, 0.0);
    LeafLabeledDouble homer2 = new LeafLabeledDouble(math235, 0.0);
    LeafLabeledDouble marge3 = new LeafLabeledDouble(math235, 2.7);

    CompositeLabeledDouble testHomer = new CompositeLabeledDouble(test, new ThresholdFilter(0, 1, 0), new WeightedAverageCalculator());
    testMarge.add(marge1);
    testMarge.add(marge2);
    testMarge.add(marge3);

    testHomer.add(homer1);
    testHomer.add(homer2);

    BufferedReader[] ins = new BufferedReader[2];
    ins[0] = in;
    ins[1] = in2;
    CompositeLabeledDouble newComp = new CompositeLabeledDouble(test, new ThresholdFilter(0, 1, 0), new WeightedAverageCalculator());
    newComp.add(testMarge);
    newComp.add(testHomer);
    assertEquals(1.425, newComp.getValue());
    assertEquals(newComp.getValue(), InputUtilities.readCohort(test, ins,
        new ThresholdFilter(50, 1, 0, -1), new WeightedAverageCalculator()).getValue());

  }
  
  @Test
  public void testNullParam() throws SizeException, IOException {
    String test = "Test2";
    BufferedReader in = createBufferedReader("marge.trn");
    BufferedReader in2 = createBufferedReader("homer.trn");
    ThresholdFilter tempData = new ThresholdFilter(92.0, -1);

    CompositeLabeledDouble testMarge = new CompositeLabeledDouble(test, new ThresholdFilter(0, 1, 0), new WeightedAverageCalculator());
    String cs149 = "CS149";
    String cs159 = "CS159";
    String cs227 = "CS227";
    String cs240 = "CS240";
    String cs261 = "CS261";
    String math235 = "MATH235";

    LeafLabeledDouble marge1 = new LeafLabeledDouble(cs149, 3.0);
    LeafLabeledDouble marge2 = new LeafLabeledDouble(cs159, null);
    LeafLabeledDouble homer1 = new LeafLabeledDouble(cs149, 0.0);
    LeafLabeledDouble homer2 = new LeafLabeledDouble(math235, 0.0);
    LeafLabeledDouble marge3 = new LeafLabeledDouble(math235, 2.7);

    CompositeLabeledDouble testHomer = new CompositeLabeledDouble(test, new ThresholdFilter(0, 1, 0), new WeightedAverageCalculator());
    testMarge.add(marge1);
    testMarge.add(marge2);
    testMarge.add(marge3);

    testHomer.add(homer1);
    testHomer.add(homer2);

    BufferedReader[] ins = new BufferedReader[3];
    ins[0] = in;
    ins[1] = null;
    ins[2] = in2;
    CompositeLabeledDouble newComp = new CompositeLabeledDouble(test, new ThresholdFilter(0, 1, 0), new WeightedAverageCalculator());
    newComp.add(testMarge);
    newComp.add(testHomer);
    assertEquals(1.425, newComp.getValue());
    assertEquals(newComp.getValue(), InputUtilities.readCohort(test, ins,
        new ThresholdFilter(50, 1, 0, -1), new WeightedAverageCalculator()).getValue());

  }
  

}
