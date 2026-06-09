package org.indivaragroup.jdt17.enterprise.properties;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "sales.route")
@Validated
public record SalesProperties(

        @Min(
                value = 50,
                message = "Minimum outlet per route is 50"
        )

        @Max(
                value = 500,
                message = "Maximum outlet per route is 500"
        )

        Integer maxOutletPerRoute

) { }