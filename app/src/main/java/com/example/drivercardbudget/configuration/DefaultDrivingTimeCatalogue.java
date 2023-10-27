package com.example.drivercardbudget.configuration;

import com.example.drivercardbudget.configuration.Interfaces.IDrivingTimeCatalogue;

public class DefaultDrivingTimeCatalogue implements IDrivingTimeCatalogue {
    //REST
    public static int REGULAR_BREAK_TIME = 45;
    public static int SPLIT_BREAK_TIME_1 = 15;
    public static int SPLIT_BREAK_TIME_2 = 30;
    public static int REDUCED_DAILY_RESTING_TIME = 9*60;
    public static int MAX_REDUCED_DAILY_RESTS = 3;
    public static int REGULAR_DAILY_RESTING_TIME = 11*60;
    public static int SPLIT_DAILY_RESTING_TIME_1 = 3*60;
    public static int SPLIT_DAILY_RESTING_TIME_2 = 9*60;
    public static int REGULAR_WEEKLY_RESTING_TIME = 45*60;
    public static int REDUCED_WEEKLY_RESTING_TIME = 24*60;

    //DRIVING
    public static int DRIVING_TIME_PERIOD = 270;
    public static int REGULAR_DAILY_DRIVING_TIME = 9*60;
    public static int EXTENDED_DAILY_DRIVING_TIME = 10*60;
    public static int MAX_EXTENDED_DAILY_DRIVING_TIMES = 2;
    public static int WEEKLY_DRIVING_TIME = 54*60;
    public static int FORTNIGHT_DRIVING_TIME = 90*60;

    @Override
    public int getRegularBreakTime() {
        return REGULAR_BREAK_TIME;
    }

    @Override
    public int getSplitBreakTime1() {
        return SPLIT_BREAK_TIME_1;
    }

    @Override
    public int getSplitBreakTime2() {
        return SPLIT_BREAK_TIME_2;
    }

    @Override
    public int getReducedDailyRestingTime() {
        return REDUCED_DAILY_RESTING_TIME;
    }

    @Override
    public int getMaxReducedDailyRests() {
        return MAX_REDUCED_DAILY_RESTS;
    }

    @Override
    public int getRegularDailyRestingTime() {
        return REGULAR_DAILY_RESTING_TIME;
    }

    @Override
    public int getSplitDailyRestingTime1() {
        return SPLIT_DAILY_RESTING_TIME_1;
    }

    @Override
    public int getSplitDailyRestingTime2() {
        return SPLIT_DAILY_RESTING_TIME_2;
    }

    @Override
    public int getRegularWeeklyRestingTime() {
        return REGULAR_WEEKLY_RESTING_TIME;
    }

    @Override
    public int getReducedWeeklyRestingTime() {
        return REDUCED_WEEKLY_RESTING_TIME;
    }

    @Override
    public int getDrivingTimePeriod() {
        return DRIVING_TIME_PERIOD;
    }

    @Override
    public int getRegularDailyDrivingTime() {
        return REGULAR_DAILY_DRIVING_TIME;
    }

    @Override
    public int getExtendedDailyDrivingTime() {
        return EXTENDED_DAILY_DRIVING_TIME;
    }

    @Override
    public int getMaxExtendedDailyDrivingTimes() {return MAX_EXTENDED_DAILY_DRIVING_TIMES;}

    @Override
    public int getWeeklyDrivingTime() {
        return WEEKLY_DRIVING_TIME;
    }

    @Override
    public int getFortnightDrivingTime() {
        return FORTNIGHT_DRIVING_TIME;
    }
}
