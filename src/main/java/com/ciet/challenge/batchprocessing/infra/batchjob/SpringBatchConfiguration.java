package com.ciet.challenge.batchprocessing.infra.batchjob;

import com.ciet.challenge.batchprocessing.shared.dto.InputNumberDto;
import com.ciet.challenge.batchprocessing.shared.dto.OutputNumberDto;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;

// @Configuration
// @EnableBatchProcessing
class SpringBatchConfiguration {

  // @Bean
  Job job(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory,
          ItemReader<InputNumberDto> numberDtoItemReader, ItemProcessor<InputNumberDto,
      OutputNumberDto> numberDtoItemProcessor, ItemWriter<OutputNumberDto> numberDtoItemWriter) {
    Step mainStep =
        stepBuilderFactory.get("NumberDataMiner")
            .<InputNumberDto, OutputNumberDto>chunk(100)
            .reader(numberDtoItemReader)
            .processor(numberDtoItemProcessor)
            .writer(numberDtoItemWriter).build();
    return jobBuilderFactory.get("batch-processing").start(mainStep).build();
  }
}
