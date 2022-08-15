package com.formhospedor.backend.service.impl;

import com.formhospedor.backend.exceptions.BusinessException;
import com.formhospedor.backend.exceptions.NotFoundException;
import com.formhospedor.backend.model.AppUser;
import com.formhospedor.backend.repository.UserRepository;
import com.formhospedor.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public Optional<AppUser> findUserById(Integer id) {
        var user = repository.findById(id);

        if (user.isEmpty()) {
            throw new NotFoundException("Usuário com este ID não foi encontrado");
        }

        return user;
    }

    @Override
    @Transactional
    public Optional<AppUser> createNewUser(AppUser user) {
        if (repository.existsByEmail(user.getEmail())) {
            throw new BusinessException("Usuário com este e-mail já existe.");
        }

        user.setPassword(encoder.encode(user.getPassword()));

        return Optional.of(repository.save(user));
    }

    @Override
    public Page<AppUser> findUserByParams(Pageable page, AppUser params) {
        ExampleMatcher exampleMatcher =
                ExampleMatcher.matching().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(params, exampleMatcher);

        return repository.findAll(example, page);
    }
}
