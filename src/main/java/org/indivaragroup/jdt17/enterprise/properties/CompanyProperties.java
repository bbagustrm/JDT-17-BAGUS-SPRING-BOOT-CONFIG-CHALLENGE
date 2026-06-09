package org.indivaragroup.jdt17.enterprise.properties;

import jakarta.validation.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "company")
@Validated
public record CompanyProperties(
        @NotBlank String code,
        @NotBlank String name,
        @NotBlank String timezone
) {}