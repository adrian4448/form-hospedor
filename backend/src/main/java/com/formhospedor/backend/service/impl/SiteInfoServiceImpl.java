package com.formhospedor.backend.service.impl;

import com.formhospedor.backend.exceptions.BusinessException;
import com.formhospedor.backend.model.SiteInfo;
import com.formhospedor.backend.repository.SiteInfoRepository;
import com.formhospedor.backend.service.SiteInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiteInfoServiceImpl implements SiteInfoService {

    @Autowired
    private SiteInfoRepository siteInfoRepository;

    @Override
    public SiteInfo createNewSiteInfo(SiteInfo siteInfo) {
        if (siteExists(siteInfo.getSiteName())) {
            throw new BusinessException("Já existe um website com este nome, verifique novamente");
        }

        return siteInfoRepository.save(siteInfo);
    }

    @Override
    public Boolean siteExists(String siteName) {
        return siteInfoRepository.existsBySiteName(siteName);
    }
}
