package com.example.drivercardbudget.model.budget.CalendarBased;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.drivercardbudget.model.budget.Abstract.TimePeriod;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class DriverCalendarWeek extends TimePeriod {

    @RequiresApi(api = Build.VERSION_CODES.O)
    public DriverCalendarWeek(LocalDate startDay){
        setStart(startDay);
        setEnd(startDay.plusDays(7), LocalTime.MAX);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void setStart(LocalDate start){
        super.setStart(start, LocalTime.MIN);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void setStartAndEnd(LocalDate start){
        super.setStart(start, LocalTime.MIN);
        super.setEnd(start.plusDays(7), LocalTime.MAX);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void setEnd(LocalDate end){
        super.setEnd(end, LocalTime.MAX);
    }

    public static Map<Integer, Map<Integer, DriverCalendarWeek>> calenderWeeks;
    private int year;
    private int calendarWeek;

    public DriverCalendarWeek() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            this.year =  LocalDateTime.now().getYear();
        } else {
            this.year = Calendar.YEAR;
        }
        this.calendarWeek = Calendar.WEEK_OF_YEAR;
        add(this.year, this.calendarWeek, this);
    }

    private static void add(int year, int calendarWeek, DriverCalendarWeek object){
        Map<Integer, DriverCalendarWeek> currentCalendarWeek = new HashMap<Integer, DriverCalendarWeek>(){{
            put(calendarWeek, object);
        }};
        if(DriverCalendarWeek.calenderWeeks == null){
            DriverCalendarWeek.calenderWeeks = new HashMap<Integer, Map<Integer, DriverCalendarWeek>>(){{
                put(year, currentCalendarWeek);
            }};
        } else {
            DriverCalendarWeek.calenderWeeks.put(year, currentCalendarWeek);
        }
    }

    public DriverCalendarWeek(int week, int year) {
        this.calendarWeek = week;
        this.year = year;
    }

    public int getCalendarWeek() {
        return calendarWeek;
    }

    public int getYear() {
        return year;
    }
}
