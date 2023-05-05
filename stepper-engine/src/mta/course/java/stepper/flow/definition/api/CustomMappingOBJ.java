package mta.course.java.stepper.flow.definition.api;

import mta.course.java.stepper.step.api.DataDefinitionDeclaration;

public class CustomMappingOBJ {
    private StepUsageDeclaration sstep;
    private  DataDefinitionDeclaration soutput;



    private  StepUsageDeclaration dstep;
    private DataDefinitionDeclaration doutput;

    public StepUsageDeclaration getSstep() {
        return sstep;
    }

    public void setSStep(StepUsageDeclaration sstep) {
        this.sstep = sstep;
    }

    public DataDefinitionDeclaration getSSutput() {
        return soutput;
    }

    public void setSoutput(DataDefinitionDeclaration soutput) {
        this.soutput = soutput;
    }

    public StepUsageDeclaration getDStep() {
        return dstep;
    }

    public void setDStep(StepUsageDeclaration dstep) {
        this.dstep = dstep;
    }

    public DataDefinitionDeclaration getDOutput() {
        return doutput;
    }

    public void setDOutput(DataDefinitionDeclaration doutput) {
        this.doutput = doutput;
    }
}
