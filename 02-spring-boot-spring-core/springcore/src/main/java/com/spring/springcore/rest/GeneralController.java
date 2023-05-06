package com.spring.springcore.rest;

import com.spring.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController //@Component ve @RequestBody içerir.
public class GeneralController {

    private Coach coach;
    private  Coach anotherCoach;

//    public GeneralController(Coach theCoach) {
//        this.coach = theCoach;
//    }

    /*    //use for the setter injection
        @Autowired
        public void setCoach(Coach coach){
            mycoach = coach;
        }*/

    //for the Qualifier
    @Autowired
    public GeneralController(@Qualifier("cricketCoach") Coach thecoach,
            @Qualifier("cricketCoach") Coach theanotherCoach) {
           System.out.println("in constructor: " + getClass().getSimpleName());
           coach = thecoach;
           anotherCoach = theanotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return coach.getDailyWorkout();
    }

    @GetMapping("/check")
     public String check(){
         return "Comparşng beans: coach == anotherCoach, " + (coach == anotherCoach); //scope kontrolü
        }

}
