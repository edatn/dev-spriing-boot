package com.spring.springcore.rest;

import com.spring.springcore.common.Coach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //@Component ve @RequestBody içerir.
public class BeanLifecycleGeneralController {

    private Coach coach;

    //define for init
    @PostConstruct
    public void initstart(){
        System.out.println("in PostConstruct: " + getClass().getSimpleName());
    }

    //define for cleanup
    @PreDestroy
    public void initDelete(){

    }

    //for the Qualifier
    @Autowired
    public BeanLifecycleGeneralController(@Qualifier("cricketCoach") Coach thecoach) {
           System.out.println("in constructor: " + getClass().getSimpleName());
           coach = thecoach;
    }

//    @GetMapping("/dailyworkout")
//    public String getDailyWorkout(){
//        return coach.getDailyWorkout();
//    }



}
