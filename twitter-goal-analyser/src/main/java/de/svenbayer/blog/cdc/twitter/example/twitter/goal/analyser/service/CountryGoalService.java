package de.svenbayer.blog.cdc.twitter.example.twitter.goal.analyser.service;

import de.svenbayer.blog.cdc.twitter.example.twitter.goal.analyser.model.Country;
import de.svenbayer.blog.cdc.twitter.example.twitter.goal.analyser.model.CountryGoals;
import de.svenbayer.blog.cdc.twitter.example.twitter.goal.analyser.model.SimpleHashTag;
import de.svenbayer.blog.cdc.twitter.example.twitter.goal.analyser.model.SimpleTweet;
import de.svenbayer.blog.cdc.twitter.example.twitter.goal.analyser.provider.WorldCupTweetProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryGoalService {

    private WorldCupTweetProvider worldCupTweetProvider;

    @Autowired
    public CountryGoalService(WorldCupTweetProvider worldCupTweetProvider) {
        this.worldCupTweetProvider = worldCupTweetProvider;
    }

    public CountryGoals goalMentionsForCountry(Country country) {
        SimpleHashTag countryHashTag = new SimpleHashTag(country.getCountry());
        List<SimpleTweet> goalTweets = worldCupTweetProvider.worldCupTweets();
        long goals = goalTweets.stream()
                .filter(tweet -> tweet.getText().contains(country.getCountry()))
                .count();
        return new CountryGoals(country, goals);
    }
}
