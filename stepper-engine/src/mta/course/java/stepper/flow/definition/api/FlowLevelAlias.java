package mta.course.java.stepper.flow.definition.api;

import mta.course.java.stepper.step.api.DataDefinitionDeclaration;

public class FlowLevelAlias {
    StepUsageDeclaration stepaliasname;
    DataDefinitionDeclaration source;
    String alias;

    public StepUsageDeclaration getStepname() {
        return stepaliasname;
    }

    public void setStepname(StepUsageDeclaration stepname) {
        this.stepaliasname = stepname;
    }

    public DataDefinitionDeclaration getSource() {
        return source;
    }

    public void setSource(DataDefinitionDeclaration source) {
        this.source = source;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        alias = alias;
    }
}
