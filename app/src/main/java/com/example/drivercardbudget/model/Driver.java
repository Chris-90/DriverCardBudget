package com.example.drivercardbudget.model;

import com.example.drivercardbudget.model.budget.CalendarBased.DriverCalendarDay;
import com.example.drivercardbudget.model.budget.Classifications.DriverDrivingDay;
import com.example.drivercardbudget.model.budget.Classifications.DriverDrivingFortnight;
import com.example.drivercardbudget.model.budget.Classifications.DriverDrivingWeek;
import com.example.drivercardbudget.model.budget.Classifications.DriverWorkingDay;
import com.example.drivercardbudget.model.filemanagement.DriverFile;

import java.time.LocalDateTime;
import java.util.Map;

public class Driver {
    private String firstName;
    private String lastName;
    private Map<Integer, DriverFile> driverFiles;

    private Map<LocalDateTime, DriverCalendarDay> driverCalenderDays;

    private Map<LocalDateTime, DriverDrivingDay> driverDrivingDays;

    private Map<LocalDateTime, DriverWorkingDay> driverWorkingDays;

    private DriverDrivingDay currentWDay;
    private DriverDrivingDay restOfDay;

    private DriverDrivingWeek currentWeek;

    private DriverDrivingWeek restOfWeek;

    private DriverDrivingFortnight currentFortnightWeek;

    private DriverDrivingFortnight restOfFortnightWeek;
}
