package com.fr.ojt.batch.configuration;

import com.fr.ojt.batch.steps.FirstStep;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class JobConfiguration {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    FirstStep firstStep;

    @Bean
    public Job dailyReportJob() {
        return jobBuilderFactory
                .get("dailyReportJob")
                .start(firstStep.build())
                .build();
    }
}