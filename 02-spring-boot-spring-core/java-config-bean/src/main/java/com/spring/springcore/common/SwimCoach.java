package com.spring.springcore.common;

import org.springframework.stereotype.Component;

public class SwimCoach implements Coach {

    public SwimCoach(){
        System.out.println("in constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "swim 1000 meters as a warm up";
    }
}
