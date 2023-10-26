package com.example.drivercardbudget.model.budget.Interfaces;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface ITimePeriod {

    public LocalDateTime getStart();
    public void setStart(LocalDateTime start);

    @RequiresApi(api = Build.VERSION_CODES.O)
    void setStart(LocalDate start);

    public LocalDateTime getEnd();
    public void setEnd(LocalDateTime end);

    @RequiresApi(api = Build.VERSION_CODES.O)
    default boolean isTimePeriodInside(ITimePeriod ITimePeriod){
        if(getStart().isBefore(ITimePeriod.getStart()) && getEnd().isAfter(ITimePeriod.getEnd())){
                return true;
        }
        return false;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    default boolean isLocalDateTimeInside(LocalDateTime date){
        if(getStart().isBefore(date) && getEnd().isAfter(date)){
            return true;
        }
        return false;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    default boolean isTimePeriodBefore(ITimePeriod ITimePeriod){
        if(ITimePeriod.getEnd().isBefore(getStart())){
            return true;
        }
        return false;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    default boolean isLocalDateTimeBefore(LocalDateTime date){
        if(date.isBefore(getStart())){
            return true;
        }
        return false;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    default boolean isTimePeriodConnected(ITimePeriod ITimePeriod){
        // beginnt vorher und endet während dessen
        if(ITimePeriod.getStart().isBefore(getStart())
                && ITimePeriod.getEnd().isAfter(getStart())
                && ITimePeriod.getEnd().isBefore(getEnd())){
            return true;
        }
        // beginnt während dessen und endet danach
        if(ITimePeriod.getEnd().isAfter(getEnd())
                && ITimePeriod.getStart().isAfter(getStart())
                && ITimePeriod.getStart().isBefore(getEnd())){
            return true;
        }
        return false;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    default boolean isTimePeriodUnrelated(ITimePeriod ITimePeriod){
        if(ITimePeriod.getEnd().isBefore(getStart())){
            return true;
        }
        return false;
    }
}
