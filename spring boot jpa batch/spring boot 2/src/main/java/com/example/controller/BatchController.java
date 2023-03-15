package com.example.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BatchController {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;


    @RequestMapping(value="/batch/{id}", method = RequestMethod.POST)
    public String runBatch(@PathVariable("id") String id) throws Exception {
        String status="";
        if("enable".equals(id)){
            JobParameters params = new JobParametersBuilder().addString("JobID", String.valueOf(System.currentTimeMillis()))
                    .toJobParameters();
            jobLauncher.run(job, params);
            status="Success";
        }
        return status;
    }
}
