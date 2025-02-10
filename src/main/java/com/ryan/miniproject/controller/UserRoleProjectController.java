package com.ryan.miniproject.controller;

import com.ryan.miniproject.dto.UserRoleProjectDto;
import com.ryan.miniproject.dto.UserRoleProjectUpdateDto;
import com.ryan.miniproject.model.UserRoleProject;
import com.ryan.miniproject.service.UserRoleProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/user-role-project")
public class UserRoleProjectController {

    @Autowired
    private UserRoleProjectService service;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void saveURP(@RequestBody UserRoleProject urp){
        service.saveURP(urp);
    }

    @PostMapping("/batch")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void saveURPs(@RequestBody UserRoleProjectDto dto){
        service.saveURPs(dto);
    }

    @DeleteMapping("{id}")
    public void deleteURP(@PathVariable("id")UUID id){
        service.deleteURP(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserRoleProject> updateURP(@PathVariable("id")UUID id, @RequestBody UserRoleProject urp){
        return ResponseEntity.ok(service.updateURP(id, urp));
    }

    @GetMapping("{id}")
    public UserRoleProjectDto findURPbyUserId(@PathVariable("id")UUID id){
        return service.findByUserId(id);
    }

    @GetMapping
    public List<UserRoleProject> findAll(){
        return service.findAll();
    }

    @PutMapping("/update-batch")
    public void updateURPs(@RequestBody List<UserRoleProjectUpdateDto> dto){
        service.updateURPS(dto);
    }

}
