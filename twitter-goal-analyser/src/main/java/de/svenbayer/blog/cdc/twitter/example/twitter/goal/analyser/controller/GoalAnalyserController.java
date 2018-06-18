package de.svenbayer.blog.cdc.twitter.example.twitter.goal.analyser.controller;

import de.svenbayer.blog.cdc.twitter.example.twitter.goal.analyser.model.Country;
import de.svenbayer.blog.cdc.twitter.example.twitter.goal.analyser.model.CountryGoals;
import de.svenbayer.blog.cdc.twitter.example.twitter.goal.analyser.service.CountryGoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/twitter-goal-analyser")
public class GoalAnalyserController {

    private CountryGoalService countryGoalService;

    @Autowired
    public GoalAnalyserController(CountryGoalService countryGoalService) {
        this.countryGoalService = countryGoalService;
    }

    @GetMapping(path = "/goals/country/{country}", produces = "application/json")
    public ResponseEntity<CountryGoals> goalMentionsForCountry(@PathVariable Country country) {
        CountryGoals countryGoals = countryGoalService.goalMentionsForCountry(country);
        return new ResponseEntity<>(countryGoals, HttpStatus.OK);
    }
}
