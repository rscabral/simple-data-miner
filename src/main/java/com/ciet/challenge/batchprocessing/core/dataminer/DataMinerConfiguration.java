package com.ciet.challenge.batchprocessing.core.dataminer;

import com.ciet.challenge.batchprocessing.infra.reader.FileReaderType;
import com.ciet.challenge.batchprocessing.infra.reader.IFileReaderAbstractFactory;
import com.ciet.challenge.batchprocessing.infra.writer.FileWriteType;
import com.ciet.challenge.batchprocessing.infra.writer.IFileWriterAbstractFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
class DataMinerConfiguration {

  @Bean
  @Primary
  DataMinerFacade dataMinerFacade(IFileReaderAbstractFactory fileReaderFactory,
                                  IFileWriterAbstractFactory fileWriterFactory) {
    return new DataMinerFacade(fileReaderFactory, fileWriterFactory, FileReaderType.CSV,
        FileWriteType.CSV);
  }

  // @Bean(nem="pdfDataMiner)
  // @Bean(nem="xmlDataMiner)

}
