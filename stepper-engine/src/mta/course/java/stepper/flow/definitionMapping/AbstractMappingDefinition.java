package mta.course.java.stepper.flow.definitionMapping;

import mta.course.java.stepper.dd.api.AbstractDataDefinition;
import mta.course.java.stepper.step.api.AbstractStepDefinition;
import mta.course.java.stepper.step.api.DataDefinitionDeclaration;
import mta.course.java.stepper.step.api.DataNecessity;

import java.util.List;
import java.util.Map;

public abstract class AbstractMappingDefinition implements MappingDefiniton {

    private  List<AbstractStepDefinition> steps;
    private  List<AbstractStepDefinition> unConnectedSteps;
    private   Map<DataNecessity,AbstractDataDefinition> mapbydatanecessity;





}
