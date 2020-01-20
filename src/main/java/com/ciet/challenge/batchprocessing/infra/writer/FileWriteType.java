package com.ciet.challenge.batchprocessing.infra.writer;

import java.util.function.Function;

public enum FileWriteType {
  CSV((factory) -> (IFileWriter) factory.createCsvFileWriter());

  private Function<IFileWriterAbstractFactory, IFileWriter> func;

  FileWriteType(Function<IFileWriterAbstractFactory, IFileWriter> func) {
    this.func = func;
  }

  public IFileWriter createFileReader(IFileWriterAbstractFactory fileWriterAbstractFactory) {
    return func.apply(fileWriterAbstractFactory);
  }
}
