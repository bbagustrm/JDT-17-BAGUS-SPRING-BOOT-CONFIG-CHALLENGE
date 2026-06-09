package org.indivaragroup.jdt17.enterprise.properties;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(
        properties = {
        "DB_HOST=10.10.10.10"
        }
)
public class DatabaseOverridePropertiesTest {

    @Autowired
    private DatabaseProperties databaseProperties;

    @Test
    public void shouldOverrideDatabaseProperties() {
        assertEquals("10.10.10.10", databaseProperties.host());
    }

}
