package com.example.drivercardbudget.model.budget.Activities;

import com.example.drivercardbudget.model.budget.Abstract.ActivityBasedTimePeriod;

import java.time.LocalDateTime;

public class Unknown extends ActivityBasedTimePeriod {
    private static boolean isRest = false;
    private static boolean isWork = false;

    public Unknown(LocalDateTime start) {
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
