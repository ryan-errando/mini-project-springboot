package com.ryan.miniproject.repository;

import com.ryan.miniproject.model.UserRoleProject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRoleProjectRepository extends JpaRepository<UserRoleProject, UUID> {
    List<UserRoleProject> findByUserId(UUID userId);
}
