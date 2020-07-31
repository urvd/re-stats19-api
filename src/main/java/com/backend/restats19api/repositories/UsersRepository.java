package com.backend.restats19api.repositories;

import com.backend.restats19api.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
    Boolean existsByUsername(String username);
}
