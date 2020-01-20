package com.ciet.challenge.batchprocessing.infra.reader;

import com.ciet.challenge.batchprocessing.shared.dto.InputNumberDto;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

class CsvFileReader extends AbstractFileReader<File, InputNumberDto> {
  @Override
  public File openFile(String path) throws IOException {
    Resource resource = new ClassPathResource(path);

    InputStream input = resource.getInputStream();

    return resource.getFile();
  }

  @Override
  public List<InputNumberDto> extractData(File file) throws FileNotFoundException {
    List<InputNumberDto> inputNumberDtoList = new LinkedList<>();
    Scanner scanner = new Scanner(file);
    scanner.next();
    while (scanner.hasNext()) {
      InputNumberDto inputNumberDto = new InputNumberDto(scanner.nextLong());
      inputNumberDtoList.add(inputNumberDto);
    }
    return inputNumberDtoList;
  }
}
