package com.example.drivercardbudget.process.ActivityHanding;

import android.annotation.SuppressLint;

import com.example.drivercardbudget.configuration.DefaultDrivingTimeCatalogue;
import com.example.drivercardbudget.configuration.DefaultWorkTimeConfig;
import com.example.drivercardbudget.configuration.Interfaces.IDrivingTimeCatalogue;
import com.example.drivercardbudget.configuration.Interfaces.IWorkingTimeCatalogue;
import com.example.drivercardbudget.model.budget.Activities.Activity;
import com.example.drivercardbudget.model.budget.CalendarBased.DriverCalendarDay;
import com.example.drivercardbudget.model.budget.CalendarBased.DriverCalendarWeek;
import com.example.drivercardbudget.model.budget.Classifications.Break;
import com.example.drivercardbudget.model.budget.Classifications.DailyRestingPeriod;
import com.example.drivercardbudget.model.budget.Classifications.DriverDrivingDay;
import com.example.drivercardbudget.model.budget.Classifications.DriverDrivingFortnight;
import com.example.drivercardbudget.model.budget.Classifications.DriverDrivingWeek;
import com.example.drivercardbudget.model.budget.Classifications.DriverWorkingDay;
import com.example.drivercardbudget.model.budget.Classifications.DriverWorkingWeek;
import com.example.drivercardbudget.model.budget.Classifications.Shift;

/**
 * Datenhaltungs-Container, keine Verarbeitung
 * Verarbeitung: ActivityProcessor
 */
public class TimeLine {
    private static TimeLine timeLine = null;
    private IDrivingTimeCatalogue selectedDrivingTimeCatalogue;
    private IWorkingTimeCatalogue selectedWorkingTimeCatalogue;
    private boolean isFirstActivity = true;
    private Shift currentShift;
    private DriverCalendarDay currentCalendarDay;
    private DriverCalendarWeek currentCalendarWeek;
    private DriverDrivingDay currentDrivingDay;
    private DriverDrivingWeek currentDrivingWeek;
    private DriverDrivingFortnight currentDrivingFortnight;
    private DriverWorkingDay currentWorkingDay;
    private DriverWorkingWeek currentWorkingWeek;
    private Break startedBreak;
    private DailyRestingPeriod startedRest;

    private TimeLine(){}

    public static TimeLine getInstance(Activity activity, DefaultDrivingTimeCatalogue drivingTimeCatalogue, DefaultWorkTimeConfig defaultWorkTimeConfig){
        if(timeLine == null){
            timeLine = new TimeLine();
            timeLine.initiateTimeLine(activity);
        }
        return timeLine;
    }

    public Shift getCurrentShift() {
        return currentShift;
    }

    public void setCurrentShift(Shift currentShift) {
        this.currentShift = currentShift;
    }

    public DriverCalendarDay getCurrentCalendarDay() {
        return currentCalendarDay;
    }

    public void setCurrentCalendarDay(DriverCalendarDay currentCalendarDay) {
        this.currentCalendarDay = currentCalendarDay;
    }

    public DriverCalendarWeek getCurrentCalendarWeek() {
        return currentCalendarWeek;
    }

    public void setCurrentCalendarWeek(DriverCalendarWeek currentCalendarWeek) {
        this.currentCalendarWeek = currentCalendarWeek;
    }

    public DriverDrivingDay getCurrentDrivingDay() {
        return currentDrivingDay;
    }

    public void setCurrentDrivingDay(DriverDrivingDay currentDrivingDay) {
        this.currentDrivingDay = currentDrivingDay;
    }

    public DriverDrivingWeek getCurrentDrivingWeek() {
        return currentDrivingWeek;
    }

    public void setCurrentDrivingWeek(DriverDrivingWeek currentDrivingWeek) {
        this.currentDrivingWeek = currentDrivingWeek;
    }

    public DriverDrivingFortnight getCurrentDrivingFortnight() {
        return currentDrivingFortnight;
    }

    public void setCurrentDrivingFortnight(DriverDrivingFortnight currentDrivingFortnight) {
        this.currentDrivingFortnight = currentDrivingFortnight;
    }

    public DriverWorkingDay getCurrentWorkingDay() {
        return currentWorkingDay;
    }

    public void setCurrentWorkingDay(DriverWorkingDay currentWorkingDay) {
        this.currentWorkingDay = currentWorkingDay;
    }

    public DriverWorkingWeek getCurrentWorkingWeek() {
        return currentWorkingWeek;
    }

    public void setCurrentWorkingWeek(DriverWorkingWeek currentWorkingWeek) {
        this.currentWorkingWeek = currentWorkingWeek;
    }

    public Break getStartedBreak() {
        return startedBreak;
    }

    public void setStartedBreak(Break startedBreak) {
        this.startedBreak = startedBreak;
    }

    public DailyRestingPeriod getStartedRest() {
        return startedRest;
    }

    public void setStartedRest(DailyRestingPeriod startedRest) {
        this.startedRest = startedRest;
    }

    @SuppressLint("NewApi")
    private void initiateTimeLine(Activity activity){
        this.currentCalendarDay = new DriverCalendarDay(activity.getStart().toLocalDate());
        this.currentCalendarWeek = new DriverCalendarWeek(activity.getStart().toLocalDate());
        this.currentDrivingDay = new DriverDrivingDay(activity.getStart());
        this.currentDrivingWeek = new DriverDrivingWeek(activity.getStart());
        this.currentDrivingFortnight = new DriverDrivingFortnight(activity.getStart());
        this.currentWorkingDay = new DriverWorkingDay(activity.getStart());
        this.currentWorkingWeek = new DriverWorkingWeek(activity.getStart());
    }
}
