package com.example.drivercardbudget.model.budget.Classifications;

import com.example.drivercardbudget.model.budget.Activities.Rest;

import java.time.LocalDateTime;

public class Break extends Rest {
    public Break(LocalDateTime start) {
        super(start);
    }

    @Override
    public boolean isBreak() {
        return true;
    }
}
