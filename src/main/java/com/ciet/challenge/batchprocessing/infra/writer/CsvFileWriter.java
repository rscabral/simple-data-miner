package com.ciet.challenge.batchprocessing.infra.writer;

import com.ciet.challenge.batchprocessing.shared.dto.OutputNumberDto;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

class CsvFileWriter implements IFileWriter<OutputNumberDto> {
  @Override
  public void write(String outputFilePath, List<OutputNumberDto> outputFile) throws IOException {
    FileWriter fileWriter = new FileWriter(outputFilePath, true);
    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    PrintWriter printWriter = new PrintWriter(bufferedWriter);

    printWriter.println("Number,Even/Odd,MultipleOf17,Mod17");
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
}
