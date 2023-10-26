package com.example.drivercardbudget.model.budget.Activities;

import com.example.drivercardbudget.model.budget.Abstract.ActivityBasedTimePeriod;

import java.time.LocalDateTime;

public class PeriodOfAvailability extends Activity {
    private boolean isRest = false;
    private boolean isWork = true;

    public PeriodOfAvailability(LocalDateTime start) {
        super(start);
    }

    @Override
    public boolean isWork() {
        return isWork;
    }

    @Override
    public boolean isRest() {
        return isRest;
    }
}
