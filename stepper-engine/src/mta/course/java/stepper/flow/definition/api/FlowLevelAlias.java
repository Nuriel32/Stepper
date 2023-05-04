package mta.course.java.stepper.flow.definition.api;

import mta.course.java.stepper.step.api.DataDefinitionDeclaration;

public class FlowLevelAlias {
    StepUsageDeclaration stepaliasname;
    DataDefinitionDeclaration source;
    String alias;

    public StepUsageDeclaration getStepaliasname() {
        return stepaliasname;
    }

    public void setStepaliasname(StepUsageDeclaration stepaliasname) {
        this.stepaliasname = stepaliasname;
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
        this.alias = alias;
    }
}
