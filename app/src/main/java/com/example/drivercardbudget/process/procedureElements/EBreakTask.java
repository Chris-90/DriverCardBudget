package com.example.drivercardbudget.process.procedureElements;

import com.example.drivercardbudget.model.budget.Activities.Activity;
import com.example.drivercardbudget.process.ActivityHanding.TimeLine;

public enum EBreakTask implements ITask {
    STOP_DRIVING_PERIOD("existing regular break to end driving period"){
        @Override
        public TimeLine apply(TimeLine timeLine, Activity activity){
            timeLine.getCurrentDrivingPeriod().setEnd(activity.getStart());
            timeLine.getPreviousDrivingPeriods().add(timeLine.getCurrentDrivingPeriod());
            timeLine.setCurrentDrivingPeriod(null);
            return timeLine;
        }
    },
    STOP_UNINTERRUPTED_WORK("existing regular break to end driving period"){
        @Override
        public TimeLine apply(TimeLine timeLine, Activity activity) {
            timeLine.getCurrentUninterruptedWork().setEnd(activity.getStart());
            timeLine.getPreviousUninterruptedWorks().add(timeLine.getCurrentUninterruptedWork());
            timeLine.setCurrentUninterruptedWork(null);
            return timeLine;
        }
    };


    private String description;

    EBreakTask(String s) {}

    @Override
    public String getDescription() {
        return null;
    }
}
