package org.indivaragroup.jdt17.enterprise.properties;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class MailPropertiesTest {

    @Autowired
    private MailProperties mailProperties;

    @Test
    public void shouldBindMailProperties() {

        assertTrue(mailProperties.enabled());
        assertEquals("smtp.gmail.com", mailProperties.host());
        assertEquals("587", mailProperties.port());

    }

}