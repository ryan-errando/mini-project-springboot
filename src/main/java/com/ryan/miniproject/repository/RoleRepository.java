package com.ryan.miniproject.repository;

import com.ryan.miniproject.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
}
