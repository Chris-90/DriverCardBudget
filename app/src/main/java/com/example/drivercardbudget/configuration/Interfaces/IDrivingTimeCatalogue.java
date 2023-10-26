package com.example.drivercardbudget.configuration.Interfaces;

public interface IDrivingTimeCatalogue {
    public int getRegularBreakTime();
    public int getSplitBreakTime1();
    public int getSplitBreakTime2();
    public int getReducedDailyRestingTime() ;
    public int getMaxCountReducedDailyRest();
    public int getRegularDailyRestingTime();
    public int getSplitDailyRestingTime1();
    public int getSplitDailyRestingTime2();
    public int getRegularWeeklyRestingTime();
    public int getReducedWeeklyRestingTime();
    public int getDrivingTimePeriod();
    public int getRegularDailyDrivingTime();
    public int getExtendedDailyDrivingTime();
    public int getWeeklyDrivingTime();
    public int getFortnightDrivingTime();
}
