package io.github.gabriellrocha.myapp.controller;

import io.github.gabriellrocha.myapp.domain.Coach;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigBeanController {

    private final Coach coach;

    public ConfigBeanController(@Qualifier("swimCoach") Coach coach) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        this.coach = coach;
    }

    @GetMapping("/swim-coach")
    public String swimCoach() {
        return coach.getDailyWorkout();
    }
}
