package com.ciet.challenge.batchprocessing.infra.reader;

import java.util.function.Function;

public enum FileReaderType {
  CSV((factory) -> (AbstractFileReader) factory.createCsvFileReader());


  private Function<IFileReaderAbstractFactory, AbstractFileReader> func;

  FileReaderType(Function<IFileReaderAbstractFactory, AbstractFileReader> func) {
    this.func = func;
  }

  public AbstractFileReader createFileReader(IFileReaderAbstractFactory fileReaderAbstractFactory) {
    return func.apply(fileReaderAbstractFactory);
  }
}
