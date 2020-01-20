package com.ciet.challenge.batchprocessing.shared.utils;

import java.io.File;

public class FolderCreatorUtils {
  public static boolean createFolder(String path) {
    File file = new File(path);
    if (file != null && file.isDirectory()) {
      return true;
    }
    return file.mkdir();
  }
}
