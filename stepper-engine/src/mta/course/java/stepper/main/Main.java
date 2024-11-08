package mta.course.java.stepper.main;

import mta.course.java.stepper.dd.api.AbstractDataDefinition;
import mta.course.java.stepper.flow.definition.api.FlowDefinition;
import mta.course.java.stepper.flow.definition.api.FlowDefinitionImpl;
import mta.course.java.stepper.flow.definition.api.StepUsageDeclarationImpl;
import mta.course.java.stepper.flow.definitionMapping.AutomaticMapping;
import mta.course.java.stepper.flow.execution.FlowExecution;
import mta.course.java.stepper.flow.execution.runner.FLowExecutor;
import mta.course.java.stepper.step.StepDefinitionRegistry;
import mta.course.java.stepper.xmlparse.STStepper;
import mta.course.java.stepper.xmlparse.Validator.SchemaBaesdJAXCreator;
import mta.course.java.stepper.xmlparse.XMLLoader;
import mta.course.java.stepper.xmlparse.mta.course.java.stepper.xmlparse.ConvertSTObjectsToProjectObjects;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        FlowDefinition flow1 = new FlowDefinitionImpl("Flow 1", "Hello world");
        flow1.getFlowSteps().add(new StepUsageDeclarationImpl(StepDefinitionRegistry.HELLO_WORLD.getStepDefinition()));
        flow1.validateFlowStructure();

        FlowDefinition flow2 = new FlowDefinitionImpl("Flow 2", "show two person details");
        flow2.getFlowSteps().add(new StepUsageDeclarationImpl(StepDefinitionRegistry.HELLO_WORLD.getStepDefinition()));
        flow2.getFlowSteps().add(new StepUsageDeclarationImpl(StepDefinitionRegistry.PERSON_DETAILS.getStepDefinition(), "Person 1 Details"));
        flow2.getFlowSteps().add(new StepUsageDeclarationImpl(StepDefinitionRegistry.PERSON_DETAILS.getStepDefinition(), "Person 2 Details"));
        flow2.getFlowFormalOutputs().add("DETAILS");
        flow2.validateFlowStructure();

        FLowExecutor fLowExecutor = new FLowExecutor();

        FlowExecution flow2Execution1 = new FlowExecution("1", flow2);
        // collect all user inputs and store them on the flow execution object
        fLowExecutor.executeFlow(flow2Execution1);

        FlowExecution flow2Execution2 = new FlowExecution("2", flow2);
        // collect all user inputs and store them on the flow execution object
        fLowExecutor.executeFlow(flow2Execution1);
// new mine
        List<FlowDefinition>  Flows = new ArrayList<FlowDefinition>();
*/       XMLLoader xmlLoader = new XMLLoader("C:\\Steptocheck\\ex1.xml");
        STStepper stStepper = xmlLoader.load();
       boolean xmlvalid = xmlLoader.validator();

        if (stStepper == null) {
            System.out.println("Failed to load STStepper. Log: \n" + xmlLoader.getLog());
        } else {
            System.out.println("STStepper loaded successfully.");
        }

        ConvertSTObjectsToProjectObjects converter = new ConvertSTObjectsToProjectObjects();
        converter.setStsteper(stStepper);
       List<FlowDefinition> flows = converter.convertSTFlowsToFlowDefinitions(stStepper.getSTFlows());


        System.out.println("kaki");


    }
}
