package com.example.drivercardbudget.model.budget.Activities;

import com.example.drivercardbudget.model.budget.Abstract.ActivityBasedTimePeriod;

import java.time.LocalDateTime;

public class Activity extends ActivityBasedTimePeriod {
    public Activity(LocalDateTime start) {
        super(start);
    }
}
