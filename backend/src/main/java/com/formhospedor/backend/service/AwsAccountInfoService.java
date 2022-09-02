package com.formhospedor.backend.service;

import com.formhospedor.backend.model.AwsAccountInfo;

import java.util.Optional;

public interface AwsAccountInfoService {
    Optional<AwsAccountInfo> createAwsAccountInformation(AwsAccountInfo awsAccountInfo);
    Optional<AwsAccountInfo> getAwsAccountInfoById(Integer id);
    Optional<AwsAccountInfo> getAwsAccountInfoByUserName(String userName);
    Boolean verifyAwsAccountInfoKeysByUser(String userName);
}
