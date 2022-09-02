package com.formhospedor.backend.api.controller;

import com.formhospedor.backend.api.dto.SiteInfoDTO;
import com.formhospedor.backend.service.SiteInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/site-info")
@Api("Site Info API")
public class SiteInfoController {

    @Autowired
    private SiteInfoService siteInfoService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Busca todos os sites hospedados através do sistema")
    public Page<SiteInfoDTO> getAllSiteInfo(Pageable page) {
        var result = siteInfoService
                .getAllSiteInfoPage(page);

        var content = result
                .map(siteInfo -> modelMapper.map(siteInfo, SiteInfoDTO.class))
                .getContent();

        return new PageImpl(content, PageRequest.of(page.getPageNumber(), page.getPageSize()), result.getTotalElements());
    }

}
