package mta.course.java.stepper.dd.impl.List;

import mta.course.java.stepper.dd.api.AbstractDataDefinition;
import mta.course.java.stepper.dd.api.DataDefinition;

import java.util.ArrayList;
import java.util.List;

public class ListData {
    private ArrayList<AbstractDataDefinition> data;
    private int counter=0;

    public ArrayList<AbstractDataDefinition> getData() {
        return data;
    }

    public void setData(ArrayList<AbstractDataDefinition> data) {
        this.data = data;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public AbstractDataDefinition getItem(int id ) {
        return data.get(id);
    }
    public void addData(AbstractDataDefinition item){
        data.add(item);
    }



}
