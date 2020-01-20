package com.ciet.challenge.batchprocessing.shared.utils;

import java.io.File;

public class FilesCleanUpUtils {

  public static void cleanUpFiles(String outputFilePath) {
    File dir = new File(outputFilePath);
    for (File file : dir.listFiles()) {
      file.delete();
    }
  }
}
