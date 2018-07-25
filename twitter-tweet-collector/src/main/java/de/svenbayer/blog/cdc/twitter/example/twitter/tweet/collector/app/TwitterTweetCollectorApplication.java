package de.svenbayer.blog.cdc.twitter.example.twitter.tweet.collector.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = {"de.svenbayer.blog.cdc.twitter.example.twitter.tweet.collector"})
public class TwitterTweetCollectorApplication {

    public static void main(String[] args) {
        SpringApplication.run(TwitterTweetCollectorApplication.class, args);
    }
}