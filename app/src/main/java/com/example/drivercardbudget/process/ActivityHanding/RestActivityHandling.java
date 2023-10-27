package com.example.drivercardbudget.process.ActivityHanding;

import com.example.drivercardbudget.Exceptions.UnexpectedValueException;
import com.example.drivercardbudget.configuration.DefaultDrivingTimeCatalogue;
import com.example.drivercardbudget.configuration.Interfaces.IDrivingTimeCatalogue;
import com.example.drivercardbudget.model.budget.Abstract.ActivityBasedTimePeriod;
import com.example.drivercardbudget.model.budget.Activities.Activity;
import com.example.drivercardbudget.model.budget.Classifications.Break;
import com.example.drivercardbudget.model.budget.Classifications.DailyRestingPeriod;

public class  RestActivityHandling {

    public static void handleRestActivity(TimeLine timeLine, Activity activity){
        int value = activity.getTotalValue();

    }

    private static void handleBreak(TimeLine timeLine, Activity activity, IDrivingTimeCatalogue drivingTimeCatalogue) throws UnexpectedValueException {
        Break newBreak;
        DailyRestingPeriod restingPeriod;
        int value = activity.getTotalValue();
        if(activity.isRest()){
            if(timeLine.getRequiredDailyRestingTime() > value){
                //Check vor 1 Teil geteilte Tagesruhe
                if(drivingTimeCatalogue.getSplitBreakTime1() < value){
                    // verarbeite geteilte Tagesruhe
                    newBreak = new Break(activity.getStart());
                    restingPeriod = new DailyRestingPeriod(activity.getStart());
                    restingPeriod.setFirstPart(newBreak);
                }
                // Activität ist keine vollwertige Tagesruhe
                // neue reguläre Pause / Ruhe
                if (timeLine.getStartedBreak() == null) {
                    // Wert > 45 Minuten (kein erster Teil)
                    if (drivingTimeCatalogue.getRegularBreakTime() <= value) {
                        newBreak = new Break(activity.getStart());
                    }else if (drivingTimeCatalogue.getSplitBreakTime1() <= value) {
                        // Wert >  15 Minuten (kein erster Teil)
                        //add erster Teil
                        newBreak = new Break(activity.getStart());
                        newBreak.setFirstPart(new Break(activity.getStart()));
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

    }

    private static void handleDailyRest(TimeLine timeLine, DailyRestingPeriod activity){
        if(activity.isDailyRest()){

        }
    }
}
