package com.formhospedor.backend.repository;

import com.formhospedor.backend.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Integer> {

    Boolean existsByEmail(String email);

}
