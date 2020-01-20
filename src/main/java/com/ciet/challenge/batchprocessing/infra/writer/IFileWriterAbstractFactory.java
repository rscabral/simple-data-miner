package com.ciet.challenge.batchprocessing.infra.writer;

public interface IFileWriterAbstractFactory<W> {
  W createCsvFileWriter();
}
