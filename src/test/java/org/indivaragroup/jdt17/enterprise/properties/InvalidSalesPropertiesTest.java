package org.indivaragroup.jdt17.enterprise.properties;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class InvalidSalesPropertiesTest {

    @Test
    void shouldFailWhenMoreThan500() {

        assertThrows(
                Exception.class,
                () -> SpringApplication.run(
                        org.indivaragroup.jdt17.enterprise.Application.class,
                        "--sales.route.max-outlet-per-route=1000"
                )
        );
    }
}
