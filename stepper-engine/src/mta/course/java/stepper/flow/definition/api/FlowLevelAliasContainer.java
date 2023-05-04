package mta.course.java.stepper.flow.definition.api;

import java.util.List;

public class FlowLevelAliasContainer {
    private List<FlowLevelAlias> Container;

    public List<FlowLevelAlias> getContainer() {
        return Container;
    }

    public void setContainer(List<FlowLevelAlias> container) {
        Container = container;
    }

    public void Unloadcontainer()
    {
        for (FlowLevelAlias single :Container ) {
            single.getSource().setAliasName(single.getAlias());

        }
    }
}
