package org.indivaragroup.jdt17.enterprise.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "features")
public record FeatureProperties(
        boolean attendance,
        boolean directSelling,
        boolean loyalty
) {
}
