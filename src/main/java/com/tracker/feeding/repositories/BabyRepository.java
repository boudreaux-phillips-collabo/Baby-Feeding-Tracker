package com.tracker.feeding.repositories;

import com.tracker.feeding.models.Baby;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BabyRepository extends JpaRepository<Baby, Long> {
    Baby findByName(String name);
    Baby getOne(long id);
}
