package com.spring.springcore.rest;

import com.spring.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //@Component ve @RequestBody içerir.
public class GeneralController {

    private Coach coach;

    //for the Qualifier
    @Autowired
    public GeneralController(@Qualifier("swimCoach") Coach thecoach) {
           System.out.println("in constructor: " + getClass().getSimpleName());
           coach = thecoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return coach.getDailyWorkout();
    }


}
