package mta.course.java.stepper.flow.execution;
//package com.dataflair.switchcase;
import java.util.*;

import static javafx.application.Platform.exit;

public class SystemMotor {
    SystemMotor systemMotor;
    public void PrintMainMenu(){
        //todo: let the user choice to press 0 if want back to this menu
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.println("Welcome to Stepper, A system that support the following actions:" +
                "1.Download xml file" +
                "2.Display flows names (defined in the file)" +
                "3.Execute a flow " +
                "4.Display full details of earlier executions" +
                "5.Display statistic information about executions occurred in the system so far, (flow wise and step wise)" +
                "6.Exit the system" +
                "For jumping back to the main menu, you can press 0 anytime " +
                "please enter your choice: ");
        num=sc.nextInt();
        //systemMotor motor; return motor.activateOption(num);
    }
    //a
    public void FirstOption(){
        //Func that Downloads XML file
    }

    public void SecondOption(){
        //Display all flow definitions existed in the system
        //a.Func that Display numbered list of the names of flows which defined in the
        //  system, get user's choice, and b.
        //b.Func that gets flow's name and returns information about specific flow: 1.it's name 2.description 3.list of flow's
        //  formal outputs
        //----> 4.if readonly 5.list of flow's steps ordered by appearance order, by: step name (+alias if there is) and if readonly or not--->
        //--->6. list of all free inputs, with:|input's final name| type| list of steps that involved with this input| mandatory or optional input-->
        //-->7. list of all flow's outputs with:|output's final name| type| name of the step that produced this output|
    }

    public void ThirdOption(){
        //Execute a chosen flow
        //a.func that displays to user numbered list of system's flows names to choose from (also giving option to go back to the main menu by entering 0)
        //b.func that shows numbered list of flow's free inputs by: serial number| original_name(alias name)| mandatory or optional [user have to enter a number]
        //c.func updating input: user entering value for the chosen input (the func will repeat like that !!(bool)!!till all mandatory inputs received->
        //  then we are offering : to execute (jump to d.)| continue with the inputs updating |0-back to main menu
        //d.func that runs step by step

    }

    public void FourthOption(){
        //Displays executions full details

        //a.func that displays to user a list of system's flow executions from most recently to least recently, by:
        //  |serial number |flow's name |UUID of execution |timeStamp (HH:MM:SS)|
        //  user enter number of flow execution he wants to get full details about.

        //b.func that displays to user full flow execution details:
        //1.uuid of flowExecution
        // 2.flow name
        // 3.flow's result ( WARNING\ SUCCESS \FAILURE )
        // 4.flowExecution duration in ms
        // 5.display list of flow's free inputs with mandatory inputs first, by::
        //   |final name|type|value|optional OR mandatory|
        // 6.display list of flow's outputs, by:
        //   |final name|type|value|
        //   7.display information about steps took part in this flow, by:
        //   |step name+ alias if exist|step duration in ms|step result ( WARNING\ SUCCESS \FAILURE )|step summary line|
        //   |logs that accumulated during the step running (by the order of their creation) by: timeStamp HH:MM:SS.sss, the log's content
    }





    public void FifthOption(){
        //Executions Statistics
        //Func that displays statistics about flows and steps after all executions occurred in the system:
        //|flow's name|amount of executions|flow's average runtimes in ms(can be 0 as well)|
        //|step's name|amount of executions|step's average runtimes in ms(can be 0 as well)|
    }

    public void sixthOption(){
        //exit from system
        exit();
    }




    public void RunTheMenu(){
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.println("Please enter number between 1 to 6");
        num=sc.nextInt();
        if (!((num>0)&&(num<7)))
            System.out.println("Please enter number between 1 to 6");num=sc.nextInt();
        switch(num)
        {
            case 1://read the xml file
                System.out.println("xml downloaded successfully or not");
                break;
            case 2://display flow definition
                //todo: Func that displays a file's flows list include serial number (for user choice) and flow's name
                System.out.println("This are the flows names in the file-" +
                        "then choose one to explore =");
                //todo: function that prints for flow: its steps, inputs, outputs
                break;
            case 3://execution
                System.out.println("the info about the execution:" +
                        "1.The UUID of this flow's execution is: " +
                        "2.Flow name is: " +
                        "3.Flow ended with: SUCCESS \\ WARNING \\ FAILURE" +
                        "4.Flow formal output(s) are:|| Not created due to failure in flow ");
                break;

            case 4://full information about flow executions before
                System.out.println("");
                break;

            case 5://statistics
                System.out.println("a");
                break;
            case 6:
                //todo: Function that download the xml
                System.out.println("b");
                break;
            default:
                System.out.println("if");
        }

    }
}