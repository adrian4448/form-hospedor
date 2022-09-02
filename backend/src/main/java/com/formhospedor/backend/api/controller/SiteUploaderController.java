package com.formhospedor.backend.api.controller;

import com.formhospedor.backend.api.dto.UploadDTO;
import com.formhospedor.backend.api.dto.SignedUrlDTO;
import com.formhospedor.backend.facade.UploaderFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/site-uploader")
public class SiteUploaderController {

    @Autowired
    UploaderFacade uploaderFacade;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public SignedUrlDTO uploadSite(UploadDTO dto, MultipartFile file) {
        return new SignedUrlDTO(uploaderFacade.uploadSite(dto, file));
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteSite(@RequestBody UploadDTO dto) {
        uploaderFacade.deleteSite(dto);
    }

}
