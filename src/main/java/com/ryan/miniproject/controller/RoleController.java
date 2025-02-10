package com.ryan.miniproject.controller;

import com.ryan.miniproject.model.Role;
import com.ryan.miniproject.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {
    @Autowired
    private RoleService service;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void saveRole(@RequestBody Role role){
        service.saveRole(role);
    }

    @GetMapping
    public ResponseEntity<List<Role>> findAllRoles(){
        return ResponseEntity.ok(service.findAllRoles());
    }

    @PutMapping("{id}")
    public ResponseEntity<Role> updateRole(@PathVariable("id") UUID id, @RequestBody Role update){
        Role role = service.updateRole(update, id);
        return ResponseEntity.ok(role);
    }

    @DeleteMapping("{id}")
    public void deleteRole(@PathVariable("id") UUID id){
        service.deleteRole(id);
    }
}

