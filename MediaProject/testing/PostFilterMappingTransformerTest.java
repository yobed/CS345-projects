package testing;
import math.*;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PostFilterMappingTransformerTest
{
  @BeforeEach
  public void createTestVar() {
    
  }
  @Test
  public void testPostFilterMapTransformer() throws SizeException {
    //create constructor
    String cs149 = "CS149";
    String math = "MATH";
    String cs159 = "CS159";
    String cs227 = "CS227";
    String resultLabel = "Pat";
    Map<String, Double> weights = new HashMap<String, Double>();
    weights.put(cs149, 2.0);
    weights.put(cs159, 3.0);
    weights.put(cs227, 3.0);
    PostFilterMappingTransformer test = new PostFilterMappingTransformer(new ThresholdFilter(50, 1), weights);
    
    // create data
    List<LabeledDouble> data = new ArrayList<LabeledDouble>();
    LeafLabeledDouble temp = new LeafLabeledDouble(cs149, 90.0);
    LeafLabeledDouble temp1 = new LeafLabeledDouble(cs159, 90.0);
    LeafLabeledDouble temp2 = new LeafLabeledDouble(cs227, 49.0);
    data.add(temp);
    data.add(temp1);
    data.add(temp2);
    List<LabeledDouble> result = new ArrayList<LabeledDouble>();
    result.add(new LeafLabeledDouble(cs149, 2.0));
    result.add(new LeafLabeledDouble(cs159, 3.0));
    
    
    
    assertEquals(result.get(0).getLabel(), test.apply(data).get(0).getLabel()); // filter didn't work - changed filter arrangement in constructor
    assertEquals(result.size(), test.apply(data).size()); // also checked if values were same
    // check if data size is still correct
    assertEquals(3, data.size());
    // misc
    
      // map = null
    PostFilterMappingTransformer testMapFilterNull = new PostFilterMappingTransformer(null, null);
    LabeledDouble na = new LeafLabeledDouble("a", null);
    List<LabeledDouble> nulls = new ArrayList<LabeledDouble>();
    assertEquals(na.getValue(), testMapFilterNull.apply(data).get(0).getValue());
    result.add(new LeafLabeledDouble(cs159, 3.0));
    assertEquals(3, testMapFilterNull.apply(data).size());
    

    

    
  }
  
  @Test
  public void testPostFilterSizeException() throws SizeException {
    PostFilterMappingTransformer test = new PostFilterMappingTransformer(new ThresholdFilter(50, 1), null);
    List<LabeledDouble> dataNull = null;
    assertThrows(SizeException.class, () -> 
    {
      test.apply(dataNull);
    });
    List<LabeledDouble> dataEmpty = new ArrayList<LabeledDouble>();
    assertThrows(SizeException.class, () -> 
    {
      test.apply(dataEmpty); // null is not first checked
    });
    String cs149 = "CS149";
    String math = "MATH";
    String cs159 = "CS159";
    String cs227 = "CS227";
    String resultLabel = "Pat";
    Map<String, Double> weights = new HashMap<String, Double>();
    weights.put(cs149, 2.0);
    weights.put(cs159, 3.0);
    weights.put(cs227, 3.0);
    List<LabeledDouble> data = new ArrayList<LabeledDouble>();
    LeafLabeledDouble temp = new LeafLabeledDouble(cs149, 90.0);
    LeafLabeledDouble temp1 = new LeafLabeledDouble(cs159, 90.0);
    LeafLabeledDouble temp2 = new LeafLabeledDouble(cs227, 49.0);
    data.add(temp);
    data.add(temp1);
    data.add(temp2);
    // list filtered all out return size exception
    PostFilterMappingTransformer filterAll = new PostFilterMappingTransformer(new ThresholdFilter(0, -1), weights);
    assertThrows(SizeException.class, () -> 
    {
      filterAll.apply(data); // was checking data instead of result
    });
  }
  
  @Test
  public void testOther() throws SizeException {
    //test some map keys
    Map<String, Double> weights = new HashMap<String, Double>();
    weights.put("NotInHere", 2.0);
    weights.put("InHere", 3.0);
    weights.put("InHere2", 4.0);
    List<LabeledDouble> data = new ArrayList<LabeledDouble>();
    LeafLabeledDouble temp = new LeafLabeledDouble("check", 90.0);
    LeafLabeledDouble temp1 = new LeafLabeledDouble("InHere", 90.0);
    LeafLabeledDouble temp2 = new LeafLabeledDouble("InHere2", 49.0);
    data.add(temp);
    data.add(temp1);
    data.add(temp2);
    PostFilterMappingTransformer test = new PostFilterMappingTransformer(null, weights);
    LabeledDouble na = new LeafLabeledDouble("a", null);
    assertEquals(na.getValue(), test.apply(data).get(0).getValue());
    assertEquals(3, test.apply(data).size());
  }
  
}
