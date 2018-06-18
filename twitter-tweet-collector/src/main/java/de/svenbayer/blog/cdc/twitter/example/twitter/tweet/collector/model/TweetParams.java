package de.svenbayer.blog.cdc.twitter.example.twitter.tweet.collector.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TweetParams {

    private String hashtag;
    private String lang;
    private LocalDate since;
    private int count;

    public TweetParams(String hashtag, String lang, String since, String count) {
        this.hashtag = hashtag;
        this.lang = lang;
        this.setSince(since);
        this.setCount(count);
    }

    public void setSince(String since) {
        if (since != null) {
            this.since = LocalDate.parse(since);
        }
    }

    public void setCount(String count) {
        if (count != null) {
            this.count = Integer.parseInt(count);
        }
    }
}
