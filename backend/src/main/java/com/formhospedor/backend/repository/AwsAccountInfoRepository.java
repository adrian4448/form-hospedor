package com.formhospedor.backend.repository;

import com.formhospedor.backend.model.AwsAccountInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AwsAccountInfoRepository extends JpaRepository<AwsAccountInfo, Integer> {
}
