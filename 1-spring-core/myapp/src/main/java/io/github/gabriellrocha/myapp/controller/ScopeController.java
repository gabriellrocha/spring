package io.github.gabriellrocha.myapp.controller;

import io.github.gabriellrocha.myapp.domain.Coach;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScopeController {

    private final Coach coach;
    private final Coach anotherCoach;

    public ScopeController(
            @Qualifier("tennisCoach") Coach coach,
            @Qualifier("tennisCoach") Coach anotherCoach) {
        this.coach = coach;
        this.anotherCoach = anotherCoach;
    }

    @GetMapping("/check")
    public String check() {
        return "Comparing Beans: coach == anotherCoach, " + (coach == anotherCoach);
    }
}
