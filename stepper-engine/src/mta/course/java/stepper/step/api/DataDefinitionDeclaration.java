package mta.course.java.stepper.step.api;

import mta.course.java.stepper.dd.api.DataDefinition;
/**
 * how does the data look.
 * contain : name -> name of the step object.
 *          dataneseccity -> na/optinal/mandatory
 *             Userstring -> what is the userstring that accompanied the data finition
 *              DataDefinition -> the defadefintion him self that accompanied the object.
 * **/
public interface DataDefinitionDeclaration {
    String getName();
    DataNecessity necessity();
    String userString();
    DataDefinition dataDefinition();
    String getAliasName();
    void setAliasName(String aliasName);
}
