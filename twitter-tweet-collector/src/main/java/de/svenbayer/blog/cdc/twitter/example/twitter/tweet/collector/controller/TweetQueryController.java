package de.svenbayer.blog.cdc.twitter.example.twitter.tweet.collector.controller;

import de.svenbayer.blog.cdc.twitter.example.twitter.tweet.collector.model.SimpleTweet;
import de.svenbayer.blog.cdc.twitter.example.twitter.tweet.collector.model.TweetParams;
import de.svenbayer.blog.cdc.twitter.example.twitter.tweet.collector.service.TweetQueryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = "/twitter-tweet-collector")
public class TweetQueryController {

    private TweetQueryService tweetQueryService;

    public TweetQueryController(TweetQueryService tweetQueryService) {
        this.tweetQueryService = tweetQueryService;
    }

    @GetMapping(path = "/tweets/search/hashtag/{hashtag}", produces = "application/json")
    public ResponseEntity<List<SimpleTweet>> searchTweets(@PathVariable String hashtag,
                                                          @PathParam("lang") String lang,
                                                          @PathParam("since") String since,
                                                          @PathParam("count") String count) {
        TweetParams tweetParams = new TweetParams(hashtag, lang, since, count);
        List<SimpleTweet> simpleTweets = tweetQueryService.searchTweets(tweetParams);
        return new ResponseEntity<>(simpleTweets, HttpStatus.OK);
    }
}
