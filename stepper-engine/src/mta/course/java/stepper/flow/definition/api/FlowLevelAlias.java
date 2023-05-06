package mta.course.java.stepper.flow.definition.api;

import mta.course.java.stepper.step.api.DataDefinitionDeclaration;
import mta.course.java.stepper.step.api.DataDefinitionDeclarationImpl;
import mta.course.java.stepper.step.api.StepDefinition;

public class FlowLevelAlias {
    StepUsageDeclaration stepaliasname;
    DataDefinitionDeclaration source;
    String alias;
    String logs;
    boolean valid=true;

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

    public void Load()
    {
       StepDefinition step =  stepaliasname.getStepDefinition();

    }

    public String getLogs() {
        return logs;
    }

    public void setLogs(String logs) {
        this.logs = logs;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public boolean validaliasing()
    {
        valid=true;
        if(source==null) {
            valid=false;
            return false;
        }
        return true;
    }
}
