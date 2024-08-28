package com.bookstore.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomMetricsConfig {

    @Autowired
    public CustomMetricsConfig(MeterRegistry meterRegistry) {
        // Example: Custom counter metric for tracking book creation
        meterRegistry.counter("bookstore.book.creation.count");

        // Example: Custom gauge metric for tracking the number of books in the system
        meterRegistry.gauge("bookstore.book.count", bookCountSupplier());
    }

    private Number bookCountSupplier() {
        // Replace this with the actual logic to get the current number of books
        return 100;
    }
}