package com.fr.ojt.batch.listener;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;

public class StepListener {
    private StepExecution stepExecution;

    @BeforeStep
    public void beforeStep(StepExecution stepExecution){
       /* ExecutionContext jobContext = stepExecution.getJobExecution()
                .getExecutionContext();
        int totalQuantity = Integer.parseInt(jobContext
                .get("count")
                .toString());
        System.out.println(totalQuantity);*/
       System.out.println(">>Before Step");
       this.stepExecution = stepExecution;
        //System.out.println();
    }

    @AfterStep
    public void afterStep(StepExecution stepExecution){
        System.out.println("Total quantity: " +stepExecution.getExecutionContext().get("count"));
        System.out.println("<<After Step");
       /* ExecutionContext stepContext = stepExecution.getExecutionContext();
        stepContext.put("count",totalQuantity);*/
    }

    }
