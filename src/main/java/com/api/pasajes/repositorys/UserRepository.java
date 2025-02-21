package com.api.pasajes.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.pasajes.models.User;

public interface UserRepository extends JpaRepository< User, Integer>{

    Optional<User> findByUserName(String userName);
}
