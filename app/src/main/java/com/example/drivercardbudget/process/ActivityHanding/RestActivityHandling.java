package com.example.drivercardbudget.process.ActivityHanding;

import com.example.drivercardbudget.Exceptions.UnexpectedValueException;
import com.example.drivercardbudget.configuration.DefaultDrivingTimeCatalogue;
import com.example.drivercardbudget.model.budget.Abstract.ActivityBasedTimePeriod;
import com.example.drivercardbudget.model.budget.Activities.Activity;
import com.example.drivercardbudget.model.budget.Classifications.Break;
import com.example.drivercardbudget.model.budget.Classifications.DailyRestingPeriod;

public class  RestActivityHandling {

    public static void handleRestActivity(TimeLine timeLine, Activity activity){
        int value = activity.getTotalValue();

    }

    private static void handleBreak(TimeLine timeLine, Activity activity) throws UnexpectedValueException {
        Break workingBreak;
        int value = activity.getTotalValue();
        if(activity.isRest()){
            // neue reguläre Pause / Ruhe
            if (timeLine.getStartedBreak() == null) {
                // Wert > 45 Minuten (kein erster Teil)
                if (DefaultDrivingTimeCatalogue.REGULAR_BREAK_TIME <= value) {
                    workingBreak = new Break(activity.getStart());
                }else if (DefaultDrivingTimeCatalogue.SPLIT_BREAK_TIME_2 <= value) {
                    // Wert >  15 Minuten (kein erster Teil)
                    //add erster Teil
                    workingBreak = new Break(activity.getStart());
                    workingBreak.setFirstPart(new Break(activity.getStart()));
                }
            } else if (timeLine.getStartedBreak() != null
                    && timeLine.getStartedBreak().getFirstPart() == null) {
                // erster Teil vorhanden
                if (timeLine.getStartedBreak().isSplitAvailable()){

                } else {
                    String error = "empty Break?";
                    throw new UnexpectedValueException(error);
                }
            }
        }
    }

    private static void handleDailyRest(TimeLine timeLine, DailyRestingPeriod activity){
        if(activity.isDailyRest()){

        }
    }
}
