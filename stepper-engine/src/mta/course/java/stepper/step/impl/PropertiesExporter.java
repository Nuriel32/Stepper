package mta.course.java.stepper.step.impl;

import mta.course.java.stepper.dd.impl.DataDefinitionRegistry;
import mta.course.java.stepper.flow.execution.context.StepExecutionContext;
import mta.course.java.stepper.step.api.AbstractStepDefinition;
import mta.course.java.stepper.step.api.DataDefinitionDeclarationImpl;
import mta.course.java.stepper.step.api.DataNecessity;
import mta.course.java.stepper.step.api.StepResult;

public class PropertiesExporter extends AbstractStepDefinition {
    public PropertiesExporter(){
        super("Properties Exporter", true);
        addInput(new DataDefinitionDeclarationImpl("SOURCE", DataNecessity.MANDATORY, "Source data", DataDefinitionRegistry.RELATION));

        addOutput(new DataDefinitionDeclarationImpl("RESULT", DataNecessity.MANDATORY, "Properties export result", DataDefinitionRegistry.STRING));


    }
    @Override
    public StepResult invoke(StepExecutionContext context) {
        return null;
    }

    @Override
    public Class<?> getType() {
        return this.getClass();
    }
}
