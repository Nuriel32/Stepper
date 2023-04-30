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

    public AbstractMappingDefinition(List<AbstractStepDefinition> steps) {
        this.steps = steps;
    }

    public AbstractMappingDefinition(List<AbstractStepDefinition> steps, List<AbstractStepDefinition> unConnectedSteps) {
        this.steps = steps;
        this.unConnectedSteps = unConnectedSteps;
    }

    public AbstractMappingDefinition(List<AbstractStepDefinition> steps, List<AbstractStepDefinition> unConnectedSteps, Map<DataNecessity, AbstractDataDefinition> mapbydatanecessity) {
        this.steps = steps;
        this.unConnectedSteps = unConnectedSteps;
        this.mapbydatanecessity = mapbydatanecessity;
    }

    public AbstractMappingDefinition(List<AbstractStepDefinition> steps, List<AbstractStepDefinition> unConnectedSteps, Map<DataNecessity, AbstractDataDefinition> mapbydatanecessity, List<List<AbstractStepDefinition>> possiblesteps, int totalsteps) {
        this.steps = steps;
        this.unConnectedSteps = unConnectedSteps;
        this.mapbydatanecessity = mapbydatanecessity;
        this.possiblesteps = possiblesteps;
        this.totalsteps = totalsteps;
    }

    public AbstractMappingDefinition(List<AbstractStepDefinition> steps, List<AbstractStepDefinition> unConnectedSteps, Map<DataNecessity, AbstractDataDefinition> mapbydatanecessity, List<List<AbstractStepDefinition>> possiblesteps) {
        this.steps = steps;
        this.unConnectedSteps = unConnectedSteps;
        this.mapbydatanecessity = mapbydatanecessity;
        this.possiblesteps = possiblesteps;
    }

    public AbstractMappingDefinition()
    {}

    public List<AbstractStepDefinition> getSteps() {
        return steps;
    }

    public void setSteps(List<AbstractStepDefinition> steps) {
        this.steps = steps;
    }

    public List<AbstractStepDefinition> getUnConnectedSteps() {
        return unConnectedSteps;
    }

    public void setUnConnectedSteps(List<AbstractStepDefinition> unConnectedSteps) {
        this.unConnectedSteps = unConnectedSteps;
    }

    public Map<DataNecessity, AbstractDataDefinition> getMapbydatanecessity() {
        return mapbydatanecessity;
    }

    public void setMapbydatanecessity(Map<DataNecessity, AbstractDataDefinition> mapbydatanecessity) {
        this.mapbydatanecessity = mapbydatanecessity;
    }

    public List<List<AbstractStepDefinition>> getPossiblesteps() {
        return possiblesteps;
    }

    public void setPossiblesteps(List<List<AbstractStepDefinition>> possiblesteps) {
        this.possiblesteps = possiblesteps;
    }

    public int getTotalsteps() {
        return totalsteps;
    }

    public void setTotalsteps(int totalsteps) {
        this.totalsteps = totalsteps;
    }


    @Override
    public List<AbstractDataDefinition> GetSteps() {
        return null;
    }

    @Override
    public void SetSteps(List<AbstractDataDefinition> steps) {

    }

    @Override
    public List<AbstractDataDefinition> GetUnconnectedSteps() {
        return null;
    }

    @Override
    public void InvokeMapping() {

    }

    @Override
    public List<DataDefinitionDeclaration> GetMadatoriesInput() {
        return null;
    }
}
