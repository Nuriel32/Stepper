package mta.course.java.stepper.xmlparse.mta.course.java.stepper.xmlparse;

import mta.course.java.stepper.flow.definition.api.FlowDefinition;
import mta.course.java.stepper.flow.definition.api.FlowLevelAlias;
import mta.course.java.stepper.flow.definition.api.StepUsageDeclaration;
import mta.course.java.stepper.step.api.DataDefinitionDeclaration;
import mta.course.java.stepper.step.api.StepDefinition;
import mta.course.java.stepper.xmlparse.*;

import java.util.List;

public interface ConvertSTAPI {
    /**
     * Sets the STStepper object to be used for conversion.
     *
     * @param s The STStepper object.
     */
    public void setStsteper(STStepper s);

    /**
     * Maps STStep objects by their name.
     *
     * @param stFlow The STFlow object containing the STStep objects.
     */
    public void mapSTStepsByName(STFlow stFlow);

    /**
     * Sets the alias to step name mapping.
     *
     * @param stSteps The list of STStepInFlow objects.
     */
    public void setAliasToStepNameMap(List<STStepInFlow> stSteps);

    /**
     * Sets the MapSupllier for the conversion process.
     */
    public void SetMapSupllier();

    /**
     * Sets the AliaserHelper for the conversion process.
     *
     * @param stSteps The list of STStepInFlow objects.
     */
    public void setAliaserHelper(List<STStepInFlow> stSteps);

    /**
     * Converts an STStepInFlow object to a StepDefinition object.
     *
     * @param stStepInFlow The STStepInFlow object.
     * @return The converted StepDefinition object.
     */
    public StepDefinition convertSTStepToStep(STStepInFlow stStepInFlow);

    /**
     * Converts an STFlow object to a FlowDefinition object.
     *
     * @param stFlow The STFlow object.
     * @return The converted FlowDefinition object.
     */
    public FlowDefinition convertSTFlowToFlow(STFlow stFlow);

    /**
     * Converts a list of STFlow objects to a list of FlowDefinition objects.
     *
     * @param stFlows The list of STFlow objects.
     * @return The list of converted FlowDefinition objects.
     */
    public List<FlowDefinition> convertSTFlowsToFlowDefinitions(STFlows stFlows);

    /**
     * Finds a StepUsageDeclaration object by its name.
     *
     * @param flowDefinition The FlowDefinition object.
     * @param stepName       The name of the StepUsageDeclaration object.
     * @return The found StepUsageDeclaration object, or null if not found.
     */
    public StepUsageDeclaration findStepUsageDeclarationByName(FlowDefinition flowDefinition, String stepName);

    /**
     * Converts a list of STFlowLevelAliasing objects to a list of FlowLevelAlias objects.
     *
     * @param flowDefinition      The FlowDefinition object.
     * @param stFlowLevelAliasing The STFlowLevelAliasing object.
     * @return The list of converted FlowLevelAlias objects.
     */
    /**
     * Finds a DataDefinitionDeclaration object by its name.
     *
     * @param stepUsageDeclaration The StepUsageDeclaration object.
     * @param dataDefinitionName   The name of the DataDefinitionDeclaration object.
     * @return The found DataDefinitionDeclaration object, or null if not found.
     */
    public DataDefinitionDeclaration findDataDefinitionDeclarationByName(StepUsageDeclaration stepUsageDeclaration, String dataDefinitionName);

    /**
     * Checks if an alias is in the list of aliases.
     *
     * @param name  The name of the item to check the alias for.
     * @param alias The alias to check.
     * @return true if the alias is in the list, false otherwise.
     */
    public boolean isAliasInList(String name, String alias);
/** this function setname of steps that we have in the system**/
    public void setStepNames();
        /**
         * This function checks if the STSteps that recevied from the xml file exist in the system.
         */
         boolean validateSTFlowLevelAliases(STFlowLevelAliasing stFlowLevelAliasing);
    boolean isValidSTSteps(STStepsInFlow stStepsInFlow);
}