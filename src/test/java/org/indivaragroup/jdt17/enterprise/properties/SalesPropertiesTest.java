package org.indivaragroup.jdt17.enterprise.properties;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SalesPropertiesTest {

    @Autowired
    private SalesProperties salesProperties;

    @Test
    void shouldBindSalesProperties() {

        assertEquals(
                250,
                salesProperties.maxOutletPerRoute()
        );
    }
}