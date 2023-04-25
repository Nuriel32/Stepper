package mta.course.java.stepper.flow.definition.api;

import mta.course.java.stepper.step.api.StepDefinition;
/**
 * This class implement the interface of StepUseageDeclartion
 * Intro : there is 3 costractors
 * @constractor public StepUsageDeclarationImpl(StepDefinition stepDefinition) -> DIFINITION AND ALIAS
 * @constractor public StepUsageDeclarationImpl(StepDefinition stepDefinition) -> define which step we want to work with
 * and intiilize the DM
 * @constracor public StepUsageDeclarationImpl(StepDefinition stepDefinition,boolean skipIfFall,String stepName ->Alias.
 * giving
 * **/
public class StepUsageDeclarationImpl implements StepUsageDeclaration {
    private final StepDefinition stepDefinition;
    private final boolean skipIfFail;
    private final String stepName;
    private String alias;

    public StepUsageDeclarationImpl(StepDefinition stepDefinition) {
        this(stepDefinition, false, stepDefinition.name());
    }

    public StepUsageDeclarationImpl(StepDefinition stepDefinition, String name) {
        this(stepDefinition, false, name);
    }

    public StepUsageDeclarationImpl(StepDefinition stepDefinition, boolean skipIfFail, String stepName) {
        this.stepDefinition = stepDefinition;
        this.skipIfFail = skipIfFail;
        this.stepName = stepName;
        this.alias = stepName;
    }

    public StepUsageDeclarationImpl(StepDefinition stepDefinition, boolean skipIfFail, String stepName,String alias) {
        this(stepDefinition,skipIfFail,stepName);
        this.alias = alias;
    }

    @Override
    public String getFinalStepName() {
        return stepName;
    }

    @Override
    public StepDefinition getStepDefinition() {
        return stepDefinition;
    }

    @Override
    public boolean skipIfFail() {
        return skipIfFail;
    }
}
