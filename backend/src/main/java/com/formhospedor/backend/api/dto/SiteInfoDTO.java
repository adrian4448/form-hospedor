package com.formhospedor.backend.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SiteInfoDTO {

    private Integer id;
    private String siteName;
    private String url;

}
