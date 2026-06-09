package org.indivaragroup.jdt17.enterprise.module;

import lombok.RequiredArgsConstructor;
import org.indivaragroup.jdt17.enterprise.properties.*;
import org.indivaragroup.jdt17.enterprise.service.ReportTemplateService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
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
    private final ReportTemplateService reportTemplateService;

    @Bean
    ApplicationRunner startupRunner() {

        return args -> {

            System.out.println(
                    reportTemplateService
                            .getReportTemplate()
            );

        };
    }
}
