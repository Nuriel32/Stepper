package mta.course.java.stepper.step.impl;

import mta.course.java.stepper.dd.impl.DataDefinitionRegistry;
import mta.course.java.stepper.dd.impl.File.FileData;
import mta.course.java.stepper.dd.impl.File.FileDataDeffinition;
import mta.course.java.stepper.flow.execution.context.StepExecutionContext;
import mta.course.java.stepper.step.api.AbstractStepDefinition;
import mta.course.java.stepper.step.api.DataDefinitionDeclarationImpl;
import mta.course.java.stepper.step.api.DataNecessity;
import mta.course.java.stepper.step.api.StepResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilesContentExtractor extends AbstractStepDefinition {
    public FilesContentExtractor() {
        super("Files Content Extractor", false);
        addInput(new DataDefinitionDeclarationImpl("FILES_LIST", DataNecessity.MANDATORY, "Files to extract", DataDefinitionRegistry.LIST));
        addInput(new DataDefinitionDeclarationImpl("LINE", DataNecessity.MANDATORY, "Line number to extract", DataDefinitionRegistry.DOUBLE));

        addOutput(new DataDefinitionDeclarationImpl("DATA", DataNecessity.MANDATORY, "Data extraction", DataDefinitionRegistry.RELATION));
    }

    @Override
    public StepResult invoke(StepExecutionContext context) {
        List<FileData> filesList = context.getDataValue("FILES_LIST", List.class);
        Double lineNumber = context.getDataValue("LINE", Double.class);

        List<String> extractedLines = new ArrayList<>();
        for (FileData fileData : filesList) {
            try {
                List<String> lines = Files.readAllLines(Paths.get(fileData.getPath()));
                if (lineNumber.intValue() < lines.size()) {
                    extractedLines.add(lines.get(lineNumber.intValue()));
                }
            } catch (IOException e) {
                // Handle the exception if necessary
            }
        }
        context.storeDataValue("DATA", extractedLines);
        return StepResult.SUCCESS;
    }
}

