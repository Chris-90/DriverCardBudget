package com.example.drivercardbudget.model.budget.Activities;

import com.example.drivercardbudget.model.budget.Abstract.ActivityBasedTimePeriod;

import java.time.LocalDateTime;

public class Work extends ActivityBasedTimePeriod {

    private int totalValue = 0;

    private static boolean isWork = true;

    public Work(LocalDateTime start) {
        super(start);
    }

    @Override
    public boolean isWork() {
        return isWork;
    }
}
