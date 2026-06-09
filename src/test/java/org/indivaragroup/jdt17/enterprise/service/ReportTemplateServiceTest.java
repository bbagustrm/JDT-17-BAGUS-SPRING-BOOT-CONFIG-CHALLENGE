package org.indivaragroup.jdt17.enterprise.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ReportTemplateServiceTest {

    @Autowired
    private ReportTemplateService reportTemplateService;

    @Test
    public void shouldLoadReportTemplate() throws IOException {

        String template = reportTemplateService.getReportTemplate();

        assertNotNull(template);

        assertTrue(template.contains("MULTI USAHA HEBAT"));
    }

}
