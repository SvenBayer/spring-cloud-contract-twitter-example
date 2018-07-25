package de.svenbayer.blog.cdc.twitter.example.twitter.tweet.collector.provider;

import de.svenbayer.blog.cdc.twitter.example.twitter.tweet.collector.model.TweetParams;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import twitter4j.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TweetParamsProviderTest {

    @Mock
    private Twitter twitter;

    @Mock
    private QueryResult queryResult;

    @InjectMocks
    private TweetQueryProvider provider;

    @DisplayName("Searching Tweets")
    @Test
    void searchTweets() throws TwitterException {
        Query query = new Query();
        query.setQuery("#bitcoin");
        query.setLang("en");
        String sinceDate = "2018-06-17";
        query.setSince(sinceDate);
        query.setCount(30);

        when(twitter.search(eq(query))).thenReturn(queryResult);
        ArrayList<Status> expectedResult = new ArrayList<>();
        when(queryResult.getTweets()).thenReturn(expectedResult);
/*
        TweetParams tweetParams = new TweetParams("bitcoin", "en", sinceDate, "30");
        List<Status> actualTweets = provider.searchTweets(tweetParams);
        assertSame(expectedResult, actualTweets);*/
    }
}