package com.example.drivercardbudget.model.budget.CalendarBased;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.drivercardbudget.model.budget.Classifications.Shift;
import com.example.drivercardbudget.model.budget.Abstract.TimePeriod;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class DriverCalendarDay extends TimePeriod {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void setStart(LocalDate start) {
        super.setStart(start, LocalTime.MIN);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void setEnd(LocalDate end){
        super.setEnd(end, LocalTime.MAX);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void setStartAndEnd(LocalDate start){
        super.setStart(start, LocalTime.MIN);
        super.setEnd(start, LocalTime.MAX);
    }

    private Map<LocalTime, Shift> shifts = new HashMap<>();
    DriverCalendarDay(LocalDateTime start, LocalDateTime end){
        setStart(start);
        setEnd(end);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public DriverCalendarDay(LocalDate date){
        setStart(LocalDateTime.of(date, LocalTime.MIN));
        setEnd(LocalDateTime.of(date, LocalTime.MAX));
    }
}
