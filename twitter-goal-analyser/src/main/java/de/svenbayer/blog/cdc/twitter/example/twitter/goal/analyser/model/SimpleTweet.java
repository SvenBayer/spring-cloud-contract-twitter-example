package de.svenbayer.blog.cdc.twitter.example.twitter.goal.analyser.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class SimpleTweet {
    private Date createdAt;
    private String text;
    private List<SimpleHashTag> hashTagEntities;
}
