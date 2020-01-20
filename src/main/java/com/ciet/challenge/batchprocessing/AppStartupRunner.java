package com.ciet.challenge.batchprocessing;

import com.ciet.challenge.batchprocessing.shared.utils.FilesCleanUpUtils;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class AppStartupRunner implements ApplicationRunner {
  @Autowired
  private JobLauncher jobLauncher;

  @Autowired
  private Job job;

  @Value("${output.folder.path}")
  private String outputFilePath;

  @PostConstruct
  public void cleanUp() {
    FilesCleanUpUtils.cleanUpFiles(outputFilePath);
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    Map<String, JobParameter> jobParameterMap = new HashMap<>();
    jobParameterMap.put("time", new JobParameter(System.currentTimeMillis()));
    JobParameters jobParameters = new JobParameters(jobParameterMap);
    JobExecution jobExecution = jobLauncher.run(job, jobParameters);

    logJobExecutionStatus(jobExecution.getStatus());
    while (jobExecution.isRunning()) {
      System.out.println("...");
    }
    logJobExecutionStatus(jobExecution.getStatus());
  }

  private void logJobExecutionStatus(BatchStatus status) {
    System.out.println("JobExecution: " + status);
  }
}
