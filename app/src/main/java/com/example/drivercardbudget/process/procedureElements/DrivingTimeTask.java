package com.example.drivercardbudget.process.procedureElements;

public class DrivingTimeTask{
    private ITask task;
    DrivingTimeTask(EBreakTask task){
        this.task = task;
    }
    public ITask getTask() {
        return task;
    }
}
