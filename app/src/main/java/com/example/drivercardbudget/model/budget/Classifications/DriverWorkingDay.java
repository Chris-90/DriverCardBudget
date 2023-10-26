package com.example.drivercardbudget.model.budget.Classifications;

import com.example.drivercardbudget.model.budget.Activities.Work;

import java.time.LocalDateTime;

public class DriverWorkingDay extends Work {

    public DriverWorkingDay(LocalDateTime start) {
        super(start);
    }
}
