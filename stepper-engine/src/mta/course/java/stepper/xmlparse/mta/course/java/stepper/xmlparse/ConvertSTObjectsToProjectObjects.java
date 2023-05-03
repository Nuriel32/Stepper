package mta.course.java.stepper.xmlparse.mta.course.java.stepper.xmlparse;
import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import mta.course.java.stepper.flow.definition.api.FlowDefinition;
import mta.course.java.stepper.flow.definition.api.FlowDefinitionImpl;
import mta.course.java.stepper.flow.definition.api.StepUsageDeclaration;
import mta.course.java.stepper.step.api.AbstractStepDefinition;
import mta.course.java.stepper.step.impl.*;
import mta.course.java.stepper.xmlparse.*;
import mta.course.java.stepper.flow.definition.api.*;
import mta.course.java.stepper.step.api.*;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.ArrayList;
import java.util.List;


import java.util.ArrayList;
import java.util.List;
public class ConvertSTObjectsToProjectObjects {
    public STStepper ststeper;
    private Map<String, Supplier<StepDefinition>> stepSuppliers;
    private Map<String,STStepInFlow> mapstep = new HashMap<>();


        public void setStsteper(STStepper s)
        {
            ststeper =s;
        }

    public void mapSTStepsByName(STFlow stFlow) {
        for (STStepInFlow stStepInFlow : stFlow.getSTStepsInFlow().getSTStepInFlow()) {
            mapstep.put(stStepInFlow.getName(), stStepInFlow);
        }
    }


    public void SetMapSupllier(){
            stepSuppliers = new HashMap<>();
            stepSuppliers.put("Collect Files In Folder", () -> new CollectFilesInFolder());
            stepSuppliers.put("CSV Exporter", () -> new CSVExporter());
            stepSuppliers.put("File Dumper", () -> new FileDumper());
            stepSuppliers.put("Files Content Extractor", () -> new FilesContentExtractor());
            stepSuppliers.put("Files Deleter", () -> new FilesDeleter());
            stepSuppliers.put("Files Renamer", () -> new FilesRenamer());
            stepSuppliers.put("Properties Exporter", () -> new PropertiesExporter());
            stepSuppliers.put("Spend Some Time", () -> new SpendSomeTime("Time_To_Spend",true));
        }

        public StepDefinition convertSTStepToStep(STStepInFlow stStepInFlow) {
        this.SetMapSupllier();
            String stepName = stStepInFlow.getName();
            Supplier<StepDefinition> stepSupplier = stepSuppliers.get(stepName);

            if (stepSupplier == null) {
                throw new IllegalArgumentException("Unknown step name: " + stepName);
            }

            return stepSupplier.get();
        }


    public FlowDefinition convertSTFlowToFlow(STFlow stFlow) {
        this.SetMapSupllier();

            FlowDefinition flowDefinition = new FlowDefinitionImpl(stFlow.getName(), stFlow.getSTFlowDescription());

            // Convert ST-StepInFlow to StepUsageDeclaration and add to the FlowDefinition
            List<STStepInFlow> stStepInFlowList = stFlow.getSTStepsInFlow().getSTStepInFlow();
            String stFlowOutput = stFlow.getSTFlowOutput();
            for (int i = 0; i < stStepInFlowList.size(); i++) {
                STStepInFlow stStepInFlow = stStepInFlowList.get(i);
                StepDefinition stepDefinition = stepSuppliers.get(stStepInFlow.getName()).get();
                flowDefinition.getFlowSteps().add(new StepUsageDeclarationImpl(stepDefinition));

                if(stFlowOutput.contains(stStepInFlow.getName()))
                {
                 //   flowDefinition.addFlowOutput(flowDefinition.getFlowSteps().get(i).getFinalStepName());
                }
                flowDefinition.SetAliasFlowDefinition(CovnertSTflowlevelalias(flowDefinition,stFlow.getSTFlowLevelAliasing()));

            } return flowDefinition;
        }


    public List<FlowDefinition> convertSTFlowsToFlowDefinitions(STFlows stFlows) {
        List<FlowDefinition> flowDefinitions = new ArrayList<>();
        List<STFlow> stflows =  stFlows.getSTFlow();
        for (STFlow singleflow : stflows) {
            FlowDefinition flowDefinition = convertSTFlowToFlow(singleflow);
            flowDefinitions.add(flowDefinition);
        }
        return flowDefinitions;
    }


    public StepUsageDeclaration findStepUsageDeclarationByName(FlowDefinition flowDefinition, String stepName) {
        for (StepUsageDeclaration stepUsageDeclaration : flowDefinition.getFlowSteps()) {
            if (stepUsageDeclaration.getStepDefinition().name().equals(stepName)) {
                return stepUsageDeclaration;
            }
        }
        return null; // Return null if the step with the given name is not found in the flow's steps
    }
    public List<FlowLevelAlias> CovnertSTflowlevelalias(FlowDefinition flowDefinition, STFlowLevelAliasing stFlowLevelAliasing) {
        List<FlowLevelAlias> flowLevelAliases = new ArrayList<>();

        for (STFlowLevelAlias stFlowLevelAlias : stFlowLevelAliasing.getStFlowLevelAlias()) {
            FlowLevelAlias flowLevelAlias = new FlowLevelAlias();

            StepUsageDeclaration stepUsageDeclaration = findStepUsageDeclarationByName(flowDefinition, stFlowLevelAlias.getStep());
            if (stepUsageDeclaration != null) {
                flowLevelAlias.setStepaliasname(stepUsageDeclaration);

                DataDefinitionDeclaration dataDefinitionDeclaration = findDataDefinitionDeclarationByName(stepUsageDeclaration, stFlowLevelAlias.getSourceDataName());
                if (dataDefinitionDeclaration != null) {
                    flowLevelAlias.setSource(dataDefinitionDeclaration);
                    flowLevelAlias.setAlias(stFlowLevelAlias.getAlias());
                    flowLevelAliases.add(flowLevelAlias);
                } else {
                    // Handle the case when the DataDefinitionDeclaration is not found in the step's data definitions
                    System.err.println("DataDefinitionDeclaration with the name '" + stFlowLevelAlias.getSourceDataName() + "' not found in the step.");
                }
            } else {
                // Handle the case when the step is not found in the flow's steps
                System.err.println("Step with the name '" + stFlowLevelAlias.getStep() + "' not found in the flow.");
            }
        }
        return flowLevelAliases;
    }

    public DataDefinitionDeclaration findDataDefinitionDeclarationByName(StepUsageDeclaration stepUsageDeclaration, String dataDefinitionName) {
        for (DataDefinitionDeclaration dataDefinitionDeclaration : stepUsageDeclaration.getStepDefinition().outputs()) {
            if (dataDefinitionDeclaration.getName().equals(dataDefinitionName)) {
                return dataDefinitionDeclaration;
            }
        }
        return null;
    }





}