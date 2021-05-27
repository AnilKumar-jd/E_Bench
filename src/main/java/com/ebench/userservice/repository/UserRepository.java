package com.ebench.userservice.repository;

import com.ebench.userservice.dto.response.logindto.LoginResponseDTO;
import com.ebench.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // for login...........
     @Query("select new com.ebench.userservice.dto.response.logindto.LoginResponseDTO(d.id,d.email,d.name,d.phoneNumber,d.userType)from User d where email=?1 and password=?2")
     LoginResponseDTO findByEmailandPass(String email, String password);

}
