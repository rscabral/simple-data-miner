package com.ciet.challenge.batchprocessing.core.dataminer;

import com.ciet.challenge.batchprocessing.shared.dto.InputNumberDto;
import com.ciet.challenge.batchprocessing.shared.dto.OutputNumberDto;
import com.ciet.challenge.batchprocessing.shared.utils.FilesCleanUpUtils;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DataMinerCsvIntegrationTest {
  @Autowired
  private DataMinerFacade facade;
  private String outputFilePath = "outputCSV";

  @BeforeEach
  public void clean() {
    FilesCleanUpUtils.cleanUpFiles(outputFilePath);
  }

  @Test
  public void shouldReadACsvFile() throws Exception {
    InputNumberDto firstData = new InputNumberDto(5266L);
    InputNumberDto secondData = new InputNumberDto(4718L);

    Assert.assertEquals(firstData, facade.read());
    Assert.assertEquals(secondData, facade.read());
  }

  @Test
  public void givenAnInputNumberDtoShouldReturnAnOutputNumberDto() throws Exception {
    Long currentNumber = 289L;
    InputNumberDto givenInputNumberDto = new InputNumberDto(currentNumber);
    OutputNumberDto resultDto = OutputNumberDto.builder().setNumber(currentNumber).setEvenOrOdd(
        "IMPAR").setIntResultOfDivision(17L).setIntResultOfMod(0L).build();

    Assert.assertEquals(resultDto, facade.process(givenInputNumberDto));
  }

  @Test
  public void givenAnOutputNumberDtoListShouldWriteACsvFile() throws Exception {
    List<OutputNumberDto> outputNumberDtoList = new LinkedList<>();
    outputNumberDtoList.add(OutputNumberDto.builder().setNumber(289L).setEvenOrOdd(
        "IMPAR").setIntResultOfDivision(17L).setIntResultOfMod(0L).build());
    outputNumberDtoList.add(OutputNumberDto.builder().setNumber(5266L).setEvenOrOdd(
        "PAR").setIntResultOfDivision(309L).setIntResultOfMod(13L).build());

    facade.write(outputNumberDtoList);

    File file = new File(outputFilePath);

    Assert.assertNotNull(file.listFiles());
  }

}
