package de.svenbayer.blog.cdc.twitter.example.twitter.goal.analyser.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@EnableCircuitBreaker
@EnableFeignClients(basePackages = {"de.svenbayer.blog.cdc.twitter.example.twitter.goal.analyser.client"})
@EnableEurekaClient
@SpringBootApplication(scanBasePackages = {"de.svenbayer.blog.cdc.twitter.example.twitter.goal.analyser"})
@ComponentScan(basePackages = {"de.svenbayer.blog.cdc.twitter.example.twitter.goal.analyser"})
public class TwitterGoalAnalyserApplication {

    public static void main(String[] args) {
        SpringApplication.run(TwitterGoalAnalyserApplication.class, args);
    }
}