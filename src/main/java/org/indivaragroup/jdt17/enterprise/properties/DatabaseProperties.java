package org.indivaragroup.jdt17.enterprise.properties;

import jakarta.validation.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "database")
@Validated
public record DatabaseProperties(
        @NotBlank String host,
        @NotBlank String port,
        @NotBlank String username,
        @NotBlank String password
) {
}

