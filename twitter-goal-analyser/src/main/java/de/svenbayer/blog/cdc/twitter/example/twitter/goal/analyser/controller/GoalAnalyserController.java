package de.svenbayer.blog.cdc.twitter.example.twitter.goal.analyser.controller;

import de.svenbayer.blog.cdc.twitter.example.twitter.goal.analyser.client.SimpleTweetClient;
import de.svenbayer.blog.cdc.twitter.example.twitter.goal.analyser.model.Country;
import de.svenbayer.blog.cdc.twitter.example.twitter.goal.analyser.model.CountryGoals;
import de.svenbayer.blog.cdc.twitter.example.twitter.goal.analyser.service.CountryGoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
public class GoalAnalyserController {

    private CountryGoalService countryGoalService;
    private SimpleTweetClient simpleTweetClient;

    @Autowired
    public GoalAnalyserController(CountryGoalService countryGoalService, SimpleTweetClient simpleTweetClient) {
        this.countryGoalService = countryGoalService;
        this.simpleTweetClient = simpleTweetClient;
    }

    @GetMapping(path = "/goals/country/{country}", produces = "application/json")
    public ResponseEntity<CountryGoals> goalMentionsForCountry(@PathVariable Country country) {
        CountryGoals countryGoals = countryGoalService.goalMentionsForCountry(country);
        return new ResponseEntity<>(countryGoals, HttpStatus.OK);
    }

    @GetMapping(path = "/twitter", produces = "application/json")
    public ResponseEntity<String> twitter() {
        return simpleTweetClient.twitter();
    }

    @GetMapping(path = "/twitter/{hashtag}", produces = "application/json")
    public ResponseEntity<String> twitterHashtag(@PathVariable(value = "hashtag") String hashtag) {
        return simpleTweetClient.twitterHashtag(hashtag, "en", LocalDate.now(), 30);
    }
}
