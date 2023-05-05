package mta.course.java.stepper.step.impl;

import mta.course.java.stepper.dd.impl.DataDefinitionRegistry;
import mta.course.java.stepper.dd.impl.File.FileData;
import mta.course.java.stepper.flow.execution.context.StepExecutionContext;
import mta.course.java.stepper.step.api.AbstractStepDefinition;
import mta.course.java.stepper.step.api.DataDefinitionDeclarationImpl;
import mta.course.java.stepper.step.api.DataNecessity;
import mta.course.java.stepper.step.api.StepResult;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class CollectFilesInFolder extends AbstractStepDefinition {
    public CollectFilesInFolder() {
        super("Collect Files In Folder", true);
        addInput(new DataDefinitionDeclarationImpl("FOLDER_NAME", DataNecessity.MANDATORY, "Folder name to scan", DataDefinitionRegistry.STRING));
        addInput(new DataDefinitionDeclarationImpl("FILTER", DataNecessity.OPTIONAL, "Filter Only these Files", DataDefinitionRegistry.STRING));
        addOutput(new DataDefinitionDeclarationImpl("FILES_LIST", DataNecessity.NA, "Files list", DataDefinitionRegistry.FILE));
        addOutput(new DataDefinitionDeclarationImpl("TOTAL_FOUND", DataNecessity.NA, "Total files found", DataDefinitionRegistry.DOUBLE));
    }


    @Override
    public StepResult invoke(StepExecutionContext context) {
        String folderName = context.getDataValue("Folder_Name", String.class);
        String filter = context.getDataValue("Filter", String.class);
        File folder = new File(folderName);

        File[] files = folder.listFiles((dir, name) -> filter == null || name.endsWith(filter));

        if (files != null) {
            context.storeDataValue("File_List", Arrays.asList(files));
            context.storeDataValue("Total_Found", (double) files.length);
        } else {
            context.storeDataValue("File_List", Collections.emptyList());
            context.storeDataValue("Total_Found", 0.0);
        }

        return StepResult.SUCCESS;
    }

    @Override
    public Class<?> getType() {
        return this.getClass();
    }


}
