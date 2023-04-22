package mta.course.java.stepper.dd.api;
/* A public interface that design the smallest defination of any object or class in the system,
* every single class should have their name,IF usefriendly and also to save which class we are,
* int this program for each step for example.
*
* */
public interface DataDefinition {
    String getName();
    boolean isUserFriendly();
    //<?> template which ? describe that we do not know the type ,only in run time.
    Class<?> getType();
}
