package org.indivaragroup.jdt17.enterprise.properties;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CompanyPropertiesTest {

    @Autowired
    private CompanyProperties companyProperties;

    @Test
    public void shouldBindCompanyProperties() {

        assertEquals("MUH", companyProperties.code());
        assertEquals("Multi Usaha Hebat", companyProperties.name());
        assertEquals("Asia/Jakarta", companyProperties.timezone());

    }

}