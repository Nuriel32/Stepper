package mta.course.java.stepper.flow.definitionMapping;

import mta.course.java.stepper.dd.api.AbstractDataDefinition;
import mta.course.java.stepper.step.api.AbstractStepDefinition;
import mta.course.java.stepper.step.api.DataDefinitionDeclaration;
import mta.course.java.stepper.step.api.DataNecessity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractMappingDefinition implements MappingDefiniton {

    private  List<AbstractStepDefinition> steps;
    private  List<AbstractStepDefinition> unConnectedSteps;
    private   Map<DataNecessity,AbstractDataDefinition> mapbydatanecessity;
    private  List<List<AbstractStepDefinition>> possiblesteps;
    private  int totalsteps;

    public AbstractMappingDefinition()
    {
        steps = new ArrayList<AbstractStepDefinition>();
        unConnectedSteps = new ArrayList<AbstractStepDefinition>();
        mapbydatanecessity = new HashMap<DataNecessity,AbstractDataDefinition>();
        possiblesteps = new ArrayList<>();
    }


}
