package com.example.drivercardbudget.model.budget.Activities;

import java.time.LocalDateTime;

public class Driving extends Work {


    private static boolean isDriving = true;
    private static boolean isWork = true;

    public Driving(LocalDateTime start) {
        super(start);
    }


    @Override
    public boolean isDriving(){
        return isDriving;
    }

    @Override
    public boolean isWork(){return isWork;}
}
