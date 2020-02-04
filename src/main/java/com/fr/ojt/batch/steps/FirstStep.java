package com.fr.ojt.batch.steps;

import com.fr.ojt.batch.listener.ChunkListener;
import com.fr.ojt.batch.listener.StepListener;
import com.fr.ojt.batch.reader.DbReader;
import com.fr.ojt.batch.processor.TotalQuantityProcessor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.lang.Integer.*;

@Configuration
public class FirstStep {
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    private static int totalQuantity;

    @Bean
    public DbReader dbReader() {
        return new DbReader();
    }

    @Bean
    public TotalQuantityProcessor processor() {
        return new TotalQuantityProcessor();
    }

    @Bean
    public ItemWriter writer() {
        return quantity -> {
            totalQuantity = parseInt(quantity
                    .get(1)
                    .toString());
            System.out.println("total quantity of this chunk : " + totalQuantity);
        };
    }

    @Bean
    public Step build() {
        return stepBuilderFactory.get("step1").<String, String>chunk(2)
                .faultTolerant()
                .listener(new ChunkListener())
                .listener(new StepListener())
                .reader(dbReader())
                .processor(processor())
                .writer(writer())
                .build();
    }
}

 /*   @AfterStep
    public ExitStatus afterStep(StepExecution stepExecution){
        return null;
    }*/
    /* @Override
    public String getName() {
        return "step1";
    }

    @Override
    public boolean isAllowStartIfComplete() {
        return false;
    }

    @Override
    public int getStartLimit() {
        return 0;
    }

    @Override
    public void execute(StepExecution stepExecution) throws JobInterruptedException {
       *//* this.stepExecution=stepExecution;
 *//**//*ExecutionContext stepContext = stepExecution.getExecutionContext();
        stepContext.put("count", totalQuantity);*//**//*
        this.stepExecution
                .getExecutionContext()
                .put("count", totalQuantity);*//*
    }*/
