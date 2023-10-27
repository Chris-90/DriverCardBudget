package com.example.drivercardbudget.process.procedureElements;

import com.example.drivercardbudget.model.budget.Activities.Activity;
import com.example.drivercardbudget.process.ActivityHanding.TimeLine;

public interface ITask {
    String getDescription();
    TimeLine apply(TimeLine timeLine, Activity activity);
}
