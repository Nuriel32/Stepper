package mta.course.java.stepper.flow.definition.api;

import mta.course.java.stepper.step.api.DataDefinitionDeclaration;

import java.util.List;
/**
 * This is an interface that define the design of the FLOW object.
 *  List<StepUsageDeclaration> getFlowsSteps -> not the steps it`s self only the decleration on the steps.
 *  List<Strings> getFlowFormalOutputs -> not the out put them self only the definitions of the out puts.
 * @method VaildateFlowStructure - > checks if the flow is valid after giving all the data I.E getflow stps and
 * getflowformaloutputs
 * **/
public interface FlowDefinition {
    String getName();
    String getDescription();
    List<StepUsageDeclaration> getFlowSteps();
    List<String> getFlowFormalOutputs();
    List<FlowLevelAlias> getFlowLevelAlias();
    void validateFlowStructure();
    List<DataDefinitionDeclaration> getFlowFreeInputs();
}
