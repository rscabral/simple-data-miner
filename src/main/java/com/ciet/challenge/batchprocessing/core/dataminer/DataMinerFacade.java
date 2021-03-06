package com.ciet.challenge.batchprocessing.core.dataminer;

import com.ciet.challenge.batchprocessing.core.numbertransformation.NumberTransformationFacade;
import com.ciet.challenge.batchprocessing.infra.reader.AbstractFileReader;
import com.ciet.challenge.batchprocessing.infra.reader.FileReaderType;
import com.ciet.challenge.batchprocessing.infra.reader.IFileReaderAbstractFactory;
import com.ciet.challenge.batchprocessing.infra.writer.FileWriteType;
import com.ciet.challenge.batchprocessing.infra.writer.IFileWriter;
import com.ciet.challenge.batchprocessing.infra.writer.IFileWriterAbstractFactory;
import com.ciet.challenge.batchprocessing.shared.dto.InputNumberDto;
import com.ciet.challenge.batchprocessing.shared.dto.OutputNumberDto;
import java.util.List;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class DataMinerFacade implements ItemReader<InputNumberDto>, ItemProcessor<InputNumberDto,
    OutputNumberDto>, ItemWriter<OutputNumberDto> {

  private NumberTransformationFacade numberTransformationFacade;

  private IFileWriter fileWriter;

  private AbstractFileReader fileReader;

  private String inputFileName = "input.csv";
  private String outputFileNamePath = "outputCSV/output.csv";

  public DataMinerFacade(
      NumberTransformationFacade numberTransformationFacade,
      IFileReaderAbstractFactory fileReaderFactory,
      IFileWriterAbstractFactory fileWriterFactory,
      FileReaderType readerType,
      FileWriteType writeType) {
    this.numberTransformationFacade = numberTransformationFacade;
    this.fileReader = readerType.createFileReader(fileReaderFactory);
    this.fileWriter = writeType.createFileReader(fileWriterFactory);
  }

  @Override
  public InputNumberDto read()
      throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
    InputNumberDto inputNumberDto = (InputNumberDto) fileReader.extractDataFromFile(inputFileName);
    return inputNumberDto;
  }

  @Override
  public OutputNumberDto process(InputNumberDto inputNumberDto) throws Exception {
    OutputNumberDto result = numberTransformationFacade.transformData(inputNumberDto.getNumber());
    return result;
  }

  @Override
  public void write(List<? extends OutputNumberDto> list) throws Exception {
    fileWriter.write(outputFileNamePath, list);
  }
}
