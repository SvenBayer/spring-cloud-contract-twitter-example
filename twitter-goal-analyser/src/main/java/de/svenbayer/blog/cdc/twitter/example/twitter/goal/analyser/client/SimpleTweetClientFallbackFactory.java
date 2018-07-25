package de.svenbayer.blog.cdc.twitter.example.twitter.goal.analyser.client;

import de.svenbayer.blog.cdc.twitter.example.twitter.goal.analyser.model.SimpleTweet;
import feign.FeignException;
import feign.hystrix.FallbackFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class SimpleTweetClientFallbackFactory implements FallbackFactory<SimpleTweetClient> {

    @Override
    public SimpleTweetClient create(Throwable throwable) {
        return new SimpleTweetClient() {
            @Override
            public ResponseEntity<List<SimpleTweet>> searchTweets(String hashtag, String lang, LocalDate since, Integer count) {
                if (throwable instanceof FeignException && ((FeignException) throwable).status() == 404) {
                    // Treat the HTTP 404 status
                }
                return null;
            }

            @Override
            public ResponseEntity<String> twitter() {
                return null;
            }

            @Override
            public ResponseEntity<String> twitterHashtag(String hashtag, String lang, LocalDate since, Integer count) {
                return new ResponseEntity<>("Could not retrieve Hashtag!", HttpStatus.INTERNAL_SERVER_ERROR);
            }

        };
    }
}
