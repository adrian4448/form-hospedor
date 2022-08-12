package com.formhospedor.backend.service;

import com.formhospedor.backend.model.AppUser;

import java.util.Optional;

public interface UserService {

    Optional<AppUser> findUserById(Integer id);

    Optional<AppUser> createNewUser(AppUser user);
}
