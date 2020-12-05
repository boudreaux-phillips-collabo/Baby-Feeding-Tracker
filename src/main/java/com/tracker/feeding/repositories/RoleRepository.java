package com.tracker.feeding.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.management.relation.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role getOne(long id);
    Role findByName(String name);
}
