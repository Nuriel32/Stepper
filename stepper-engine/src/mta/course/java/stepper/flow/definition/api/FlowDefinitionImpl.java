package mta.course.java.stepper.flow.definition.api;

import mta.course.java.stepper.step.api.DataDefinitionDeclaration;

import java.util.ArrayList;
import java.util.List;
/**
 * This class implement the interface FlowDefinition,
 * contain all the data that the  that the flow needs,which means here is the full defiention of the flow
 * also provide all service methods for over who wants to define flow in the system.
 * **/
public class FlowDefinitionImpl implements FlowDefinition {

    private final String name;
    private final String description;
    private final List<String> flowOutputs;
    private final List<StepUsageDeclaration> steps;
    List<FlowLevelAlias> FlowLevelAlias;

    public FlowDefinitionImpl(String name, String description) {
        this.name = name;
        this.description = description;
        flowOutputs = new ArrayList<>();
        steps = new ArrayList<>();
    }

    public void addFlowOutput(String outputName) {
        flowOutputs.add(outputName);
    }

    @Override
    public void validateFlowStructure() {
        // do some validation logic...
    }

    @Override
    public List<DataDefinitionDeclaration> getFlowFreeInputs() {
        return new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public List<StepUsageDeclaration> getFlowSteps() {
        return steps;
    }

    @Override
    public List<String> getFlowFormalOutputs() {
        return flowOutputs;
    }

    @Override
    public List<FlowLevelAlias> getFlowLevelAlias(){
        return FlowLevelAlias;
    }
    @Override
    public void SetAliasFlowDefinition(List<FlowLevelAlias> flowLevelAlias){
        FlowLevelAlias = flowLevelAlias;
    }
}
