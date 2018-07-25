package de.svenbayer.blog.cdc.twitter.example.twitter.tweet.collector.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import static de.svenbayer.blog.cdc.twitter.example.twitter.tweet.collector.config.Twitter4jSettings.TWITTER4J_PREFIX;

@Validated
@Data
@ConfigurationProperties(prefix = TWITTER4J_PREFIX)
class Twitter4jSettings {

    static final String TWITTER4J_PREFIX = "twitter4j.oauth";

    @Value(value = "${twitter4j.debug:false}")
    private boolean debug;

    @NotBlank(message = "Twitter Consumer Key must be set!")
    private String consumerKey;

    @NotBlank(message = "Twitter Consumer Secret must be set!")
    private String consumerSecret;

    @NotBlank(message = "Twitter Access Token must be set!")
    private String accessToken;

    @NotBlank(message = "Twitter Accss Token Secret must be set!")
    private String accessTokenSecret;
}
