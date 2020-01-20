package com.ciet.challenge.batchprocessing.infra.reader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public abstract class AbstractFileReader<I, O> {

  public List<O> extractDataFromFile(String path) throws IOException {
    I file = openFile(path);
    return extractData(file);
  }

  public abstract I openFile(String path) throws IOException;

  public abstract List<O> extractData(I file) throws FileNotFoundException;
}
