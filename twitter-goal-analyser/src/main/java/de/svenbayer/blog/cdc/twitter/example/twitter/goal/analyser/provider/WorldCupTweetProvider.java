package de.svenbayer.blog.cdc.twitter.example.twitter.goal.analyser.provider;

import de.svenbayer.blog.cdc.twitter.example.twitter.goal.analyser.client.SimpleTweetClient;
import de.svenbayer.blog.cdc.twitter.example.twitter.goal.analyser.model.SimpleTweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class WorldCupTweetProvider {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_DATE;
    private static final ParameterizedTypeReference<List<SimpleTweet>> SIMPLE_TWEET_REFERENCE = new ParameterizedTypeReference<List<SimpleTweet>>() {};
    private static final String TWEET_COLLECTOR_URL = "http://localhost:8080/twitter-tweet-collector/tweets/search/hashtag/goal?count=100&since=";

    private SimpleTweetClient simpleTweetClient;

    @Autowired
    public WorldCupTweetProvider(SimpleTweetClient simpleTweetClient) {
        this.simpleTweetClient = simpleTweetClient;
    }

    public List<SimpleTweet> worldCupTweets() {
        String now = LocalDate.now().format(FORMATTER);
        //ResponseEntity<List<SimpleTweet>> response = simpleTweetClient.searchTweets("goal", "en", now, "100");
        ResponseEntity<List<SimpleTweet>> response = simpleTweetClient.searchTweets("goal", "en", LocalDate.now(), 100);
        if (!HttpStatus.OK.equals(response.getStatusCode())) {
            throw new IllegalStateException("Twitter Tweet Collector returned invalid response!");
        }
        return response.getBody();
    }
}
