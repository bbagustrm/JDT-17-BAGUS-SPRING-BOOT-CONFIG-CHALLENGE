package org.indivaragroup.jdt17.enterprise.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class FeatureServiceTest {

    @Autowired
    private FeatureService featureService;

    @Test
    public void shouldReturnFeatureStatus() {

        assertTrue(featureService.isAttendanceEnabled());
        assertTrue(featureService.isDirectSellingEnabled());
        assertFalse(featureService.isLoyaltyEnabled());

    }

}
