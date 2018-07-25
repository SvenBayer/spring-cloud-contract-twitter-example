package de.svenbayer.blog.cdc.twitter.example.twitter.goal.analyser.app;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
@ConfigurationPropertiesBinding
public final class LocalDateConverter implements Converter<String, LocalDate> {

    private final DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;

    @Override
    public LocalDate convert(String dateToFormat) {
        if (dateToFormat == null || dateToFormat.isEmpty()) {
            return null;
        }

        return LocalDate.parse(dateToFormat, formatter);
    }
}
