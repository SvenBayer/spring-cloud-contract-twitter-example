package de.svenbayer.blog.cdc.twitter.example.twitter.tweet.collector.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class TweetParams {

    private String hashtag;
    private String lang;
    private LocalDate since;
    private int count;
}