package com.ciet.challenge.batchprocessing.infra.reader;

public interface IFileReaderAbstractFactory<R> {
  R createCsvFileReader();
}
