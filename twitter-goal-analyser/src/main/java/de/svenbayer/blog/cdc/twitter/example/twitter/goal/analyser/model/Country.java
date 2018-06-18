package de.svenbayer.blog.cdc.twitter.example.twitter.goal.analyser.model;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Getter
public class Country {

    private static final List<String> COUNTRIES = Arrays.stream(Locale.getISOCountries())
            .map(country -> new Locale("", country))
            .map(Locale::getDisplayCountry)
            .collect(Collectors.toList());

    private String country;

    public Country(String country) {
        assert COUNTRIES.contains(country);
        this.country = country;
    }
}
