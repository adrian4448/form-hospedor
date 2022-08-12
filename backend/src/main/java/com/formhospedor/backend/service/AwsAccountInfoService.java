package com.formhospedor.backend.service;

import com.formhospedor.backend.model.AwsAccountInfo;

import java.util.Optional;

public interface AwsAccountInfoService {
    Optional<AwsAccountInfo> createAwsAccountInformation(AwsAccountInfo awsAccountInfo);
}
