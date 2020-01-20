package com.ciet.challenge.batchprocessing.infra.writer;

import java.io.IOException;
import java.util.List;

public interface IFileWriter<O> {

  void write(String outputFilePath, List<O> outputFile) throws IOException;

}
