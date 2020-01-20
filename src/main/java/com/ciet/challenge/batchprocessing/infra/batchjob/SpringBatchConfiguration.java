package com.ciet.challenge.batchprocessing.infra.batchjob;

import com.ciet.challenge.batchprocessing.core.dataminer.DataMinerFacade;
import com.ciet.challenge.batchprocessing.shared.dto.InputNumberDto;
import com.ciet.challenge.batchprocessing.shared.dto.OutputNumberDto;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
class SpringBatchConfiguration {

  @Bean
  Job job(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory,
          DataMinerFacade dataMinerFacade) {
    Step mainStep =
        stepBuilderFactory.get("NumberDataMiner")
            .<InputNumberDto, OutputNumberDto>chunk(100)
            .reader(dataMinerFacade)
            .processor(dataMinerFacade)
            .writer(dataMinerFacade).build();
    return jobBuilderFactory.get("batch-processing").start(mainStep).build();
  }
  

}
