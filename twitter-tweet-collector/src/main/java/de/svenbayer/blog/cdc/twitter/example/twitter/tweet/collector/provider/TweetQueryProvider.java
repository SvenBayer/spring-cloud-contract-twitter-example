package de.svenbayer.blog.cdc.twitter.example.twitter.tweet.collector.provider;

import de.svenbayer.blog.cdc.twitter.example.twitter.tweet.collector.exception.TweetProviderException;
import de.svenbayer.blog.cdc.twitter.example.twitter.tweet.collector.model.TweetParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.*;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TweetQueryProvider {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_DATE;

    private Twitter twitter;

    @Autowired
    public TweetQueryProvider(Twitter twitter) {
        this.twitter = twitter;
    }

    public List<Status> searchTweets(TweetParams tweetParams) {
        Query query = new Query();
        if (tweetParams.getHashtag() != null) {
            query.setQuery("#" + tweetParams.getHashtag());
        }
        if (tweetParams.getLang() != null) {
            query.setLang(tweetParams.getLang());
        }
        if (tweetParams.getSince() != null) {
            query.setSince(FORMATTER.format(tweetParams.getSince()));
        }
        query.setCount(tweetParams.getCount());
        QueryResult result;
        try {
            result = twitter.search(query);
        } catch (TwitterException e) {
            throw new TweetProviderException("Could not search Tweets for query!", e, tweetParams);
        }
        return result.getTweets();
    }
}
