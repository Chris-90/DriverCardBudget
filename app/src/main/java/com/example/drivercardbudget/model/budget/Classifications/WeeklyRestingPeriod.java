package com.example.drivercardbudget.model.budget.Classifications;

import java.time.LocalDateTime;

public class WeeklyRestingPeriod extends DailyRestingPeriod {
    public WeeklyRestingPeriod(LocalDateTime start) {
        super(start);
    }

    @Override
    public boolean isWeeklyRest() {
        return true;
    }
}
