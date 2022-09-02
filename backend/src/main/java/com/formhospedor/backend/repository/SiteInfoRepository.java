package com.formhospedor.backend.repository;

import com.formhospedor.backend.model.SiteInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteInfoRepository extends JpaRepository<SiteInfo, Integer> {

    Boolean existsBySiteName(String siteName);
    SiteInfo findBySiteName(String siteName);
}
