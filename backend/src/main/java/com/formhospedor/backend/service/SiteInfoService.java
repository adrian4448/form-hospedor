package com.formhospedor.backend.service;

import com.formhospedor.backend.model.SiteInfo;

public interface SiteInfoService {

    SiteInfo createNewSiteInfo(SiteInfo siteInfo);

    Boolean siteExists(String siteName);

}
