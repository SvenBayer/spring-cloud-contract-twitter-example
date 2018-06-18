package de.svenbayer.blog.cdc.twitter.example.twitter.goal.analyser.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CountryGoals {
    private Country country;
    private long goals;
}
