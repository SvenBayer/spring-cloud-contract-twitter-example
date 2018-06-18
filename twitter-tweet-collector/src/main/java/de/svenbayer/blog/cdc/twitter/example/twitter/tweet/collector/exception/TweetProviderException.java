package de.svenbayer.blog.cdc.twitter.example.twitter.tweet.collector.exception;

import de.svenbayer.blog.cdc.twitter.example.twitter.tweet.collector.model.TweetParams;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TweetProviderException extends RuntimeException {

    private TweetParams tweetParams;

    public TweetProviderException(String message, Throwable cause, TweetParams tweetParams) {
        super(message, cause);
        this.tweetParams = tweetParams;
    }
}

