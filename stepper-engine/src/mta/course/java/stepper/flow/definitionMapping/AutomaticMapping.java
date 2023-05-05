package mta.course.java.stepper.flow.definitionMapping;

import mta.course.java.stepper.flow.definition.api.FlowDefinition;
import mta.course.java.stepper.flow.definition.api.StepUsageDeclaration;
import mta.course.java.stepper.step.api.DataDefinitionDeclaration;
import mta.course.java.stepper.step.api.StepDefinition;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class AutomaticMapping extends AbstractMappingDefinition {
//need to add more constractors(smart constractors that might be based on constractors that has been written)
    public AutomaticMapping(){
        super();
    }


    //this method get flow definition and build ordered list of steps
    public List<StepUsageDeclaration> CreateGoodFlow(FlowDefinition flowDefinition){
        int stepIdx=0;
        int goodListIdx=0;
        List<StepUsageDeclaration> goodList = null;

        List<StepUsageDeclaration> origSteps = flowDefinition.getFlowSteps();
        int stepsAmount=origSteps.size();

        for(int i=stepIdx; i<stepsAmount; i++) {
            for (int j = i + 1; j > i; j++) {
                if (haveMatchingOutInp(origSteps.get(i).getStepDefinition().outputs()
                        , origSteps.get(j).getStepDefinition().inputs())) {
                    goodList.set(goodListIdx, origSteps.get(i));
                    goodListIdx += 1;
                    goodList.set(goodListIdx, origSteps.get(j));
                    goodListIdx += 1;
                    i = j;//to make sure that earlier step output go to later step input
                } else continue;
            }
        }
        return goodList;
    }

    //a method that returning the steps that didn't match in goodFlow by list
    public List<StepUsageDeclaration> stepsOutOfFlow(FlowDefinition flowDefinition){
        List<StepUsageDeclaration> origSteps = flowDefinition.getFlowSteps();
        List<StepUsageDeclaration> goodFlow = CreateGoodFlow(flowDefinition);
        List<StepUsageDeclaration> outOfFlowSteps = null;
        int stepIdx=0;
        int badStepsIdx=0;
        int stepsAmount=origSteps.size();
        for(int i=stepIdx; i<stepsAmount; i++){
            if (goodFlow.contains(origSteps.get(i)))
                continue;
            else
                outOfFlowSteps.set(badStepsIdx, origSteps.get(i));badStepsIdx+=1;
        }
        return outOfFlowSteps;
    }

    //method that bring a list of ddd that are the flow's free inputs
    public List<DataDefinitionDeclaration> flowFreeInputs (FlowDefinition flowDefinition){
        List<StepUsageDeclaration> outOfFlowSteps=stepsOutOfFlow(flowDefinition);
        List<DataDefinitionDeclaration> theFlowFreeInputs=null; //list we will return
        int stepsAmount=outOfFlowSteps.size();
        int stepIdx=0;
        int freeInpIdx=0;
        for(int i=stepIdx; i<stepsAmount; i++) {
            int numInpInStep=outOfFlowSteps.get(i).getStepDefinition().inputs().size();
            int inputIdx=0;
            for(int j=inputIdx;j<numInpInStep;j++) {
                theFlowFreeInputs.set(freeInpIdx,
                        outOfFlowSteps.get(i).getStepDefinition().inputs().get(j));
                freeInpIdx += 1;
            }
        }
        return theFlowFreeInputs;
    }


    //method that bring a list of ddd that are the flow's free outputs
    public List<DataDefinitionDeclaration> flowFreeOutputs (FlowDefinition flowDefinition){
        List<StepUsageDeclaration> outOfFlowSteps=stepsOutOfFlow(flowDefinition);
        List<DataDefinitionDeclaration> theFlowFreeOutputs=null; //list we will return
        int stepsAmount=outOfFlowSteps.size();
        int stepIdx=0;
        int freeOutputIdx=0;
        int freeInpIdx =0;
        for(int i=stepIdx; i<stepsAmount; i++) {
            int numInpInStep=outOfFlowSteps.get(i).getStepDefinition().outputs().size();
            int outputIdx=0;
            for(int j=outputIdx;j<numInpInStep;j++) {
                theFlowFreeOutputs.set(freeOutputIdx,
                        outOfFlowSteps.get(i).getStepDefinition().outputs().get(j));
                freeInpIdx += 1;
            }
        }
        return theFlowFreeOutputs;
    }

    public Set<DataDefinitionDeclaration> mandatoryInputsSet(List<DataDefinitionDeclaration> freeInputs){
        int numFreeInputs= freeInputs.size();
        Set<DataDefinitionDeclaration> theMandatoryInputs=null;//returning in the end
        for(int i=0; i<numFreeInputs;i++) {
            theMandatoryInputs.add(freeInputs.get(i));
        }
        return theMandatoryInputs;
    }


    public void DoTheMapping(FlowDefinition flowDefinition){
        List<StepUsageDeclaration> mappedSteps;//place for ordered steps
        List<StepUsageDeclaration> uselessSteps;//place for unused steps this flow
        int outLocation=0;//the earlier step in list that provide its outputs list
        int inLocation=outLocation+1;//the later step in list that provide its inputs list
        List<StepUsageDeclaration> steps = flowDefinition.getFlowSteps();
        int stepsAmount=steps.size();
        for(int idx=outLocation;idx<stepsAmount;idx++){}
        //DataDefinitionDeclaration curr=steps.stream().findFirst().get().getStepDefinition().outputs().get(outLocation);!!
        //DataDefinitionDeclaration after=steps.stream().findFirst().get().getStepDefinition().inputs().get(inLocation);!!
    }

    public boolean isMatchingOutInp(DataDefinitionDeclaration output, DataDefinitionDeclaration input){
        if (output.dataDefinition().getType()==input.dataDefinition().getType()
                && output.dataDefinition().getName() ==input.dataDefinition().getName())
            return true;
        else return false;
    }

    //TODO CHECK WITH NURI
    public boolean haveMatchingOutInp(List<DataDefinitionDeclaration> output, List<DataDefinitionDeclaration> input){
        int numOutputs= output.size();
        int numInputs= input.size();
        for(int i=0; i<numOutputs-1; i++){
            for(int j=0; j<numInputs-1; j++){
                if(isMatchingOutInp(output.get(i), input.get(j)))
                    return true;
                else continue;
            }
            return false;
        }
    }

    //need to implement invoke
    @Override
    public void InvokeMapping() {}
    //need to think about specific DataMembers(if needs) implement Invoke method and also implements/override more functions



}
