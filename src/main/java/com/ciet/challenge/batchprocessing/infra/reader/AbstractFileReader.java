package com.ciet.challenge.batchprocessing.infra.reader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public abstract class AbstractFileReader<I, O> {

  public List<O> extractDataListFromFile(String path) throws IOException {
    I file = openFile(path);
    return extractDataList(file);
  }

  public O extractDataFromFile(String path) throws IOException {
    I file = openFile(path);
    return extractData(file);
  }

  abstract I openFile(String path) throws IOException;

  abstract List<O> extractDataList(I file) throws FileNotFoundException;

  abstract O extractData(I file) throws FileNotFoundException;
}
