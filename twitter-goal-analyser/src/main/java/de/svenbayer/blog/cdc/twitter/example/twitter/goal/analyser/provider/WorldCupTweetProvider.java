package de.svenbayer.blog.cdc.twitter.example.twitter.goal.analyser.provider;

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

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_DATE;
    private static final ParameterizedTypeReference<List<SimpleTweet>> SIMPLE_TWEET_REFERENCE = new ParameterizedTypeReference<List<SimpleTweet>>() {
    };
    private static final String TWEET_COLLECTOR_URL = "http://localhost:8080/twitter-tweet-collector/tweets/search/hashtag/goal?count=100&since=";

    private RestTemplate restTemplate;

    @Autowired
    public WorldCupTweetProvider(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<SimpleTweet> worldCupTweets() {
        URI url = null;
        try {
            url = new URI(TWEET_COLLECTOR_URL + LocalDate.now().format(FORMATTER));
        } catch (URISyntaxException e) {
            throw new IllegalStateException(e);
        }
        ResponseEntity<List<SimpleTweet>> response = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, SIMPLE_TWEET_REFERENCE);
        if (!HttpStatus.OK.equals(response.getStatusCode())) {
            throw new IllegalStateException("Twitter Tweet Collector returned invalid response!");
        }
        return response.getBody();
    }
}
