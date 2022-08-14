package com.formhospedor.backend.service.impl;

import com.formhospedor.backend.exceptions.BusinessException;
import com.formhospedor.backend.model.AppUser;
import com.formhospedor.backend.repository.UserRepository;
import com.formhospedor.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public Optional<AppUser> findUserById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Optional<AppUser> createNewUser(AppUser user) {
        if (repository.existsByEmail(user.getEmail())) {
            throw new BusinessException("Usuário com este e-mail já existe.");
        }

        user.setPassword(encoder.encode(user.getPassword()));

        return Optional.of(repository.save(user));
    }
}
