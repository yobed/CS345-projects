package testing;
import grading.LetterGrade;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * LetterGrade Testing class.
 * 
 * This work complies with the JMU Honor Code.
 * 
 * @author Patrick DeBoy
 * @version H1
 */
class LetterGradeTest
{
  String a = "A";

  /**
   * Tests the FromCode method.
   */
  @Test
  void testFromCode()
  {
    assertEquals(LetterGrade.fromCode(a), LetterGrade.A);
    assertEquals(LetterGrade.fromCode("A-"), LetterGrade.AMINUS);
    assertEquals(LetterGrade.fromCode("B+"), LetterGrade.BPLUS);
    assertEquals(LetterGrade.fromCode("B"), LetterGrade.B);
    assertEquals(LetterGrade.fromCode("B-"), LetterGrade.BMINUS);
    assertEquals(LetterGrade.fromCode("C+"), LetterGrade.CPLUS);
    assertEquals(LetterGrade.fromCode("C"), LetterGrade.C);
    assertEquals(LetterGrade.fromCode("C-"), LetterGrade.CMINUS);
    assertEquals(LetterGrade.fromCode("D+"), LetterGrade.DPLUS);
    assertEquals(LetterGrade.fromCode("D"), LetterGrade.D);
    assertEquals(LetterGrade.fromCode("D-"), LetterGrade.DMINUS);
    assertEquals(LetterGrade.fromCode("F"), LetterGrade.F);
    assertEquals(LetterGrade.fromCode("1"), null);
  }

  /**
   * Tests the getValue method.
   */
  @Test
  void testGetValue()
  {
    assertEquals(LetterGrade.fromCode(a).getValue(), 4.0); 
  }

  /**
   * Tests the toString method.
   */
  @Test
  void testToString()
  {
    assertEquals(LetterGrade.fromCode(a).toString(), "A  (4.0)");
    
  }
  
  /**
   * Tests the GetLabel method.
   */
  @Test
  void testGetLabel()
  {
    assertEquals("A", LetterGrade.A.getLabel());
    
  }

}
