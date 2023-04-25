package mta.course.java.stepper.step.impl;

import mta.course.java.stepper.dd.impl.DataDefinitionRegistry;
import mta.course.java.stepper.flow.execution.context.StepExecutionContext;
import mta.course.java.stepper.step.api.AbstractStepDefinition;
import mta.course.java.stepper.step.api.DataDefinitionDeclarationImpl;
import mta.course.java.stepper.step.api.DataNecessity;
import mta.course.java.stepper.step.api.StepResult;

public class CollectFilesInFolder extends AbstractStepDefinition {
    public CollectFilesInFolder() {
        super("Collect_Files_IN_Folder", true);
        addInput(new DataDefinitionDeclarationImpl("Folder_Name", DataNecessity.MANDATORY, "Folder name to scan", DataDefinitionRegistry.STRING));
        addInput(new DataDefinitionDeclarationImpl("Filter", DataNecessity.OPTIONAL, "Filter Only these Files", DataDefinitionRegistry.STRING));
        addOutput(new DataDefinitionDeclarationImpl("File_List", DataNecessity.NA, "Files list", DataDefinitionRegistry.FILE));
        addOutput(new DataDefinitionDeclarationImpl("Total_Found", DataNecessity.NA, "Total files found", DataDefinitionRegistry.DOUBLE));
    }


    public StepResult invoke(StepExecutionContext context) {
        return null;
    }
}
