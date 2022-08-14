package grading;

import java.io.*;
import math.*;

/**
 * A utility class for reading .trn files.
 * 
 * @author  Prof. David Bernstein, James Madison University
 * @version H5
 */
public class InputUtilities 
{
  private static final String NA  = "N/A";
  private static final String TAB = "\t";
  
  /**
   * Construct a LeafLabeledDouble from a tab-delimited String representation.
   *
   * @param line The String representation
   * @return The result
   */
  private static LeafLabeledDouble parseLine(final String line)
  {
    String[] fields = line.split(TAB);
    
    Double value;
    if (fields[1].equals(NA)) 
    {
      value = null;
    }
    else
    {
      LetterGrade letter = LetterGrade.fromCode(fields[1]);
      value = letter.getValue();
    }
    return new LeafLabeledDouble(fields[0], value);
  }
  
  /**
   * Read a grade history from a .trn file.
   * 
   * @param resultLabel The label to use for the returned object
   * @param in  The BufferedReader to read from
   * @param filter The Filter to use for the returned object
   * @param calculator The Calculator to use for the returned object
   * @return The grade history
   * @throws IOException if there is an I/O problem
   */
  public static CompositeLabeledDouble readGradeHistory(final String resultLabel, 
      final BufferedReader in, final Filter filter, final Calculator calculator) 
          throws IOException
  {
    CompositeLabeledDouble result = new CompositeLabeledDouble(resultLabel, filter, calculator);

    String line;
    while ((line = in.readLine()) != null)
    {
      LabeledDouble element = parseLine(line);
      result.add(element);
    }
    return result;
  }

  /**
   * Construct a cohort from the information in an array of .trn files.
   * 
   * If a BufferedReader is null it is skipped.
   * 
   * @param resultLabel  The label to use to identify the cohort
   * @param in The BufferedReaders to use
   * @param filter The Filter to use with each grade history
   * @param calculator The Calculator to use with each grade history
   * @return A cohort containing the information in the files
   * @throws IOException if there is an I/O problem
   */
  public static CompositeLabeledDouble readCohort(final String resultLabel, 
      final BufferedReader[] in, final Filter filter, final Calculator calculator) 
          throws IOException
  {
    CompositeLabeledDouble result = new CompositeLabeledDouble(resultLabel,
        null, new WeightedAverageCalculator(null));
    for (int i=0; i<in.length; i++)
    {
      if (in[i] != null)
      {
        CompositeLabeledDouble history = readGradeHistory("GPA", in[i], filter, calculator);
        result.add(history);
      }
    }
    
    return result;
  }
}
