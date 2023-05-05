package mta.course.java.stepper.xmlparse.mta.course.java.stepper.xmlparse;

import mta.course.java.stepper.flow.definition.api.FlowDefinition;
import mta.course.java.stepper.flow.definition.api.FlowLevelAlias;
import mta.course.java.stepper.flow.definition.api.StepUsageDeclaration;
import mta.course.java.stepper.step.api.DataDefinitionDeclaration;
import mta.course.java.stepper.step.api.StepDefinition;
import mta.course.java.stepper.xmlparse.*;

import java.util.List;

public interface ConvertSTAPI {
    public void setStsteper(STStepper s);
    public void mapSTStepsByName(STFlow stFlow);
    public void setAliasToStepNameMap(List<STStepInFlow> stSteps);
    public void SetMapSupllier();
    public void setAliaserHelper(List<STStepInFlow> stSteps);
    public StepDefinition convertSTStepToStep(STStepInFlow stStepInFlow);
    public FlowDefinition convertSTFlowToFlow(STFlow stFlow);
    public List<FlowDefinition> convertSTFlowsToFlowDefinitions(STFlows stFlows);
    public StepUsageDeclaration findStepUsageDeclarationByName(FlowDefinition flowDefinition, String stepName);
    public List<FlowLevelAlias> CovnertSTflowlevelalias(FlowDefinition flowDefinition, STFlowLevelAliasing stFlowLevelAliasing);
    public DataDefinitionDeclaration findDataDefinitionDeclarationByName(StepUsageDeclaration stepUsageDeclaration, String dataDefinitionName);
    public boolean isAliasInList(String name, String alias);

}
