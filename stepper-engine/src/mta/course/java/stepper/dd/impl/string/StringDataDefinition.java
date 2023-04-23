package mta.course.java.stepper.dd.impl.string;

import mta.course.java.stepper.dd.api.AbstractDataDefinition;
/**
 * this class extand AbstractDataDefinition,and implement this String
 * in order to make it easier for using.
 * **/
public class StringDataDefinition extends AbstractDataDefinition {

    public StringDataDefinition() {
        super("String", true, String.class);
    }
}
