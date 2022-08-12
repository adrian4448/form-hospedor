package com.formhospedor.backend.api.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AwsAccountInfoDTO {

    private String accessKey;
    private String secretKey;

}
