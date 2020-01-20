package com.ciet.challenge.batchprocessing.infra.writer;

import org.springframework.stereotype.Component;

@Component
public class FileWriterAbstractFactory implements IFileWriterAbstractFactory<IFileWriter> {
  @Override
  public IFileWriter createCsvFileWriter() {
    return new CsvFileWriter();
  }

  // PdfFileReader createPdfFileWriter
}
