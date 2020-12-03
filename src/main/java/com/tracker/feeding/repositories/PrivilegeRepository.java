package com.tracker.feeding.repositories;

import com.tracker.feeding.models.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
    Privilege getOne(long id);
    Privilege findByName(String name);
}
