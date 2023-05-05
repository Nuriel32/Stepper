package mta.course.java.stepper.step.api;

import mta.course.java.stepper.dd.api.DataDefinition;

public class DataDefinitionDeclarationImpl implements DataDefinitionDeclaration {

    private final String name;
    private final DataNecessity necessity;
    private final String userString;
    private final DataDefinition dataDefinition;
    private  String aliasName;

    public DataDefinitionDeclarationImpl(String name, DataNecessity necessity, String userString, DataDefinition dataDefinition) {
        this.name = name;
        this.necessity = necessity;
        this.userString = userString;
        this.dataDefinition = dataDefinition;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public DataNecessity necessity() {
        return necessity;
    }

    @Override
    public String userString() {
        return userString;
    }

    @Override
    public DataDefinition dataDefinition() {
        return dataDefinition;
    }

    @Override
    public String getAliasName() {
        return aliasName;
    }


    public void setAliasName(String AliasName) {
        aliasName = AliasName;
    }
}
