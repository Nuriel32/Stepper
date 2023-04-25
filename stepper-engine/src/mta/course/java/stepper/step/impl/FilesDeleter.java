package mta.course.java.stepper.step.impl;

import mta.course.java.stepper.dd.impl.DataDefinitionRegistry;
import mta.course.java.stepper.flow.execution.context.StepExecutionContext;
import mta.course.java.stepper.step.api.AbstractStepDefinition;
import mta.course.java.stepper.step.api.DataDefinitionDeclarationImpl;
import mta.course.java.stepper.step.api.DataNecessity;
import mta.course.java.stepper.step.api.StepResult;

public class FilesDeleter extends AbstractStepDefinition {

    public FilesDeleter(){
        super("Files_Deleter", false);
        addInput(new DataDefinitionDeclarationImpl("FILES_LIST", DataNecessity.MANDATORY, "Files to delete", DataDefinitionRegistry.FILE));
        addInput(new DataDefinitionDeclarationImpl("DELETED_LIST", DataNecessity.NA, "Files failed to be deleted", DataDefinitionRegistry.STRING));
        addInput(new DataDefinitionDeclarationImpl("DELETION_STATS", DataNecessity.NA, "Deletion  summary results",DataDefinitionRegistry.MAPPING));
    }


    @Override
    public StepResult invoke(StepExecutionContext context) {

        /** List<File> filesToDelete = context.getInputValue("FILES_LIST");
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

         StepResult result = new StepResult();**/
        return null;
    }

}
