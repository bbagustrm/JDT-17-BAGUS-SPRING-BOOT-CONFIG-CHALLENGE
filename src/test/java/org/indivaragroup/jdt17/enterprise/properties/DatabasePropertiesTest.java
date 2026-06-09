package org.indivaragroup.jdt17.enterprise.properties;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class DatabasePropertiesTest {

    @Autowired
    private DatabaseProperties databaseProperties;

    @Test
    public void shouldBindDatabaseProperties() {
        // default
        assertEquals("localhost", databaseProperties.host());
        assertEquals("5432", databaseProperties.port());

    }

}