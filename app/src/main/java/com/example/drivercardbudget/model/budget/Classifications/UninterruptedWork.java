package com.example.drivercardbudget.model.budget.Classifications;

import com.example.drivercardbudget.model.budget.Activities.Work;

import java.time.LocalDateTime;

public class UninterruptedWork extends Work {

    public UninterruptedWork(LocalDateTime start) {
        super(start);
    }
}
