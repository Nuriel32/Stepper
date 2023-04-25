package mta.course.java.stepper.step.impl;

import mta.course.java.stepper.dd.impl.DataDefinitionRegistry;
import mta.course.java.stepper.dd.impl.File.FileDataDeffinition;
import mta.course.java.stepper.flow.execution.context.StepExecutionContext;
import mta.course.java.stepper.step.api.AbstractStepDefinition;
import mta.course.java.stepper.step.api.DataDefinitionDeclarationImpl;
import mta.course.java.stepper.step.api.DataNecessity;
import mta.course.java.stepper.step.api.StepResult;

import java.io.File;

public class FilesContentExtractor extends AbstractStepDefinition {
    public FilesContentExtractor(){
        super("Files_Contect_Extractor", false);
        addInput(new DataDefinitionDeclarationImpl("FILES_LIST", DataNecessity.MANDATORY, "Files to extract", DataDefinitionRegistry.LIST));
        addInput(new DataDefinitionDeclarationImpl("LINE", DataNecessity.MANDATORY, "Line number to extract", DataDefinitionRegistry.DOUBLE));

        addOutput(new DataDefinitionDeclarationImpl("DATA", DataNecessity.MANDATORY, "Data extraction", DataDefinitionRegistry.RELATION));
    }

    @Override
    public StepResult invoke(StepExecutionContext context) {
        return null;
    }
}
