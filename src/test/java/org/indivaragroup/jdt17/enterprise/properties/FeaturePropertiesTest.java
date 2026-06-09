package org.indivaragroup.jdt17.enterprise.properties;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class FeaturePropertiesTest {

    @Autowired
    private FeatureProperties featureProperties;

    @Test
    public void shouldBindFeatureProperties() {

        assertTrue(featureProperties.attendance());
        assertTrue(featureProperties.directSelling());
        assertFalse(featureProperties.loyalty());

    }

}