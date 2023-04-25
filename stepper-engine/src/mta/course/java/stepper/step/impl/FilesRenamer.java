package mta.course.java.stepper.step.impl;

import mta.course.java.stepper.dd.impl.DataDefinitionRegistry;
import mta.course.java.stepper.flow.execution.context.StepExecutionContext;
import mta.course.java.stepper.step.api.AbstractStepDefinition;
import mta.course.java.stepper.step.api.DataDefinitionDeclarationImpl;
import mta.course.java.stepper.step.api.DataNecessity;
import mta.course.java.stepper.step.api.StepResult;

public class FilesRenamer extends AbstractStepDefinition {
   public FilesRenamer()
   {
       super("Files_Renamer", false);
       addInput(new DataDefinitionDeclarationImpl("FILES_TO_RENAME", DataNecessity.MANDATORY, "Files to rename", DataDefinitionRegistry.LIST));
       addInput(new DataDefinitionDeclarationImpl("PREFIX", DataNecessity.OPTIONAL, "Files to rename", DataDefinitionRegistry.STRING));
       addInput(new DataDefinitionDeclarationImpl("SUFFIX", DataNecessity.OPTIONAL, "Append this suffix", DataDefinitionRegistry.STRING));


       addOutput(new DataDefinitionDeclarationImpl("RENAME_RESULT", DataNecessity.NA, "Rename operation summary", DataDefinitionRegistry.RELATION));

   }


    @Override
    public StepResult invoke(StepExecutionContext context) {
        return null;
    }
}
