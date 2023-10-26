package com.example.drivercardbudget.model.budget.Classifications;

import com.example.drivercardbudget.model.budget.Abstract.TimePeriod;

import java.time.LocalDateTime;

public class Shift extends TimePeriod {

    private DriverWorkingDay workingDay;
    private DriverDrivingDay drivingDay;

    private DailyRestingPeriod beginningDailyRestingPeriod;

    private DailyRestingPeriod endingDailyRestingPeriod;

    Shift(LocalDateTime start, LocalDateTime end){
        setStart(start);
        setEnd(end);
    }

    private void prepareWorkingAndDrivingDay(){
        this.workingDay = new DriverWorkingDay(getStart());
        this.drivingDay = new DriverDrivingDay(getStart());
    }

    public void setWorkingDay(DriverWorkingDay workingDay){

    }

    public DriverWorkingDay getWorkingDay() {
        return workingDay;
    }

    public DriverDrivingDay getDrivingDay() {
        return drivingDay;
    }

    public void setDrivingDay(DriverDrivingDay drivingDay) {
        this.drivingDay = drivingDay;
    }

    public DailyRestingPeriod getBeginningDailyRestingPeriod() {
        return beginningDailyRestingPeriod;
    }

    public void setBeginningDailyRestingPeriod(DailyRestingPeriod beginningDailyRestingPeriod) {
        this.beginningDailyRestingPeriod = beginningDailyRestingPeriod;
    }

    public DailyRestingPeriod getEndingDailyRestingPeriod() {
        return endingDailyRestingPeriod;
    }

    public void setEndingDailyRestingPeriod(DailyRestingPeriod endingDailyRestingPeriod) {
        this.endingDailyRestingPeriod = endingDailyRestingPeriod;
    }
}
