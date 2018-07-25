package de.svenbayer.blog.cdc.twitter.example.twitter.goal.analyser.client;

import de.svenbayer.blog.cdc.twitter.example.twitter.goal.analyser.model.SimpleTweet;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@FeignClient("twitter-tweet-collector")//, fallbackFactory = SimpleTweetClientFallbackFactory.class)
public interface SimpleTweetClient {

    @GetMapping("/tweets/search/hashtag/{hashtag}")
    ResponseEntity<List<SimpleTweet>> searchTweets(@RequestParam(value = "hashtag") String hashtag,
                                                   @PathVariable(value = "lang")  String lang,
                                   @PathVariable(value = "since") LocalDate since,
                                   @PathVariable(value = "count") Integer count);

    @GetMapping(path = "/twitter")
    ResponseEntity<String> twitter();

    @GetMapping(path = "/twitter/{hashtag}")
    ResponseEntity<String> twitterHashtag(@PathVariable(value = "hashtag") String hashtag,
                                          @RequestParam("lang")
                                                  String lang,
                                          @RequestParam("since")
                                                  LocalDate since,
                                          @RequestParam("count")
                                                  Integer count);
}
