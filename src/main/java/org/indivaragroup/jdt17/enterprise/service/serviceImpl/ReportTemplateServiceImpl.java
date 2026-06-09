package org.indivaragroup.jdt17.enterprise.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.indivaragroup.jdt17.enterprise.properties.CompanyProperties;
import org.indivaragroup.jdt17.enterprise.properties.DatabaseProperties;
import org.indivaragroup.jdt17.enterprise.properties.FeatureProperties;
import org.indivaragroup.jdt17.enterprise.properties.MailProperties;
import org.indivaragroup.jdt17.enterprise.service.ReportTemplateService;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class ReportTemplateServiceImpl implements ReportTemplateService {

    private final Environment environment;

    private final ResourceLoader resourceLoader;
    private final CompanyProperties companyProperties;
    private final DatabaseProperties databaseProperties;
    private final FeatureProperties featureProperties;
    private final MailProperties mailProperties;


    @Override
    public String getReportTemplate(){
        try {

            Resource resource =
                    resourceLoader.getResource(
                            "classpath:templates/report-template.txt"
                    );

            String template =
                    resource.getContentAsString(
                            StandardCharsets.UTF_8
                    );

            return template
                    .replace("{{environment}}",  getCurrentProfile())
                    .replace("{{companyName}}",
                            companyProperties.name())
                    .replace("{{timezone}}",
                            companyProperties.timezone())
                    .replace("{{attendance}}",
                            status(featureProperties.attendance()))
                    .replace("{{directSelling}}",
                            status(featureProperties.directSelling()))
                    .replace("{{loyalty}}",
                            status(featureProperties.loyalty()))
                    .replace("{{mailEnabled}}",
                            status(mailProperties.enabled()))
                    .replace("{{dbHost}}",
                            databaseProperties.host())
                    .replace("{{dbPort}}",
                            databaseProperties.port())
                    .replace("{{dbUser}}",
                            databaseProperties.username());

        } catch (IOException e) {
            throw new RuntimeException("Failed to create report template", e);
        }
    }

    private String status(boolean enabled) {
        return enabled
                ? "ENABLED"
                : "DISABLED";
    }

    private String getCurrentProfile() {

        String[] activeProfiles = environment.getActiveProfiles();

        if (activeProfiles.length == 0) {
            return "dev";
        }

        return String.join(", ", activeProfiles);
    }
}
