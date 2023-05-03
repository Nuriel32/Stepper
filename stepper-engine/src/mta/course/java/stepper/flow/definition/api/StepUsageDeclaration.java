package mta.course.java.stepper.flow.definition.api;

import mta.course.java.stepper.step.api.StepDefinition;
/***
 *
 * */
public interface StepUsageDeclaration {
    String getFinalStepName();
    StepDefinition getStepDefinition();
    String getAliasName();
    String SetAliasName(String aliasname);
    boolean skipIfFail();
}
