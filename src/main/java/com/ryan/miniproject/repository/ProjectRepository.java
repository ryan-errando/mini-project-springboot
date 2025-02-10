package com.ryan.miniproject.repository;

import com.ryan.miniproject.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjectRepository extends JpaRepository<Project, UUID> {
}
