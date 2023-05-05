package mta.course.java.stepper.flow.definition.api;

import mta.course.java.stepper.step.api.DataDefinitionDeclaration;

public class CustomMappingOBJ {
    private StepUsageDeclaration sourcestep;
    private  DataDefinitionDeclaration sourceoutput;



    private  StepUsageDeclaration destinationstep;
    private DataDefinitionDeclaration destinationinput;

    public StepUsageDeclaration getSstep() {
        return sourcestep;
    }

    public void setSStep(StepUsageDeclaration sstep) {
        this.sourcestep = sstep;
    }

    public DataDefinitionDeclaration getSSutput() {
        return sourceoutput;
    }

    public void setSoutput(DataDefinitionDeclaration soutput) {
        this.sourceoutput = soutput;
    }

    public StepUsageDeclaration getDStep() {
        return destinationstep;
    }

    public void setDStep(StepUsageDeclaration dstep) {
        this.destinationstep = dstep;
    }

    public DataDefinitionDeclaration getDOutput() {
        return destinationinput;
    }

    public void setDOutput(DataDefinitionDeclaration input) {
        this.destinationinput = input;
    }
}
