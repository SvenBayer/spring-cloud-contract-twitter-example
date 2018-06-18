package de.svenbayer.blog.cdc.twitter.example.twitter.tweet.collector.model;

import lombok.Data;

import java.util.Date;

@Data
public class SimpleTweet {
    private Date createdAt;
    private String text;
    private SimpleHashTag[] hashTagEntities;
}
