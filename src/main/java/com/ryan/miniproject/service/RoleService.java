package com.ryan.miniproject.service;

import com.ryan.miniproject.model.Role;
import com.ryan.miniproject.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoleService {
    @Autowired
    private RoleRepository repository;

    public void saveRole(Role role){
        repository.save(role);
    }

    public List<Role> findAllRoles(){
        return repository.findAll();
    }

    public Role updateRole(Role role, UUID id){
        Role existingRole = repository.findById(id).get();
        if(existingRole != null){
            existingRole.setName(role.getName());
        }
        return repository.save(existingRole);
    }

    public void deleteRole(UUID id){
        repository.deleteById(id);
    }
}
