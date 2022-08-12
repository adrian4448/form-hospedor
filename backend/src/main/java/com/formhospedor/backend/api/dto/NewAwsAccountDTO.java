package com.formhospedor.backend.api.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewAwsAccountDTO {

    private String accessKey;
    private String secretKey;
    private AppUserDTO user;

}
