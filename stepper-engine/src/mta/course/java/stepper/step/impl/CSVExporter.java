package mta.course.java.stepper.step.impl;

import mta.course.java.stepper.dd.impl.DataDefinitionRegistry;
import mta.course.java.stepper.flow.execution.context.StepExecutionContext;
import mta.course.java.stepper.step.api.AbstractStepDefinition;
import mta.course.java.stepper.step.api.DataDefinitionDeclarationImpl;
import mta.course.java.stepper.step.api.DataNecessity;
import mta.course.java.stepper.step.api.StepResult;

public class CSVExporter extends AbstractStepDefinition {
    public CSVExporter()
    {
        super("CSV_EXPORTER", true);
        addInput(new DataDefinitionDeclarationImpl("SOURCE", DataNecessity.MANDATORY, "Source data", DataDefinitionRegistry.RELATION));

        addOutput(new DataDefinitionDeclarationImpl("RESULT", DataNecessity.MANDATORY, "CSV exportResult", DataDefinitionRegistry.STRING));
    }

    @Override
    public StepResult invoke(StepExecutionContext context) {
        return null;
    }
}
