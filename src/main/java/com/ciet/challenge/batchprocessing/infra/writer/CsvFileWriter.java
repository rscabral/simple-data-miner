package com.ciet.challenge.batchprocessing.infra.writer;

import com.ciet.challenge.batchprocessing.shared.dto.OutputNumberDto;
import com.ciet.challenge.batchprocessing.shared.utils.CsvNumberMinerHeader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

class CsvFileWriter implements IFileWriter<OutputNumberDto> {
  @Override
  public void write(String outputFilePath, List<OutputNumberDto> outputFile) throws IOException {
    boolean isHeaderAlreadyPrinted = isHeaderAlreadyPrinted(outputFilePath);
    FileWriter fileWriter = new FileWriter(outputFilePath, true);
    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    PrintWriter printWriter = new PrintWriter(bufferedWriter);

    if (!isHeaderAlreadyPrinted) {
      printWriter.println(CsvNumberMinerHeader.getHeader());
    }
    for (OutputNumberDto outputNumberDto : outputFile) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(outputNumberDto.getNumber()).append(",")
          .append(outputNumberDto.getEvenOrOdd()).append(",")
          .append(outputNumberDto.getIntResultOfDivision()).append(",")
          .append(outputNumberDto.getIntResultOfMod());
      printWriter.println(stringBuilder.toString());
    }
    printWriter.flush();
    printWriter.close();


  }

  private boolean isHeaderAlreadyPrinted(String outputFilePath) {
   /* String path = outputFilePath.subSequence(0, outputFilePath.lastIndexOf("/")).toString();
    String fileName =
        outputFilePath.subSequence(outputFilePath.lastIndexOf("/") + 1,
            (outputFilePath.length() - 1)).toString();
*/
    File file = new File(outputFilePath);

    return file != null && file.isFile();
  }
}
