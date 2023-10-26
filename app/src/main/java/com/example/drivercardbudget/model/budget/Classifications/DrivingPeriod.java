package com.example.drivercardbudget.model.budget.Classifications;

import com.example.drivercardbudget.model.budget.Activities.Driving;

import java.time.LocalDateTime;

public class DrivingPeriod extends Driving{
    public DrivingPeriod(LocalDateTime start) {
        super(start);
    }
}
