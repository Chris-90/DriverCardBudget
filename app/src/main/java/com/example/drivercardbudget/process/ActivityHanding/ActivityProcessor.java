package com.example.drivercardbudget.process.ActivityHanding;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.drivercardbudget.configuration.DefaultDrivingTimeCatalogue;
import com.example.drivercardbudget.configuration.DefaultWorkTimeConfig;
import com.example.drivercardbudget.configuration.Interfaces.IWorkingTimeCatalogue;
import com.example.drivercardbudget.model.budget.Activities.Activity;

import java.util.List;

/**
 * Verarbeitungsklasse für eine Liste von Aktivitäten
 * Datenhaltung in TimeLine
 */
public class ActivityProcessor {

    private static ActivityProcessor activityProcessor;

    private TimeLine timeLine;

    private ActivityProcessor(Activity activity){
        timeLine = TimeLine.getInstance(activity, selectDrivingTimeCatalogue(), selectWorkingTimeCatalogue());
    }

    public ActivityProcessor getInstance(List<Activity> activityList){
        if(activityProcessor == null){
            if(!activityList.isEmpty()){
                // Initiierung  der Aktivitätsverarbeitung und TimeLine mit der ersten Aktivität der Liste
                activityProcessor = new ActivityProcessor(activityList.get(0));
            }
        }
        return activityProcessor;
    }

    private DefaultDrivingTimeCatalogue selectDrivingTimeCatalogue() {
        return new DefaultDrivingTimeCatalogue();
    }

    private IWorkingTimeCatalogue selectWorkingTimeCatalogue() {
        return new DefaultWorkTimeConfig();
    }
}
