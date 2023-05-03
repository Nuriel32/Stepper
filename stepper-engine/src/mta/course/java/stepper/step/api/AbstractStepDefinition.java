package mta.course.java.stepper.step.api;

import java.util.ArrayList;
import java.util.List;
/**
 * an Abstract class that contain all of the standard data for steps,
 * @dataMembers
 * final String Stepname -> the name of the step.
 * boolean readonly -> Y/N if the step is readable.
 * List<DataDefinitionDeclartion> inputs -> a list that contain an interface objects of the input types
 * List<DataDefinitionDeclartion> inputs -> a list that contain an interface objects of the output types
 * **/
public abstract class AbstractStepDefinition implements StepDefinition {

    private final String stepName;
    private final boolean readonly;
    private final List<DataDefinitionDeclaration> inputs;
    private final List<DataDefinitionDeclaration> outputs;

    private  String aliasname;
/**
 * Aconstractor
 * @parm String stepName -> the name of the step.
 * @parm boolean Readonly -> if Read oly Y/N
 * The constactor creates new ArrayList of inputs.
 * The constractor creates new ArrayList of outputs
 * **/
    public AbstractStepDefinition(String stepName, boolean readonly) {
        this.stepName = stepName;
        this.readonly = readonly;
        inputs = new ArrayList<>();
        outputs = new ArrayList<>();
        this.aliasname =stepName;
    }
/**
 * This is a protected void function that add an data type DataDefinitionDeclartion to the input Lists.
 * @parm DataDefinitationDeclaration dataDefinitonDeclartation -> the the DDD that we want to add.
 * @return None.
 * **/
    protected void addInput(DataDefinitionDeclaration dataDefinitionDeclaration) {
        inputs.add(dataDefinitionDeclaration);
    }
    /**
     * This is a protected void function that add an data type DataDefinitionDeclartion to the Outputs Lists.
     * @parm DataDefinitationDeclaration dataDefinitonDeclartation -> the the DDD that we want to add.
     * @return None.
     * **/
    protected void addOutput(DataDefinitionDeclaration dataDefinitionDeclaration) {
        outputs.add(dataDefinitionDeclaration);
    }

    @Override
    public String name() {
        return stepName;
    }

    @Override
    public boolean isReadonly() {
        return readonly;
    }

    @Override
    public List<DataDefinitionDeclaration> inputs() {
        return inputs;
    }

    @Override
    public List<DataDefinitionDeclaration> outputs() {
        return outputs;
    }

    @Override
    public String getAliasName()
    {
        return aliasname;
    }
    @Override
    public void SetAliasName(String newalias)
    {
        aliasname = newalias;
    }
}
