package mta.course.java.stepper.step.impl;

import mta.course.java.stepper.dd.api.AbstractDataDefinition;
import mta.course.java.stepper.dd.impl.DataDefinitionRegistry;
import mta.course.java.stepper.dd.impl.number.DoubleDataDefinition;
import mta.course.java.stepper.flow.execution.context.StepExecutionContext;
import mta.course.java.stepper.step.api.AbstractStepDefinition;
import mta.course.java.stepper.step.api.DataDefinitionDeclarationImpl;
import mta.course.java.stepper.step.api.DataNecessity;
import mta.course.java.stepper.step.api.StepResult;
import java.util.concurrent.TimeUnit;

public class SpendSomeTime extends AbstractStepDefinition {

    public SpendSomeTime(DoubleDataDefinition timetospend){
        super("Time_To_Spend", true);
        addInput(new DataDefinitionDeclarationImpl("TIME_TO_SPEND", DataNecessity.MANDATORY ,"Time_To_Spend", DataDefinitionRegistry.DOUBLE));
    }
    public SpendSomeTime(String stepName, boolean readonly) {
        super(stepName, readonly);

    }

    @Override
    public StepResult invoke(StepExecutionContext context) {
        // fetch inputs here, somehow


        Double timetosleep = context.getDataValue("TIME_TO_SPEND", Double.class);
        // Sleep for 1 second
        try {
            TimeUnit.SECONDS.sleep(timetosleep.intValue());
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }

        String greeting = "The System is about to sleep" + timetosleep.toString()+ "seconds";
        // add outputs here, somehow
        context.storeDataValue("DETAILS", greeting);

        // through the context, as part of writing the step's logic I should be able to:
        // 1. add log lines
        // 2. add summary line

        // return result
        return StepResult.SUCCESS;
    }


}
