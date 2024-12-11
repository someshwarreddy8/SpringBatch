package com.infy.listner;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.annotation.AfterJob;
import org.springframework.batch.core.annotation.BeforeJob;
import org.springframework.stereotype.Component;

@Component
public class MyJobAnnotationListener {

    @BeforeJob
    public void beforeJob(JobExecution jobExecution) {
        // Custom logic before the job starts
        System.out.println("Job is about to start: " + jobExecution.getJobInstance().getJobName());
    }

    @AfterJob
    public void afterJob(JobExecution jobExecution) {
        // Custom logic after the job finishes
        if (jobExecution.getStatus().isUnsuccessful()) {
            System.out.println("Job failed: " + jobExecution.getJobInstance().getJobName());
        } else {
            System.out.println("Job completed successfully: " + jobExecution.getJobInstance().getJobName());
        }
    }
}
