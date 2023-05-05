package mta.course.java.stepper.flow.definition.api;

import java.util.List;

public class CustomMappingOBJContainer {
    public List<CustomMappingOBJ> getContainer() {
        return Container;
    }

    public void setContainer(List<CustomMappingOBJ> container) {
        Container = container;
    }

    private List<CustomMappingOBJ> Container;

}
