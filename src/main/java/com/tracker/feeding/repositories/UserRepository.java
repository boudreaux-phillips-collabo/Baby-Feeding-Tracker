package com.tracker.feeding.repositories;

import com.tracker.feeding.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User getOne(long id);
}
