package mta.course.java.stepper.step.impl;

import mta.course.java.stepper.dd.impl.DataDefinitionRegistry;
import mta.course.java.stepper.flow.execution.context.StepExecutionContext;
import mta.course.java.stepper.step.api.AbstractStepDefinition;
import mta.course.java.stepper.step.api.DataDefinitionDeclarationImpl;
import mta.course.java.stepper.step.api.DataNecessity;
import mta.course.java.stepper.step.api.StepResult;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;

public class CSVExporter extends AbstractStepDefinition {
    public CSVExporter()
    {
        super("CSV_EXPORTER", true);
        addInput(new DataDefinitionDeclarationImpl("SOURCE", DataNecessity.MANDATORY, "Source data", DataDefinitionRegistry.RELATION));
        addOutput(new DataDefinitionDeclarationImpl("RESULT", DataNecessity.MANDATORY, "CSV exportResult", DataDefinitionRegistry.STRING));
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


}
