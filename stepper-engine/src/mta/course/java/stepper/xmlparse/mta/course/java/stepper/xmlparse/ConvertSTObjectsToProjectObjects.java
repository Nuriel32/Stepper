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

import java.util.*;
import java.util.function.Supplier;


import java.util.ArrayList;
import java.util.List;
public class ConvertSTObjectsToProjectObjects implements ConvertSTAPI {
    public STStepper ststeper;
    private Map<String, Supplier<StepDefinition>> stepSuppliers;
    private Map<String,STStepInFlow> mapstep = new HashMap<>();
    private Map<String,List<String>> aliaserhelper = new HashMap<>();

    private Map<String,String> fromalias2stepname = new HashMap<>();
    private String log;
    private Set<String> stepNames;
    private boolean vaildator = true;





        public void setStsteper(STStepper s)
        {
            ststeper =s;
        }


        /**
         * This functin map name of ststep to his Step STStepInFlow
         * ***/
    public void mapSTStepsByName(STFlow stFlow) {
        for (STStepInFlow stStepInFlow : stFlow.getSTStepsInFlow().getSTStepInFlow()) {
            mapstep.put(stStepInFlow.getName(), stStepInFlow);
        }
    }

    /**
     * This function set a map that key is alias name and value is step name
     *
     ***/
    public void setAliasToStepNameMap(List<STStepInFlow> stSteps) {
        for (STStepInFlow stStep : stSteps) {
            String name = stStep.getName();
            String alias = stStep.getAlias();

            if (alias != null && !alias.isEmpty()) {
                fromalias2stepname.put(alias, name);
            }
        }
    }
    public void setStepNames() {
        stepNames = new HashSet<>();
        stepNames.add("Collect Files In Folder");
        stepNames.add("CSV Exporter");
        stepNames.add("File Dumper");
        stepNames.add("Files Content Extractor");
        stepNames.add("Files Deleter");
        stepNames.add("Files Renamer");
        stepNames.add("Properties Exporter");
        stepNames.add("Spend Some Time");
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



        /**
         * For each step in flow add to some step his alias name in the aliashelper mapping.
         * **/
    public void setAliaserHelper(List<STStepInFlow> stSteps) {
        for (STStepInFlow stStep : stSteps) {
            String name = stStep.getName();
            String alias = stStep.getAlias();

            if (alias != null && !alias.isEmpty()) {
                aliaserhelper.computeIfAbsent(name, k -> new ArrayList<>()).add(alias);

            }
        }
    }

    /**
     * This function convert a single step to his
     *
     * **/

        public StepDefinition convertSTStepToStep(STStepInFlow stStepInFlow) {
        this.SetMapSupllier();
            String stepName = stStepInFlow.getName();
            String aliasName = stStepInFlow.getAlias();
            Supplier<StepDefinition> stepSupplier = stepSuppliers.get(stepName);

            if (stepSupplier == null) {
                throw new IllegalArgumentException("Unknown step name: " + stepName);
            }

            StepDefinition stepDefinition = stepSupplier.get();

            if(null!=stStepInFlow.getAlias()) {
                stepDefinition.SetAliasName(stStepInFlow.getAlias());
            }
            else {stepDefinition.SetAliasName(stStepInFlow.getName());}

            return stepDefinition;
        }


    public FlowDefinition convertSTFlowToFlow(STFlow stFlow) {
        this.SetMapSupllier();
        this.setAliaserHelper(stFlow.getSTStepsInFlow().getSTStepInFlow());
        this.setAliasToStepNameMap(stFlow.getStStepsInFlow().getSTStepInFlow());
        this.setStepNames();


        FlowDefinition flowDefinition = new FlowDefinitionImpl(stFlow.getName(), stFlow.getSTFlowDescription());

        // Convert ST-StepInFlow to StepUsageDeclaration and add to the FlowDefinition
        List<STStepInFlow> stStepInFlowList = stFlow.getSTStepsInFlow().getSTStepInFlow();
        String stFlowOutput = stFlow.getSTFlowOutput();
        for (int i = 0; i < stStepInFlowList.size(); i++) {
            STStepInFlow stStepInFlow = stStepInFlowList.get(i);
            //The use of map.


            //
            StepDefinition stepDefinition = convertSTStepToStep(stStepInFlow);
            flowDefinition.getFlowSteps().add(new StepUsageDeclarationImpl(stepDefinition));
            flowDefinition.getFlowSteps().get(i).SetAliasName(stepDefinition.getAliasName());

            if (stFlowOutput.contains(stStepInFlow.getName())) {
                flowDefinition.addFlowOutput(flowDefinition.getFlowSteps().get(i).getFinalStepName());
            }


        }



       if (stFlow.getSTFlowLevelAliasing()!= null) {
           boolean valid =  validateSTFlowLevelAliases(stFlow.getSTFlowLevelAliasing());
           this.vaildator = valid;
           if(!valid) {
               flowDefinition.SetAliasFlowDefinition(CovnertSTflowlevelalias(flowDefinition, stFlow.getSTFlowLevelAliasing()));
               FlowLevelAliasContainer container = new FlowLevelAliasContainer();
               container.setContainer(flowDefinition.getFlowLevelAlias());
               flowDefinition.setFlowaliascontainer(container);
               container.Unloadcontainer();

           }

        }

       if(stFlow.getSTCustomMappings()!=null) {
           CustomMappingOBJContainer customcontainer = new CustomMappingOBJContainer();
          List<CustomMappingOBJ> a =  convertSTCustomMappingsToCustomMappingOBJs(flowDefinition,stFlow.getStCustomMappings());
           flowDefinition.SetCustomMappingFlowDefinition(convertSTCustomMappingsToCustomMappingOBJs(flowDefinition,stFlow.getStCustomMappings()));
           customcontainer.setContainer(flowDefinition.getCustomMapping());
       }
        if(!this.validateSTFlowOutputs(stFlow))
        {
            this.vaildator=false;
        }
        return flowDefinition;
    }

    public List<FlowDefinition> convertSTFlowsToFlowDefinitions(STFlows stFlows) {
        List<FlowDefinition> flowDefinitions = new ArrayList<>();
        List<STFlow> stflows =  stFlows.getSTFlow();
        for (STFlow singleflow : stflows) {
            FlowDefinition flowDefinition = convertSTFlowToFlow(singleflow);
            if (flowDefinition != null) {
                flowDefinitions.add(flowDefinition);
            }
        }
        return flowDefinitions;
    }


    public StepUsageDeclaration findStepUsageDeclarationByName(FlowDefinition flowDefinition, String stepName) {
        for (StepUsageDeclaration stepUsageDeclaration : flowDefinition.getFlowSteps()) {
            if (stepUsageDeclaration.getStepDefinition().getAliasName().equals(stepName)) {
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
                log +=   "step  with the name " + stFlowLevelAlias.getSourceDataName() + "' not found in the step.";
                }
            } else {
                // Handle the case when the step is not found in the flow's steps
                log += "Step with the name '" + stFlowLevelAlias.getStep() + "' not found in the flow.";
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
        for (DataDefinitionDeclaration dataDefinitionDeclaration : stepUsageDeclaration.getStepDefinition().inputs()) {
            if (dataDefinitionDeclaration.getName().equals(dataDefinitionName)) {
                return dataDefinitionDeclaration;
            }
        }
        return null;
    }



    public boolean isAliasInList(String name, String alias) {
        List<String> aliases = aliaserhelper.get(name);

        if (aliases != null) {
            return aliases.contains(alias);
        } else {
            return false; // Return false if the name is not in the map
        }
    }

/**
 *  convert a single custom mapping  **/
public CustomMappingOBJ convertSTCustomMappingToCustomMappingOBJ(FlowDefinition flowDefinition,STCustomMapping stCustomMapping) {
    CustomMappingOBJ customMappingOBJ = new CustomMappingOBJ();

    // Find the source step and output
    StepUsageDeclaration sourceStepUsageDeclaration = findStepUsageDeclarationByAliasName(flowDefinition, stCustomMapping.getSourceStep());
    if(sourceStepUsageDeclaration== null){
        sourceStepUsageDeclaration = findStepUsageDeclarationByName(flowDefinition,stCustomMapping.getSourceStep());
    }
    DataDefinitionDeclaration sourceDataDefinitionDeclaration = findDataDefinitionDeclarationByAliasName(sourceStepUsageDeclaration, stCustomMapping.getSourceData());
    if(sourceDataDefinitionDeclaration == null){
        sourceDataDefinitionDeclaration = findDataDefinitionDeclarationByName(sourceStepUsageDeclaration, stCustomMapping.getSourceData());
    }

    // Find the destination step and output
    StepUsageDeclaration destStepUsageDeclaration = findStepUsageDeclarationByAliasName(flowDefinition, stCustomMapping.getTargetStep());
    if(destStepUsageDeclaration==null)
    {
        destStepUsageDeclaration = findStepUsageDeclarationByAliasName(flowDefinition,stCustomMapping.getTargetStep());
    }
    DataDefinitionDeclaration destDataDefinitionDeclaration = findDataDefinitionDeclarationByAliasName(destStepUsageDeclaration, stCustomMapping.getTargetData());
    if(destDataDefinitionDeclaration == null){
        destDataDefinitionDeclaration = findDataDefinitionDeclarationByName(destStepUsageDeclaration, stCustomMapping.getTargetData());
    }
    // Set the source and destination steps and outputs
    customMappingOBJ.setSourcestep(sourceStepUsageDeclaration);
    customMappingOBJ.setSourceoutput(sourceDataDefinitionDeclaration);
    customMappingOBJ.setDestinationstep(destStepUsageDeclaration);
    customMappingOBJ.setDestinationinput(destDataDefinitionDeclaration);

    return customMappingOBJ;
}
    public String getLogs()
    {
        return this.log;
    }
  /** Convert List of STCustomMapping to List<CustomMappingOBJ> **/
        public List<CustomMappingOBJ> convertSTCustomMappingsToCustomMappingOBJs(FlowDefinition flowDefinition,STCustomMappings stCustomMappings) {
            List<CustomMappingOBJ> customMappingOBJs = new ArrayList<>();

            for (STCustomMapping stCustomMapping : stCustomMappings.getStCustomMapping()) {
                CustomMappingOBJ customMappingOBJ = convertSTCustomMappingToCustomMappingOBJ(flowDefinition,stCustomMapping);
                customMappingOBJs.add(customMappingOBJ);
            }

            return customMappingOBJs;
        }

    public StepUsageDeclaration findStepUsageDeclarationByAliasName(FlowDefinition flowDefinition, String aliasName) {
        for (StepUsageDeclaration stepUsageDeclaration : flowDefinition.getFlowSteps()) {
            if (stepUsageDeclaration.getStepDefinition().getAliasName().equals(aliasName)) {
                return stepUsageDeclaration;
            }
        }
        return null; // Return null if the step with the given name is not found in the flow's steps
    }

    public DataDefinitionDeclaration findDataDefinitionDeclarationByAliasName(StepUsageDeclaration stepUsageDeclaration, String aliasName) {
        for (DataDefinitionDeclaration dataDefinitionDeclaration : stepUsageDeclaration.getStepDefinition().outputs()) {
            if (dataDefinitionDeclaration.getAliasName() != null && dataDefinitionDeclaration.getAliasName().equals(aliasName)) {
                return dataDefinitionDeclaration;

            }
        }
        return null;
    }


    /****** validators *****/
    public boolean validateSTFlowLevelAliases(STFlowLevelAliasing stFlowLevelAliasing) {
        boolean isValid = true;

        for (STFlowLevelAlias stFlowLevelAlias : stFlowLevelAliasing.getStFlowLevelAlias()) {
            String stepName = stFlowLevelAlias.getStep();
            boolean stepNameFound = false;

            if (stepNames.contains(stepName)) {
                stepNameFound = true;
            } else {
                for (List<String> aliases : aliaserhelper.values()) {
                    if (aliases.contains(stepName)) {
                        stepNameFound = true;
                        break;
                    }
                }
            }

            if (!stepNameFound) {
                log += "Invalid step name found in STFlowLevelAlias: " + stepName + ". This step does not exist in the step names or alias mapping.\n";
                isValid = false;
            }
        }

        return isValid;
    }
    public boolean isValidSTSteps(STStepsInFlow stStepsInFlow) {
        boolean isValid = true;
        for (STStepInFlow stStepInFlow : stStepsInFlow.getStStepInFlow()) {
            if (!stepNames.contains(stStepInFlow.getName())) {
                isValid = false;
                log +=   "Invalid step name found: " + stStepInFlow.getName() + ". This step does not exist in the system.\n";
            }
        }
        return isValid;
    }
    public boolean validateSTFlowOutputs(STFlow stFlow) {
        boolean isValid = true;
        String stFlowOutput = stFlow.getStFlowOutput();
        String[] outputNames = stFlowOutput.split(",");

        for (String outputName : outputNames) {
            String trimmedOutputName = outputName.trim();
            boolean foundInMapStep = mapstep.containsKey(trimmedOutputName);
            boolean foundInAliaserHelper = false;
            boolean foundInFromAlias2StepName = fromalias2stepname.containsKey(trimmedOutputName);

            for (List<String> aliases : aliaserhelper.values()) {
                if (aliases.contains(trimmedOutputName)) {
                    foundInAliaserHelper = true;
                    break;
                }
            }

            if (!foundInMapStep && !foundInAliaserHelper && !foundInFromAlias2StepName) {
                log += "STFlowOutput name not found in the STStepInFlow map, for flow " + stFlow.getName() + ": " + trimmedOutputName + ". Ensure all output names are present .\n";
                isValid = false;
            }
        }

        return isValid;
    }

}




