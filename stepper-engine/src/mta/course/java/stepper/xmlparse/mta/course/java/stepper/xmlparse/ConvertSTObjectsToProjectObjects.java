package mta.course.java.stepper.xmlparse.mta.course.java.stepper.xmlparse;
import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import mta.course.java.stepper.flow.definition.api.FlowDefinition;
import mta.course.java.stepper.flow.definition.api.FlowDefinitionImpl;
import mta.course.java.stepper.flow.definition.api.StepUsageDeclaration;
import mta.course.java.stepper.step.api.AbstractStepDefinition;
import mta.course.java.stepper.step.impl.*;
import mta.course.java.stepper.xmlparse.STFlow;
import mta.course.java.stepper.xmlparse.STFlows;
import mta.course.java.stepper.xmlparse.STStepInFlow;
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
    private Map<String, Supplier<StepDefinition>> stepSuppliers;
    private Map<String,STStepInFlow> mapstep = new HashMap<>();



    public void mapSTStepsByName(STFlow stFlow) {
        for (STStepInFlow stStepInFlow : stFlow.getSTStepsInFlow().getSTStepInFlow()) {
            mapstep.put(stStepInFlow.getName(), stStepInFlow);
        }
    }


    public void SetMapSupllier(){
            stepSuppliers = new HashMap<>();
            stepSuppliers.put("CollectFilesInFolder", () -> new CollectFilesInFolder());
            stepSuppliers.put("CSVExporter", () -> new CSVExporter());
            stepSuppliers.put("FileDumper", () -> new FileDumper());
            stepSuppliers.put("FilesContentExtractor", () -> new FilesContentExtractor());
            stepSuppliers.put("FilesDeleter", () -> new FilesDeleter());
            stepSuppliers.put("FilesRenamer", () -> new FilesRenamer());
            stepSuppliers.put("PropertiesExporter", () -> new PropertiesExporter());
            stepSuppliers.put("SpendSomeTime", () -> new SpendSomeTime("Time_To_Spend",true));
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

            FlowDefinitionImpl flowDefinition = new FlowDefinitionImpl(stFlow.getName(), stFlow.getSTFlowDescription());

            // Convert ST-StepInFlow to StepUsageDeclaration and add to the FlowDefinition
            List<STStepInFlow> stStepInFlowList = stFlow.getSTStepsInFlow().getSTStepInFlow();
            String stFlowOutput = stFlow.getSTFlowOutput();
            for (int i = 0; i < stStepInFlowList.size(); i++) {
                STStepInFlow stStepInFlow = stStepInFlowList.get(i);
                flowDefinition.getFlowSteps().add(new StepUsageDeclarationImpl(stepSuppliers.get(stStepInFlowList.get(i).getName()).get()));

                if(stFlowOutput.contains(stStepInFlow.getName()))
                {
                    flowDefinition.addFlowOutput(flowDefinition.getFlowSteps().get(i).getFinalStepName());
                }

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






}