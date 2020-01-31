package com.fr.ojt.batch.configuration;

import com.fr.ojt.batch.itemReader.ListReader;
import com.fr.ojt.batch.listener.ChunkListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@EnableBatchProcessing
public class JobConfiguration {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;


   /* @Bean
    public ItemReader<String> reader(){
        return new ListItemReader<>(Arrays.asList("one","two","three","four","five","six","seven"));
    }*/
    @Bean
    public ListReader listReader() {
        return new ListReader(Arrays.asList("one", "two", "three", "four", "five", "six", "seven","eight"));
    }

    @Bean
    public ItemWriter<String> writer() {
        return items -> {
            items
                    .stream()
                    .forEach(item -> System.out.println(item));
        };
    }

    @Bean
    public Step step() {
        return stepBuilderFactory.get("step")
                .<String, String>chunk(2)
                .faultTolerant()
                .listener(new ChunkListener())
                .reader(listReader())
                .writer(writer())
                .build();
    }

    @Bean
    public Job dailyReportJob() {
        return jobBuilderFactory
                .get("dailyReportJob")
                .start(step())
                .build();
    }
}
