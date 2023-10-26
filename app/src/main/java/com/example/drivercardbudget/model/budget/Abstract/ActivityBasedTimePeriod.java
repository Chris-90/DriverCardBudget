package com.example.drivercardbudget.model.budget.Abstract;

import java.time.LocalDateTime;

public abstract class ActivityBasedTimePeriod extends TimePeriod {

    /**
     * Wird in Minuten angegeben,
     * Da die Difference von Start und Ende
     * nicht immer dem Wert entspricht wird
     * dieser erst von den Kindern angenommen oder berechnet
     */
    private int totalValue = 0;

    public ActivityBasedTimePeriod(LocalDateTime start) {
        setStart(start);
    }

    public boolean isWork(){
        return false;
    }
    public boolean isRest(){
        return false;
    }
     public boolean isDriving(){
        return false;
     }

     public int getTotalValue() {
         return totalValue;
     }

     protected void setTotalValue(int value){
        this.totalValue = value;
     }

    protected void setTotalValue(ActivityBasedTimePeriod value){
        this.totalValue = value.getTotalValue();
    }

     public void addTotalValue(int value){
         this.totalValue += value;
     }

     public void addTotalValue(ActivityBasedTimePeriod value){
         this.totalValue += value.getTotalValue();
     }


}
