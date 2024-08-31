package com.AmaliaStefan.reporitory;

import org.springframework.data.jpa.repository.JpaRepository;
import com.AmaliaStefan.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {
    boolean existsByUsername(String username);
    Users findByUsername(String username);
}
