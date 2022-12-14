package com.formhospedor.backend.repository;

import com.formhospedor.backend.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Integer> {

    Boolean existsByEmailOrUserName(String email, String userName);

    Optional<AppUser> findByUserName(String username);

}
