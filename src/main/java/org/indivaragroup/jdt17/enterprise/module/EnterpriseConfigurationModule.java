package org.indivaragroup.jdt17.enterprise.module;

import lombok.RequiredArgsConstructor;
import org.indivaragroup.jdt17.enterprise.properties.*;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties({
        CompanyProperties.class,
        DatabaseProperties.class,
        FeatureProperties.class,
        MailProperties.class,
        SalesProperties.class
})
public class EnterpriseConfigurationModule {

}
