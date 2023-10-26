package com.example.drivercardbudget.model.budget.Abstract;

import android.os.Build;
import android.os.Build.VERSION_CODES;

import androidx.annotation.RequiresApi;

import com.example.drivercardbudget.model.budget.Interfaces.ITimePeriod;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public abstract class TimePeriod implements ITimePeriod {

    private LocalDateTime start;
    private LocalDateTime end;

    @Override
    public LocalDateTime getStart() {
        return this.start;
    }

    @Override
    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    @Override
    @RequiresApi(api = VERSION_CODES.O)
    public void setStart(LocalDate start) {
        this.start = LocalDateTime.of(start, LocalTime.MIN);
    }


    @RequiresApi(api = VERSION_CODES.O)
    public void setStart(LocalDate startDate, LocalTime startTime) {
        this.start = LocalDateTime.of(startDate, startTime);
    }

    @Override
    public LocalDateTime getEnd() {
        return this.end;
    }

    @RequiresApi(api = VERSION_CODES.O)
    public void setEnd(LocalDate endDate, LocalTime endTime){
        this.end = LocalDateTime.of(endDate, endTime);
    }

    @Override
    public void setEnd(LocalDateTime end) {
        this.end = end;
    }


}
