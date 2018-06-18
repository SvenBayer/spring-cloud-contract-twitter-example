package de.svenbayer.blog.cdc.twitter.example.twitter.goal.analyser.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = {"de.svenbayer.blog.cdc.twitter.example.twitter.goal.analyser"})
public class TwitterGoalAnalyserApplication {

    public static void main(String[] args) {
        SpringApplication.run(TwitterGoalAnalyserApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}