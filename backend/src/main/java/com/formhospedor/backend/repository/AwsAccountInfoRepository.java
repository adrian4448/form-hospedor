package com.formhospedor.backend.repository;

import com.formhospedor.backend.model.AwsAccountInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AwsAccountInfoRepository extends JpaRepository<AwsAccountInfo, Integer> {
    @Query("select acc from AwsAccountInfo acc where acc.user.userName = :username")
    Optional<AwsAccountInfo> findByUserName(@Param("username") String username);
}
