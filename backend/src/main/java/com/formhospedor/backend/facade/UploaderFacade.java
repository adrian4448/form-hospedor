package com.formhospedor.backend.facade;

import com.formhospedor.backend.api.dto.UploadDTO;
import com.formhospedor.backend.exceptions.BusinessException;
import com.formhospedor.backend.exceptions.NotFoundException;
import com.formhospedor.backend.model.SiteInfo;
import com.formhospedor.backend.service.AwsAccountInfoService;
import com.formhospedor.backend.service.AwsS3Service;
import com.formhospedor.backend.service.SiteInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UploaderFacade {

    @Autowired
    AwsS3Service awsS3Service;

    @Autowired
    AwsAccountInfoService awsAccountInfoService;

    @Autowired
    SiteInfoService siteInfoService;

    @Transactional
    public String uploadSite(UploadDTO dto, MultipartFile file) {
        var awsAccountInfo = awsAccountInfoService.getAwsAccountInfoByUserName(dto.getUserName())
                .orElseThrow(() -> new NotFoundException("Credenciais da AWS deste usuário não encontradas"));

        if (siteInfoService.siteExists(dto.getSiteName())) {
            throw new BusinessException("Já existe um website com este nome, verifique novamente");
        }

        String url = awsS3Service.createSiteBucket(awsAccountInfo, dto.getSiteName(), file);
        siteInfoService.createNewSiteInfo(new SiteInfo(dto.getSiteName(), url, awsAccountInfo));

        return url;
    }

}
