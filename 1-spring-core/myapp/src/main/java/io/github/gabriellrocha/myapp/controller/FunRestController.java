package io.github.gabriellrocha.myapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

//    inject properties for: coach.name
    @Value("${coach.name}")
    private String coachName;

    @Value("${dev.name}")
    private String devName;

    @GetMapping("/coach")
    public String getCoachName() {
        return coachName;
    }

    @GetMapping("/")
    public String sayHello() {
        return String.format("<h1>Hello, %s!</h1>", devName);
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "<h1>workout</h1>";
    }
}
