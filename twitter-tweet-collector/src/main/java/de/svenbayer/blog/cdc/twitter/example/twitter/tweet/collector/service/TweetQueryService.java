package de.svenbayer.blog.cdc.twitter.example.twitter.tweet.collector.service;

import de.svenbayer.blog.cdc.twitter.example.twitter.tweet.collector.model.SimpleTweet;
import de.svenbayer.blog.cdc.twitter.example.twitter.tweet.collector.model.TweetParams;
import de.svenbayer.blog.cdc.twitter.example.twitter.tweet.collector.provider.TweetQueryProvider;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.Status;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TweetQueryService {

    private TweetQueryProvider tweetQueryProvider;
    private ModelMapper modelMapper;

    @Autowired
    public TweetQueryService(TweetQueryProvider tweetQueryProvider, ModelMapper modelMapper) {
        this.tweetQueryProvider = tweetQueryProvider;
        this.modelMapper = modelMapper;
    }

    public List<SimpleTweet> searchTweets(TweetParams tweetParams) {
        List<Status> tweets = tweetQueryProvider.searchTweets(tweetParams);
        return tweets.stream()
                .map(tweet -> modelMapper.map(tweet, SimpleTweet.class))
                .collect(Collectors.toList());
    }
}
