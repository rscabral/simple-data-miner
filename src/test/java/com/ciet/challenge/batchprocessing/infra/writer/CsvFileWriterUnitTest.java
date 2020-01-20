package com.ciet.challenge.batchprocessing.infra.writer;

import com.ciet.challenge.batchprocessing.shared.dto.OutputNumberDto;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CsvFileWriterUnitTest {
  private CsvFileWriter csvFileWriter = new CsvFileWriter();
  private String outputFileNamePath = "outputCSV/outputTest.csv";
  private String outputFilePath = "outputCSV";

  @BeforeEach
  public void clean() {
    File dir = new File(outputFilePath);
    for (File file : dir.listFiles()) {
      file.delete();
    }
  }

  @Test
  public void givenInputNumberDtoListShouldCreateACsvFile() throws IOException {
    List<OutputNumberDto> outputNumberDtoList = new LinkedList<>();
    outputNumberDtoList.add(OutputNumberDto.builder().setNumber(289L).setEvenOrOdd(
        "IMPAR").setIntResultOfDivision(17L).setIntResultOfMod(0L).build());
    outputNumberDtoList.add(OutputNumberDto.builder().setNumber(5266L).setEvenOrOdd(
        "PAR").setIntResultOfDivision(309L).setIntResultOfMod(13L).build());

    csvFileWriter.write(outputFileNamePath, outputNumberDtoList);

    File file = new File(outputFilePath);

    Assert.assertNotNull(file.listFiles());
  }
}
