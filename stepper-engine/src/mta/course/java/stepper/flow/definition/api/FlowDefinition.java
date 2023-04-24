package mta.course.java.stepper.flow.definition.api;

import mta.course.java.stepper.step.api.DataDefinitionDeclaration;

import java.util.List;
/**
 * This is an interface that define the design of the FLOW object.
 *
 * **/
public interface FlowDefinition {
    String getName();
    String getDescription();
    List<StepUsageDeclaration> getFlowSteps();
    List<String> getFlowFormalOutputs();

    void validateFlowStructure();
    List<DataDefinitionDeclaration> getFlowFreeInputs();
}
