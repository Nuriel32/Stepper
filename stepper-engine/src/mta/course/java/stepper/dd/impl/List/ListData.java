package mta.course.java.stepper.dd.impl.List;

import mta.course.java.stepper.dd.api.AbstractDataDefinition;
import mta.course.java.stepper.dd.api.DataDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListData {
    private ArrayList<AbstractDataDefinition> data;
    private Map<String,AbstractDataDefinition> mapdata;
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
    public AbstractDataDefinition getItemByIndex(int id ) {
        return data.get(id);
    }
    public AbstractDataDefinition getItemByName(String name){return mapdata.get(name);}

    public void addData(AbstractDataDefinition item){
        data.add(item);
        mapdata.put(item.getName(),item);
    }

    public void removeDataByName(String name) {
        AbstractDataDefinition item = mapdata.get(name);
        if (item != null) {
            data.remove(item);
            mapdata.remove(name);
        }
    }




}
