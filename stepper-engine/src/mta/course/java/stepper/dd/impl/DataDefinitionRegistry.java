package mta.course.java.stepper.dd.impl;

import mta.course.java.stepper.dd.api.DataDefinition;
import mta.course.java.stepper.dd.impl.File.FileDataDeffinition;
import mta.course.java.stepper.dd.impl.List.ListDataDefinition;
import mta.course.java.stepper.dd.impl.Mapping.MappingDataDefinition;
import mta.course.java.stepper.dd.impl.number.DoubleDataDefinition;
import mta.course.java.stepper.dd.impl.relation.RelationDataDefinition;
import mta.course.java.stepper.dd.impl.string.StringDataDefinition;

public enum DataDefinitionRegistry implements DataDefinition{
    STRING(new StringDataDefinition()),
    DOUBLE(new DoubleDataDefinition()),
    RELATION(new RelationDataDefinition()),
    FILE(new FileDataDeffinition()),
    LIST(new ListDataDefinition()),
    MAPPING(new MappingDataDefinition())
    ;

    DataDefinitionRegistry(DataDefinition dataDefinition) {
        this.dataDefinition = dataDefinition;
    }

    private final DataDefinition dataDefinition;

    @Override
    public String getName() {
        return dataDefinition.getName();
    }

    @Override
    public boolean isUserFriendly() {
        return dataDefinition.isUserFriendly();
    }

    @Override
    public Class<?> getType() {
        return dataDefinition.getType();
    }
}
