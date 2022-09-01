package com.formhospedor.backend.api.controller;

import com.formhospedor.backend.api.dto.SiteInfoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/site-info")
public class SiteInfoController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<SiteInfoDTO> getAllSiteInfo(Pageable page) {
        return new PageImpl(List.of(new SiteInfoDTO()), PageRequest.of(page.getPageNumber(), page.getPageSize()), 100);
    }

}
