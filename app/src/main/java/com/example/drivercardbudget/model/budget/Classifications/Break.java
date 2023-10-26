package com.example.drivercardbudget.model.budget.Classifications;

import com.example.drivercardbudget.model.budget.Activities.Rest;

import java.time.LocalDateTime;

public class Break extends Rest {
    private boolean isSplitAvailable = false;
    // reguläre Pausen und Ruhezeiten Break Objekte = null;
    private Break firstPart;
    private Break secondPart;

    public Break(LocalDateTime start) {
        super(start);
    }

    @Override
    public boolean isBreak() {
        return true;
    }

    public Break getFirstPart() {
        return firstPart;
    }
    public void setFirstPart(Break firstPartOfSplit) {
        this.firstPart = firstPartOfSplit;
    }
    public Break getSecondPart() {
        return secondPart;
    }

    public void setSecondPart(Break secondPart) {
        this.secondPart = secondPart;
    }

    public boolean isSplitAvailable() {
        return isSplitAvailable;
    }

    public void setSplitAvailable(boolean splitAvailable) {
        isSplitAvailable = splitAvailable;
    }

    public String toString(){
        String split = "empty";
        if(getFirstPart() != null){
            split = getFirstPart().toString();
        }
        String value = "start: "+getStart()+"\n"
                + "end: "+getEnd()+"\n"
                + "split? :"+ split;
        return value;
    }
}
