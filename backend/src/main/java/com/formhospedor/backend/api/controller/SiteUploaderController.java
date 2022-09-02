package com.formhospedor.backend.api.controller;

import com.formhospedor.backend.api.dto.UploadDTO;
import com.formhospedor.backend.api.dto.SignedUrlDTO;
import com.formhospedor.backend.facade.UploaderFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/site-uploader")
@Api("Site Uploader API")
public class SiteUploaderController {

    @Autowired
    UploaderFacade uploaderFacade;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Realiza o upload de um site no AWS S3")
    public SignedUrlDTO uploadSite(UploadDTO dto, MultipartFile file) {
        return new SignedUrlDTO(uploaderFacade.uploadSite(dto, file));
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Realiza o delete de um site no AWS S3")
    public void deleteSite(@RequestBody UploadDTO dto) {
        uploaderFacade.deleteSite(dto);
    }

}
