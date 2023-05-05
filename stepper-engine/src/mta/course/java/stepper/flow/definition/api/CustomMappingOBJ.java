package mta.course.java.stepper.flow.definition.api;

import mta.course.java.stepper.step.api.DataDefinitionDeclaration;

public class CustomMappingOBJ {
    private StepUsageDeclaration sourcestep;
    private  DataDefinitionDeclaration sourceoutput;



    private  StepUsageDeclaration destinationstep;
    private DataDefinitionDeclaration destinationinput;

    public StepUsageDeclaration getSourcestep() {
        return sourcestep;
    }

    public void setSourcestep(StepUsageDeclaration sourcestep) {
        this.sourcestep = sourcestep;
    }

    public DataDefinitionDeclaration getSourceoutput() {
        return sourceoutput;
    }

    public void setSourceoutput(DataDefinitionDeclaration sourceoutput) {
        this.sourceoutput = sourceoutput;
    }

    public StepUsageDeclaration getDestinationstep() {
        return destinationstep;
    }

    public void setDestinationstep(StepUsageDeclaration destinationstep) {
        this.destinationstep = destinationstep;
    }

    public DataDefinitionDeclaration getDestinationinput() {
        return destinationinput;
    }

    public void setDestinationinput(DataDefinitionDeclaration destinationinput) {
        this.destinationinput = destinationinput;
    }
}
