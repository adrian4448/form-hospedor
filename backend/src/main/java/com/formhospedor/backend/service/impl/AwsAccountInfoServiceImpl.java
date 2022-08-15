package com.formhospedor.backend.service.impl;

import com.formhospedor.backend.exceptions.NotFoundException;
import com.formhospedor.backend.model.AwsAccountInfo;
import com.formhospedor.backend.repository.AwsAccountInfoRepository;
import com.formhospedor.backend.service.AwsAccountInfoService;
import com.formhospedor.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AwsAccountInfoServiceImpl implements AwsAccountInfoService {

    @Autowired
    private AwsAccountInfoRepository repository;

    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public Optional<AwsAccountInfo> createAwsAccountInformation(AwsAccountInfo awsAccountInfo) {
        userService.findUserById(awsAccountInfo.getUser().getId())
                .orElseThrow(() -> new NotFoundException("Não foi encontrado nenhum usuário com este ID"));

        return Optional.of(repository.save(awsAccountInfo));
    }

}
