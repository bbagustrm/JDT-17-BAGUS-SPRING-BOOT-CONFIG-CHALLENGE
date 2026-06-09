package org.indivaragroup.jdt17.enterprise.service.serviceImpl;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
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
import java.text.MessageFormat;

@Service
@RequiredArgsConstructor
@Getter
public class ReportTemplateServiceImpl implements ReportTemplateService {

    private final Environment environment;
    private final ResourceLoader resourceLoader;

    private final CompanyProperties companyProperties;
    private final DatabaseProperties databaseProperties;
    private final FeatureProperties featureProperties;
    private final MailProperties mailProperties;

    private String template;

    @PostConstruct
    public void init() throws IOException {

        Resource resource =
                resourceLoader.getResource(
                        "classpath:templates/report-template.txt");

        String reportTemplate =
                resource.getContentAsString(StandardCharsets.UTF_8);

        this.template = MessageFormat.format(
                reportTemplate,
                getCurrentProfile(),
                companyProperties.name(),
                companyProperties.timezone(),
                status(featureProperties.attendance()),
                status(featureProperties.directSelling()),
                status(featureProperties.loyalty()),
                status(mailProperties.enabled()),
                databaseProperties.host(),
                String.valueOf(databaseProperties.port()),
                databaseProperties.username()
        );

        System.out.println(this.template);
    }

    @Override
    public String getReportTemplate() {
        return template;
    }

    private String status(boolean enabled) {
        return enabled ? "ENABLED" : "DISABLED";
    }

    private String getCurrentProfile() {

        String[] activeProfiles = environment.getActiveProfiles();

        if (activeProfiles.length == 0) {
            return "dev";
        }

        return String.join(", ", activeProfiles);
    }
}