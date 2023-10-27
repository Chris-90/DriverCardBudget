package com.example.drivercardbudget.process.ActivityHanding;

import android.annotation.SuppressLint;

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
import com.example.drivercardbudget.model.budget.Classifications.DrivingPeriod;
import com.example.drivercardbudget.model.budget.Classifications.Shift;
import com.example.drivercardbudget.model.budget.Classifications.UninterruptedWork;

import java.util.ArrayList;
import java.util.List;

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
    private List<DrivingPeriod> previousDrivingPeriods = new ArrayList<DrivingPeriod>();
    private DrivingPeriod currentDrivingPeriod;
    private List<UninterruptedWork> previousUninterruptedWorks = new ArrayList<UninterruptedWork>();
    private UninterruptedWork currentUninterruptedWork;
    private int remainingReducedDailyRestingTimes;
    private int remainingExtendedDrivingTimes;
    private int requiredDailyRestingTime;

    private Break startedBreak;
    private DailyRestingPeriod startedRest;

    private TimeLine(){}

    public static TimeLine getInstance(Activity activity, IDrivingTimeCatalogue drivingTimeCatalogue, IWorkingTimeCatalogue defaultWorkTimeConfig){
        if(timeLine == null){
            timeLine = new TimeLine();
            timeLine.initiateTimeLine(activity, drivingTimeCatalogue, defaultWorkTimeConfig);
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

    public int getRemainingReducedDailyRestingTimes() {
        return remainingReducedDailyRestingTimes;
    }

    public void setRemainingReducedDailyRestingTimes(int remainingReducedDailyRestingTimes) {
        this.remainingReducedDailyRestingTimes = remainingReducedDailyRestingTimes;
    }

    public int getRemainingExtendedDrivingTimes() {
        return remainingExtendedDrivingTimes;
    }

    public void setRemainingExtendedDrivingTimes(int remainingExtendedDrivingTimes) {
        this.remainingExtendedDrivingTimes = remainingExtendedDrivingTimes;
    }

    public int getRequiredDailyRestingTime() {
        return requiredDailyRestingTime;
    }

    public void setRequiredDailyRestingTime(int requiredDailyRestingTime) {
        this.requiredDailyRestingTime = requiredDailyRestingTime;
    }

    public DrivingPeriod getCurrentDrivingPeriod() {
        return currentDrivingPeriod;
    }

    public void setCurrentDrivingPeriod(DrivingPeriod currentDrivingPeriod) {
        this.currentDrivingPeriod = currentDrivingPeriod;
    }

    public List<DrivingPeriod> getPreviousDrivingPeriods() {
        return previousDrivingPeriods;
    }

    public void setPreviousDrivingPeriods(List<DrivingPeriod> previousDrivingPeriods) {
        this.previousDrivingPeriods = previousDrivingPeriods;
    }

    public List<UninterruptedWork> getPreviousUninterruptedWorks() {
        return previousUninterruptedWorks;
    }

    public void setPreviousUninterruptedWorks(List<UninterruptedWork> previousUninterruptedWorks) {
        this.previousUninterruptedWorks = previousUninterruptedWorks;
    }

    public UninterruptedWork getCurrentUninterruptedWork() {
        return currentUninterruptedWork;
    }

    public void setCurrentUninterruptedWork(UninterruptedWork currentUninterruptedWork) {
        this.currentUninterruptedWork = currentUninterruptedWork;
    }

    @SuppressLint("NewApi")
    private void initiateTimeLine(Activity activity, IDrivingTimeCatalogue drivingTimeCatalogue, IWorkingTimeCatalogue defaultWorkTimeConfig){
        this.currentCalendarDay = new DriverCalendarDay(activity.getStart().toLocalDate());
        this.currentCalendarWeek = new DriverCalendarWeek(activity.getStart().toLocalDate());
        this.currentDrivingDay = new DriverDrivingDay(activity.getStart());
        this.currentDrivingWeek = new DriverDrivingWeek(activity.getStart());
        this.currentDrivingFortnight = new DriverDrivingFortnight(activity.getStart());
        this.currentWorkingDay = new DriverWorkingDay(activity.getStart());
        this.currentWorkingWeek = new DriverWorkingWeek(activity.getStart());
        this.remainingExtendedDrivingTimes = drivingTimeCatalogue.getMaxExtendedDailyDrivingTimes();
        this.remainingReducedDailyRestingTimes = drivingTimeCatalogue.getMaxReducedDailyRests();
        this.requiredDailyRestingTime = drivingTimeCatalogue.getReducedDailyRestingTime();
    }


}
