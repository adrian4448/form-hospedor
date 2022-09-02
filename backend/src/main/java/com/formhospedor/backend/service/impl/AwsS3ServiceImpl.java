package com.formhospedor.backend.service.impl;

import com.formhospedor.backend.exceptions.BusinessException;
import com.formhospedor.backend.model.AwsAccountInfo;
import com.formhospedor.backend.service.AwsS3Service;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.io.IOException;
import java.nio.ByteBuffer;

@Service
public class AwsS3ServiceImpl implements AwsS3Service {

    @Override
    public String createSiteBucket(AwsAccountInfo awsAccountInfo, String siteName, MultipartFile file) {
        var s3Client = S3Client.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(getAwsCredentialsProviderByAwsAccountInfo(awsAccountInfo))
                .build();

        try {
            s3Client
                    .createBucket(CreateBucketRequest.builder().bucket(siteName).build());

            PutObjectRequest objectRequest = PutObjectRequest.builder()
                    .bucket(siteName)
                    .key("index.html")
                    .contentType("text/html")
                    .acl(ObjectCannedACL.PUBLIC_READ_WRITE)
                    .build();

            s3Client.putObject(objectRequest, RequestBody.fromByteBuffer(ByteBuffer.wrap(file.getBytes())));

            s3Client.putBucketWebsite(
                    PutBucketWebsiteRequest
                            .builder()
                            .bucket(siteName)
                            .websiteConfiguration(WebsiteConfiguration.builder().indexDocument(IndexDocument.builder().suffix("index.html").build()).build())
                            .build()
            );
        } catch(BucketAlreadyExistsException | IOException e) {
            throw new BusinessException("O Nome deste site já existe, tente outro");
        }

        return new StringBuilder()
                .append("http://")
                .append(siteName)
                .append(".s3-website-us-east-1.amazonaws.com")
                .toString();
    }

    @Override
    public void deleteSiteBucket(AwsAccountInfo awsAccountInfo, String siteName) {
        try {
            var s3Client = S3Client.builder()
                    .region(Region.US_EAST_1)
                    .credentialsProvider(getAwsCredentialsProviderByAwsAccountInfo(awsAccountInfo))
                    .build();


            var objectRequest = DeleteObjectRequest.builder()
                    .bucket(siteName)
                    .key("index.html")
                    .build();

            s3Client.deleteObject(objectRequest);
            s3Client.deleteBucket(DeleteBucketRequest.builder().bucket(siteName).build());
        } catch(Exception e) {
            throw new BusinessException("Ocorreu um erro ao deletar a bucket, verifique com o administrador");
        }
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
