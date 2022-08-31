package com.formhospedor.backend.service.impl;

import com.formhospedor.backend.model.AwsAccountInfo;
import com.formhospedor.backend.service.AwsS3Service;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutBucketWebsiteRequest;

@Service
public class AwsS3ServiceImpl implements AwsS3Service {

    @Override
    public String getSiteBucketUrl(AwsAccountInfo awsAccountInfo, String siteName) {
        // verificar existencia da bucket, ou validar erro via try catch de nome ja existente
        var s3Client = S3Client.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(getAwsCredentialsProviderByAwsAccountInfo(awsAccountInfo))
                .build();
        
        s3Client
                .putBucketWebsite(PutBucketWebsiteRequest.builder().bucket(siteName).build());



        return "";
    }

    @Override
    public Boolean awsAccountInfoCredentialsIsValid(AwsAccountInfo awsAccountInfo) {
        try {
            S3Client.builder()
                    .region(Region.US_EAST_1)
                    .credentialsProvider(getAwsCredentialsProviderByAwsAccountInfo(awsAccountInfo))
                    .build();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public AwsCredentialsProvider getAwsCredentialsProviderByAwsAccountInfo(AwsAccountInfo awsAccountInfo) {
        AwsBasicCredentials awsCreds = AwsBasicCredentials.create(
                awsAccountInfo.getAccessKey(),
                awsAccountInfo.getSecretKey());

        return StaticCredentialsProvider.create(awsCreds);
    }

}
