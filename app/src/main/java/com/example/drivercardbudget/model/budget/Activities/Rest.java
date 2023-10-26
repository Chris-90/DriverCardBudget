package com.example.drivercardbudget.model.budget.Activities;

import com.example.drivercardbudget.model.budget.Abstract.ActivityBasedTimePeriod;

import java.time.LocalDateTime;

public class Rest extends Activity {
    private boolean isRest = true;

    public Rest(LocalDateTime start) {
        super(start);
    }

    @Override
    public boolean isRest() {
        return isRest;
    }

    public boolean isDailyRest(){return false;}
    public boolean isWeeklyRest(){return false;}

    public boolean isBreak(){return false;}
}
