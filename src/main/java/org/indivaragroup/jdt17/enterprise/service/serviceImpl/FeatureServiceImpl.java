package org.indivaragroup.jdt17.enterprise.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.indivaragroup.jdt17.enterprise.properties.FeatureProperties;
import org.indivaragroup.jdt17.enterprise.service.FeatureService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeatureServiceImpl implements FeatureService {

    private final FeatureProperties featureProperties;


    @Override
    public boolean isAttendanceEnabled() {
        return featureProperties.attendance();
    }

    @Override
    public boolean isDirectSellingEnabled() {
        return featureProperties.directSelling();
    }

    @Override
    public boolean isLoyaltyEnabled() {
        return featureProperties.loyalty();
    }
}
