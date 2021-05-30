package com.example.rentacar.repository;

import com.example.rentacar.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserData, Integer> {
    UserData findUserDataByEmailAndPassword(String email, String password);
    UserData findUserDataByEmail(String email);
}
