package com.ryan.miniproject.controller;

import com.ryan.miniproject.model.Project;
import com.ryan.miniproject.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {

    @Autowired
    private ProjectService service;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void saveProject(@RequestBody Project project){
        service.saveProject(project);
    }

    @GetMapping
    public ResponseEntity<List<Project>> findAllProjects(){
        return ResponseEntity.ok(service.findAllProjects());
    }

    @PutMapping("{id}")
    public ResponseEntity<Project> updateProject(@PathVariable("id")UUID id, @RequestBody Project project){
        Project update = service.updateProject(project, id);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("{id}")
    public void deleteProject(@PathVariable("id")UUID id){
        service.deleteProject(id);
    }
}
