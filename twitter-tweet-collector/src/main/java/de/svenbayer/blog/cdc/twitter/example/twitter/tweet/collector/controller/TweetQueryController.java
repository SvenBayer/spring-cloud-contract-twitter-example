package de.svenbayer.blog.cdc.twitter.example.twitter.tweet.collector.controller;

import de.svenbayer.blog.cdc.twitter.example.twitter.tweet.collector.model.SimpleTweet;
import de.svenbayer.blog.cdc.twitter.example.twitter.tweet.collector.model.TweetParams;
import de.svenbayer.blog.cdc.twitter.example.twitter.tweet.collector.service.TweetQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.format.annotation.DateTimeFormat.ISO;

@Validated
@RestController
public class TweetQueryController {

    private TweetQueryService tweetQueryService;

    @Autowired
    public TweetQueryController(TweetQueryService tweetQueryService) {
        this.tweetQueryService = tweetQueryService;
    }

    @GetMapping(path = "/tweets/search/hashtag/{hashtag}", produces = "application/json")
    public ResponseEntity<List<SimpleTweet>> searchTweets(@NotNull @PathVariable
                                                                  String hashtag,
                                                          @RequestParam(value = "lang", required = false)
                                                          @Pattern(regexp = "[a-z]{2}")
                                                                  String lang,
                                                          @RequestParam(required = false)
                                                          @DateTimeFormat(iso = ISO.DATE)
                                                                  LocalDate since,
                                                          @RequestParam(required = false, defaultValue = "15")
                                                          @Min(1) @Max(100)
                                                          @NumberFormat(style = NumberFormat.Style.NUMBER)
                                                                  Integer count) {
        TweetParams tweetParams = new TweetParams(hashtag, lang, since, count);
        List<SimpleTweet> simpleTweets = tweetQueryService.searchTweets(tweetParams);
        return new ResponseEntity<>(simpleTweets, HttpStatus.OK);
    }

    @GetMapping(path = "/twitter", produces = "application/json")
    public ResponseEntity<String> twitter() {
        return new ResponseEntity<>("Twitter!", HttpStatus.OK);
    }

    @GetMapping(path = "/twitter/{hashtag}", produces = "application/json")
    public ResponseEntity<String> twitterHashtag(@NotNull @PathVariable
                                                             String hashtag,
                                                 @RequestParam(value = "lang", required = false)
                                                     @Pattern(regexp = "[a-z]{2}")
                                                             String lang,
                                                 @RequestParam(required = false)
                                                     @DateTimeFormat(iso = ISO.DATE)
                                                             LocalDate since,
                                                 @RequestParam(required = false, defaultValue = "15")
                                                     @Min(1) @Max(100)
                                                     @NumberFormat(style = NumberFormat.Style.NUMBER)
                                                             Integer count) {
        return new ResponseEntity<>("Twitter Hashtag " + hashtag + " for language: " + lang
                + " since: " + since + " count: " + count, HttpStatus.OK);
    }
}
