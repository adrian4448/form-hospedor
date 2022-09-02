package com.formhospedor.backend.service;

import com.formhospedor.backend.model.SiteInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SiteInfoService {

    SiteInfo createNewSiteInfo(SiteInfo siteInfo);
    Boolean siteExists(String siteName);
    Page<SiteInfo> getAllSiteInfoPage(Pageable pageable);
    void deleteSiteInfo(String siteName);
}
