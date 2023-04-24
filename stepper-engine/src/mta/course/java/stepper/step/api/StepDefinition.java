package mta.course.java.stepper.step.api;
import mta.course.java.stepper.dd.api.DataDefinition;
import mta.course.java.stepper.flow.execution.context.StepExecutionContext;
import java.util.List;

/**
 * interface that present the step definiton ,contain : name of step,readonly Y/N,List of inputs and List of out puts.
 * @method invoke -> the real logic of the step is HERE! for each step.
 * **/
public interface StepDefinition {
    String name();
    boolean isReadonly();
    List<DataDefinitionDeclaration> inputs();
    List<DataDefinitionDeclaration> outputs();
    StepResult invoke(StepExecutionContext context);
}
