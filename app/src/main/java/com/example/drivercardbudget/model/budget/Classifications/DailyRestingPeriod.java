package com.example.drivercardbudget.model.budget.Classifications;

import com.example.drivercardbudget.model.budget.Activities.Driving;
import com.example.drivercardbudget.model.budget.Activities.Rest;

import java.time.LocalDateTime;

public class DailyRestingPeriod extends Break{
    public DailyRestingPeriod(LocalDateTime start) {
        super(start);
    }

    @Override
    public boolean isDailyRest() {
        return true;
    }
}
