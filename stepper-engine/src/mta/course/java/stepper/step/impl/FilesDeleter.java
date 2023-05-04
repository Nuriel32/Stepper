package mta.course.java.stepper.step.impl;

import mta.course.java.stepper.dd.impl.DataDefinitionRegistry;
import mta.course.java.stepper.dd.impl.File.FileData;
import mta.course.java.stepper.flow.execution.context.StepExecutionContext;
import mta.course.java.stepper.step.api.AbstractStepDefinition;
import mta.course.java.stepper.step.api.DataDefinitionDeclarationImpl;
import mta.course.java.stepper.step.api.DataNecessity;
import mta.course.java.stepper.step.api.StepResult;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilesDeleter extends AbstractStepDefinition {

    public FilesDeleter() {
        super("Files Deleter", false);
        addInput(new DataDefinitionDeclarationImpl("FILES_LIST", DataNecessity.MANDATORY, "Files to delete", DataDefinitionRegistry.FILE));
        addInput(new DataDefinitionDeclarationImpl("DELETED_LIST", DataNecessity.NA, "Files failed to be deleted", DataDefinitionRegistry.STRING));
        addInput(new DataDefinitionDeclarationImpl("DELETION_STATS", DataNecessity.NA, "Deletion  summary results", DataDefinitionRegistry.MAPPING));
    }


    @Override
    public StepResult invoke(StepExecutionContext context) {
        List<File> filesToDelete = context.getDataValue("FILES_LIST", List.class);
        List<String> deletedFiles = new ArrayList<>();
        Map<String, Integer> deletionStats = new HashMap<>();

        for (File file : filesToDelete) {
            if (file.delete()) {
                deletedFiles.add(file.getAbsolutePath());
                deletionStats.merge("deleted", 1, Integer::sum);
            } else {
                deletionStats.merge("failed", 1, Integer::sum);
            }
        }

        context.storeDataValue("DELETED_LIST", deletedFiles);
        context.storeDataValue("DELETION_STATS", deletionStats);

        return StepResult.SUCCESS;
    }

    @Override
    public Class<?> getType() {
        return this.getClass();
    }

}
