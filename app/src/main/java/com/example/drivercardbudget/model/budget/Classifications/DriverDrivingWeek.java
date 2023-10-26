package com.example.drivercardbudget.model.budget.Classifications;

import com.example.drivercardbudget.model.budget.Activities.Driving;

import java.time.LocalDateTime;

public class DriverDrivingWeek extends Driving {

    private int used_reduced_daily_rest = 0;
    public DriverDrivingWeek(LocalDateTime start) {
        super(start);
    }
}
