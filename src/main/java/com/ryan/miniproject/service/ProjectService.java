package com.ryan.miniproject.service;

import com.ryan.miniproject.model.Project;
import com.ryan.miniproject.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository repository;

    public void saveProject(Project project){
        repository.save(project);
    }

    @Cacheable(value = "projects")
    public List<Project> findAllProjects(){
        return repository.findAll();
    }

    @CachePut(value = "projects", key = "#id")
    public Project updateProject(Project project, UUID id){
        Project existingProject = repository.findById(id).get();
        if(existingProject != null){
            existingProject.setName(project.getName());
            existingProject.setDescription(project.getDescription());
        }
        return repository.save(existingProject);
    }

    @CacheEvict(value = "projects", key = "#id")
    public void deleteProject(UUID id){
        repository.deleteById(id);
    }

}
