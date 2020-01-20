package com.ciet.challenge.batchprocessing.infra.reader;

import org.springframework.stereotype.Component;

@Component
public class FileReaderAbstractFactory implements IFileReaderAbstractFactory<AbstractFileReader> {

  @Override
  public AbstractFileReader createCsvFileReader() {
    return new CsvFileReader();
  }


  // JsonFileReader createJsonFileReader
  // PdfFileReader createPdfFileReader
}
