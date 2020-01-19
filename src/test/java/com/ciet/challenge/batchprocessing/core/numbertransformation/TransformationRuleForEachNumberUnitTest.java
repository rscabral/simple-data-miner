package com.ciet.challenge.batchprocessing.core.numbertransformation;

import org.junit.Assert;
import org.junit.Test;

public class TransformationRuleForEachNumberUnitTest {

  private TransformationRuleForEachNumberService
      transformationRuleForEachNumberService =
      new TransformationRuleForEachNumberService();

  @Test
  public void given5266ShouldReturn5266EVEN309And13() {
    Long inputNumber = 5266L;
    String expectedOutput = "5266,PAR,309,13";
    String outputValue = transformationRuleForEachNumberService
        .transformParsedData(inputNumber);

    Assert.assertEquals(expectedOutput, outputValue);
  }

  @Test
  public void given289ShouldReturn289IMPAR170() {
    Long inputNumber = 289L;
    String expectedOutput = "289,IMPAR,17,0";
    String outputValue = transformationRuleForEachNumberService
        .transformParsedData(inputNumber);

    Assert.assertEquals(expectedOutput, outputValue);
  }
}
