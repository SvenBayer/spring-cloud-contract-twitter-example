package de.svenbayer.blog.cdc.twitter.example.twitter.tweet.collector.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import javax.validation.Valid;
import java.util.Objects;

@Configuration
@EnableConfigurationProperties(Twitter4jSettings.class)
public class Twitter4jConfiguration {

    @Bean
    public TwitterFactory twitterFactory(Twitter4jSettings settings) {
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
