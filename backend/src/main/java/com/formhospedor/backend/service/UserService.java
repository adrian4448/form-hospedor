package com.formhospedor.backend.service;

import com.formhospedor.backend.model.AppUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<AppUser> findUserById(Integer id);

    Optional<AppUser> createNewUser(AppUser user);

    Page<AppUser> findUserByParams(Pageable page, AppUser params);
}
