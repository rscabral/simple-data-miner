package com.ciet.challenge.batchprocessing.core.numbertransformation;

import com.ciet.challenge.batchprocessing.shared.dto.OutputNumberDto;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TransformationRuleForEachNumberUnitTest {

  private TransformationRuleForEachNumberService
      transformationRuleForEachNumberService =
      new TransformationRuleForEachNumberService();

  @Test
  public void given5266ShouldReturn5266EVEN309And13() {
    Long inputNumber = 5266L;
    OutputNumberDto expectedOutput = OutputNumberDto.builder()
        .setNumber(5266L)
        .setEvenOrOdd("PAR")
        .setIntResultOfDivision(309L)
        .setIntResultOfMod(13L)
        .build();

    OutputNumberDto outputValue = transformationRuleForEachNumberService
        .transformParsedData(inputNumber);

    Assert.assertEquals(expectedOutput, outputValue);
  }

  @Test
  public void given289ShouldReturn289IMPAR170() {
    Long inputNumber = 289L;
    OutputNumberDto expectedOutput = OutputNumberDto.builder()
        .setNumber(289L)
        .setEvenOrOdd("IMPAR")
        .setIntResultOfDivision(17L)
        .setIntResultOfMod(0L)
        .build();
    OutputNumberDto outputValue = transformationRuleForEachNumberService
        .transformParsedData(inputNumber);

    Assert.assertEquals(expectedOutput, outputValue);
  }
}
