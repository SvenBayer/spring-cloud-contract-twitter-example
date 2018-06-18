package de.svenbayer.blog.cdc.twitter.example.twitter.tweet.collector.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.util.Objects;

@Configuration
@EnableConfigurationProperties(Twitter4jSettings.class)
public class Twitter4jConfiguration {

    @Bean
    public TwitterFactory twitterFactory(Twitter4jSettings settings) {
        Objects.requireNonNull(settings.getAccessToken(), "Access Token was null");
        Objects.requireNonNull(settings.getAccessTokenSecret(), "Access Token Secret was null");
        Objects.requireNonNull(settings.getConsumerKey(), "Consumer Key was null");
        Objects.requireNonNull(settings.getConsumerSecret(), "Consumer Secret was null");

        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.setDebugEnabled(settings.isDebug())
                .setOAuthAccessToken(settings.getAccessToken())
                .setOAuthAccessTokenSecret(settings.getAccessTokenSecret())
                .setOAuthConsumerKey(settings.getConsumerKey())
                .setOAuthConsumerSecret(settings.getConsumerSecret());

        return new TwitterFactory(builder.build());
    }

    @Bean
    public Twitter twitter(TwitterFactory twitterFactory) {
        return twitterFactory.getInstance();
    }
}
