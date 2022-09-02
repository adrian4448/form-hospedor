package com.formhospedor.backend.api.controller;

import com.formhospedor.backend.api.dto.AwsAccountInfoDTO;
import com.formhospedor.backend.api.dto.AwsAccountInfoOkDTO;
import com.formhospedor.backend.api.dto.NewAwsAccountDTO;
import com.formhospedor.backend.exceptions.NotFoundException;
import com.formhospedor.backend.model.AwsAccountInfo;
import com.formhospedor.backend.service.AwsAccountInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api/aws-account-info")
@Api("Aws Account API")
public class AwsAccountController {

    @Autowired
    private AwsAccountInfoService awsAccountInfoService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Cria um Aws Account Info na base de dados")
    public AwsAccountInfoDTO addAwsAccountInformation(@RequestBody NewAwsAccountDTO dto) {
        var awsAccountInfo = modelMapper.map(dto, AwsAccountInfo.class);

        return awsAccountInfoService.createAwsAccountInformation(awsAccountInfo)
                .map(savedRegister -> modelMapper.map(savedRegister, AwsAccountInfoDTO.class))
                .get();
    }

    @PostMapping("/verify")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Verifica se é um usuário AWS válido com as informações do Aws Account Info")
    public AwsAccountInfoOkDTO verifyAwsAccountInfoCredentials(String userName) {
        return new AwsAccountInfoOkDTO(awsAccountInfoService.verifyAwsAccountInfoKeysByUser(userName));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Busca um Aws Account Info através do ID")
    public AwsAccountInfoDTO getAwsAccountInfoById(@PathParam("id") Integer id) {
        var awsAccountInfo = awsAccountInfoService.getAwsAccountInfoById(id);

        return awsAccountInfo
                .map(awsAccount -> modelMapper.map(awsAccount, AwsAccountInfoDTO.class))
                .orElseThrow(() -> new NotFoundException("Não foi encontrada nenhuma informação com este ID"));
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Busca um Aws Account Info através do userName")
    public AwsAccountInfoDTO getAwsAccountInfoByUserName(String userName) {
        var awsAccountInfo = awsAccountInfoService.getAwsAccountInfoByUserName(userName);

        return awsAccountInfo
                .map(awsAccount -> modelMapper.map(awsAccount, AwsAccountInfoDTO.class))
                .orElse(new AwsAccountInfoDTO());
    }

}
