package com.formhospedor.backend.service;

import com.formhospedor.backend.model.AwsAccountInfo;
import org.springframework.web.multipart.MultipartFile;

public interface AwsS3Service {

    String createSiteBucket(AwsAccountInfo awsAccountInfo, String siteName, MultipartFile file);
    void deleteSiteBucket(AwsAccountInfo awsAccountInfo, String siteName);
    Boolean awsAccountInfoCredentialsIsValid(AwsAccountInfo awsAccountInfo);
}
