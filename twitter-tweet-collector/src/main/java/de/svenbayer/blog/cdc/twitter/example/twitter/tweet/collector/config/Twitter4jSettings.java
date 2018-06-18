package de.svenbayer.blog.cdc.twitter.example.twitter.tweet.collector.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import static de.svenbayer.blog.cdc.twitter.example.twitter.tweet.collector.config.Twitter4jSettings.TWITTER4J_PREFIX;

@Data
@ConfigurationProperties(prefix = TWITTER4J_PREFIX)
class Twitter4jSettings {

    static final String TWITTER4J_PREFIX = "twitter4j.oauth";

    @Value(value = "${twitter4j.debug:false}")
    private boolean debug;

    private String consumerKey;
    private String consumerSecret;
    private String accessToken;
    private String accessTokenSecret;
}
