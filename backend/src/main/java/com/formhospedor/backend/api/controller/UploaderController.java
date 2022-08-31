package com.formhospedor.backend.api.controller;

import com.formhospedor.backend.api.dto.GetSignedUrlDTO;
import com.formhospedor.backend.api.dto.SignedUrlDTO;
import com.formhospedor.backend.exceptions.NotFoundException;
import com.formhospedor.backend.service.AwsAccountInfoService;
import com.formhospedor.backend.service.AwsS3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/uploader")
public class UploaderController {

    @Autowired
    AwsS3Service awsS3Service;

    @Autowired
    AwsAccountInfoService awsAccountInfoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public SignedUrlDTO getSignedPutUrl(GetSignedUrlDTO dto) {
        var awsAccountInfo = awsAccountInfoService.getAwsAccountInfoByUserName(dto.getUserName())
                .orElseThrow(() -> new NotFoundException("Credenciais da AWS deste usuário não encontradas"));

        return new SignedUrlDTO(awsS3Service.getSiteBucketUrl(awsAccountInfo, dto.getSiteName()));
    }

}
