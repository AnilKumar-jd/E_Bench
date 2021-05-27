package com.ebench.userservice.repository;

import com.ebench.userservice.entity.PatientProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JsonRepo extends JpaRepository<PatientProfile,Integer> {
}
