package com.formhospedor.backend.api.controller;

import com.formhospedor.backend.api.dto.AwsAccountInfoDTO;
import com.formhospedor.backend.api.dto.NewAwsAccountDTO;
import com.formhospedor.backend.model.AwsAccountInfo;
import com.formhospedor.backend.service.AwsAccountInfoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/aws-account-info")
public class AwsAccountController {

    @Autowired
    private AwsAccountInfoService awsAccountInfoService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public AwsAccountInfoDTO addAwsAccountInformation(@RequestBody NewAwsAccountDTO dto) {
        var awsAccountInfo = modelMapper.map(dto, AwsAccountInfo.class);

        return awsAccountInfoService.createAwsAccountInformation(awsAccountInfo)
                .map(savedRegister -> modelMapper.map(savedRegister, AwsAccountInfoDTO.class))
                .get();
    }

}
