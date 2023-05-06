package mta.course.java.stepper.flow.definition.api;

import mta.course.java.stepper.dd.api.DataDefinition;
import mta.course.java.stepper.step.api.DataDefinitionDeclaration;
import mta.course.java.stepper.step.api.DataDefinitionDeclarationImpl;

import java.util.ArrayList;
import java.util.List;

public class FlowLevelAliasContainer {
    private List<FlowLevelAlias> Container;
    private List<String> logs = new ArrayList<String>();
    private boolean ValildFlowlevelAliaser=true;
    public List<FlowLevelAlias> getContainer() {
        return Container;
    }


    public void setContainer(List<FlowLevelAlias> container) {
        Container = container;
    }

    public void Unloadcontainer()
    {
        for (FlowLevelAlias single :Container ) {
        single.source.setAliasName(single.alias);
            logs.add(single.getLogs());
            if(!single.isValid())
            {
                ValildFlowlevelAliaser = false;
            }

        }
        //Container = null;
    }
}
