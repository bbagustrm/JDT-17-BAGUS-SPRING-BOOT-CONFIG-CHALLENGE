package org.indivaragroup.jdt17.enterprise.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "mail")
@Validated
public record MailProperties(
        boolean enabled,
        String host,
        String port
) {

    public MailProperties{
        if(enabled) {

            if (host == null || host.isBlank()) {
                throw new IllegalArgumentException("Mail Host is required when Mail is enabled");
            }

            if (port == null || port.isBlank()) {
                throw new IllegalArgumentException("Mail Port is required when Mail is enabled");
            }

        }
    }
}
