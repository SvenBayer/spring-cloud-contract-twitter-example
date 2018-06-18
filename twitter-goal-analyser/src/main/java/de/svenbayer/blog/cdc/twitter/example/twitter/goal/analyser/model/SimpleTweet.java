package de.svenbayer.blog.cdc.twitter.example.twitter.goal.analyser.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class SimpleTweet {
    private Date createdAt;
    private String text;
    private List<SimpleHashTag> hashTagEntities;
}
