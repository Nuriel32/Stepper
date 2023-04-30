package mta.course.java.stepper.flow.definitionMapping;

import mta.course.java.stepper.dd.api.AbstractDataDefinition;
import mta.course.java.stepper.step.api.DataDefinitionDeclaration;

import java.util.List;

public interface MappingDefiniton {

    List<AbstractDataDefinition> GetSteps();
    void SetSteps(List<AbstractDataDefinition> steps);

    List<AbstractDataDefinition> GetUnconnectedSteps();

    void InvokeMapping();
    List<DataDefinitionDeclaration> GetMadatoriesInput();





}
