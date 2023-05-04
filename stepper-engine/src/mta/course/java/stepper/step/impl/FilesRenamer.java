package mta.course.java.stepper.step.impl;

import mta.course.java.stepper.dd.impl.DataDefinitionRegistry;
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

public class FilesRenamer extends AbstractStepDefinition {
    public FilesRenamer() {
        super("Files Renamer", false);
        addInput(new DataDefinitionDeclarationImpl("FILES_TO_RENAME", DataNecessity.MANDATORY, "Files to rename", DataDefinitionRegistry.LIST));
        addInput(new DataDefinitionDeclarationImpl("PREFIX", DataNecessity.OPTIONAL, "Files to rename", DataDefinitionRegistry.STRING));
        addInput(new DataDefinitionDeclarationImpl("SUFFIX", DataNecessity.OPTIONAL, "Append this suffix", DataDefinitionRegistry.STRING));


        addOutput(new DataDefinitionDeclarationImpl("RENAME_RESULT", DataNecessity.NA, "Rename operation summary", DataDefinitionRegistry.RELATION));

    }


    @Override
    public StepResult invoke(StepExecutionContext context) {
        List<File> filesToRename = context.getDataValue("FILES_TO_RENAME", List.class);
        String prefix = context.getDataValue("PREFIX", String.class);
        String suffix = context.getDataValue("SUFFIX", String.class);

        List<Map<String, String>> renameResults = new ArrayList<>();

        for (File file : filesToRename) {
            String oldName = file.getAbsolutePath();
            String newName = oldName.substring(0, oldName.lastIndexOf(File.separator) + 1) + prefix + file.getName() + suffix;
            File newFile = new File(newName);

            if (file.renameTo(newFile)) {
                Map<String, String> result = new HashMap<>();
                result.put("oldName", oldName);
                result.put("newName", newName);
                renameResults.add(result);
            }
        }

        context.storeDataValue("RENAME_RESULTS", renameResults);

        return StepResult.SUCCESS;
    }

    @Override
    public Class<?> getType() {
        return this.getClass();
    }

}
