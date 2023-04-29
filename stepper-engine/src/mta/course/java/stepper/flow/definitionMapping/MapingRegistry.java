package mta.course.java.stepper.flow.definitionMapping;

public enum MapingRegistry {
    AUTOMATIC_MAPPING(new AutomaticMapping()),
    CUSTOM_MAPPING(new CustomMapping()),

    ALIAS_MAPPING(new AliasMapping());
}
