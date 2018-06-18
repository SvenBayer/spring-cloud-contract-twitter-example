package de.svenbayer.blog.cdc.twitter.example.twitter.tweet.collector.service;

import de.svenbayer.blog.cdc.twitter.example.twitter.tweet.collector.model.SimpleTweet;
import de.svenbayer.blog.cdc.twitter.example.twitter.tweet.collector.model.TweetParams;
import de.svenbayer.blog.cdc.twitter.example.twitter.tweet.collector.provider.TweetQueryProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import twitter4j.Status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TweetQueryServiceTest {

    @Mock
    private TweetQueryProvider tweetQueryProvider;

    @Mock
    private Status status;

    @Spy
    private ModelMapper modelMapper = new ModelMapper();

    @InjectMocks
    private TweetQueryService tweetQueryService;

    @Test
    void searchTweets() {
        TweetParams tweetParams = new TweetParams("bitcoin", "en", "2018-06-17", "30");

        ArrayList<Status> statusTweets = new ArrayList<>();
        statusTweets.add(status);

        Date date = new Date();
        when(status.getCreatedAt()).thenReturn(date);

        String tweetText = "Spring Cloud Contract is cool! #springboot #java";
        when(status.getText()).thenReturn(tweetText);

        when(tweetQueryProvider.searchTweets(tweetParams)).thenReturn(statusTweets);

        List<SimpleTweet> expectedTweets = new ArrayList<>();
        SimpleTweet simpleTweet = new SimpleTweet();
        simpleTweet.setCreatedAt(date);
        simpleTweet.setText(tweetText);
        expectedTweets.add(simpleTweet);

        List<SimpleTweet> actualTweets = tweetQueryService.searchTweets(tweetParams);
        assertEquals(expectedTweets, actualTweets);
    }
}