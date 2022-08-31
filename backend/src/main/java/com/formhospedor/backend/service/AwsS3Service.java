package com.formhospedor.backend.service;

import com.formhospedor.backend.model.AwsAccountInfo;

public interface AwsS3Service {

    String getSiteBucketUrl(AwsAccountInfo awsAccountInfo, String objectName);

    Boolean awsAccountInfoCredentialsIsValid(AwsAccountInfo awsAccountInfo);
}
