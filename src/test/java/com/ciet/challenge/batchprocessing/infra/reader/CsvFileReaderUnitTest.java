package com.ciet.challenge.batchprocessing.infra.reader;

import com.ciet.challenge.batchprocessing.shared.dto.InputNumberDto;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class CsvFileReaderUnitTest {
  private CsvFileReader csvFileReader = new CsvFileReader();
  private String filePath = "inputTest.csv";

  @Test
  public void givenInputFileShouldReturnInputNumberDtoList() throws IOException {
    int expectedSize = 1000;
    File file = csvFileReader.openFile(filePath);
    List<InputNumberDto> inputNumberDtoList = csvFileReader.extractDataList(file);

    Assert.assertTrue(inputNumberDtoList != null && !inputNumberDtoList.isEmpty());
    Assert.assertEquals(expectedSize, inputNumberDtoList.size());
  }

  @Test
  public void givenInputFileShouldReturnInputNumberDto() throws IOException {
    InputNumberDto firstData = new InputNumberDto(5266L);
    InputNumberDto secondData = new InputNumberDto(4718L);

    File file = csvFileReader.openFile(filePath);
    Assert.assertEquals(firstData, csvFileReader.extractData(file));
    Assert.assertEquals(secondData, csvFileReader.extractData(file));
  }
}
