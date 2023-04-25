package mta.course.java.stepper.step.impl;

import mta.course.java.stepper.dd.impl.DataDefinitionRegistry;
import mta.course.java.stepper.flow.execution.context.StepExecutionContext;
import mta.course.java.stepper.step.api.AbstractStepDefinition;
import mta.course.java.stepper.step.api.DataDefinitionDeclarationImpl;
import mta.course.java.stepper.step.api.DataNecessity;
import mta.course.java.stepper.step.api.StepResult;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDumper extends AbstractStepDefinition {

    public FileDumper() {
        super("File_Dumper", true);
        addInput(new DataDefinitionDeclarationImpl("CONTENT", DataNecessity.MANDATORY, "Content", DataDefinitionRegistry.STRING));
        addInput(new DataDefinitionDeclarationImpl("FILE_NAME", DataNecessity.MANDATORY, "Target file path", DataDefinitionRegistry.STRING));

        addOutput(new DataDefinitionDeclarationImpl("RESULT", DataNecessity.MANDATORY, "File Creation Result", DataDefinitionRegistry.STRING));
    }


    @Override
    public StepResult invoke(StepExecutionContext context) {
        String content = context.getDataValue("CONTENT", String.class);
        String fileName = context.getDataValue("FILE_NAME", String.class);

        try {
            Files.write(Paths.get(fileName), content.getBytes());
            context.storeDataValue("RESULT", "File created successfully");
            return StepResult.SUCCESS;
        } catch (IOException e) {
            context.storeDataValue("RESULT", "File creation failed: " + e.getMessage());
            return StepResult.FAILURE;
        }
    }

}

