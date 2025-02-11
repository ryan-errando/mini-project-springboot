package com.ryan.miniproject.service;

import com.ryan.miniproject.model.Role;
import com.ryan.miniproject.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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

    @Cacheable(value = "roles")
    public List<Role> findAllRoles(){
        return repository.findAll();
    }

    @CachePut(value = "roles", key = "#id")
    public Role updateRole(Role role, UUID id){
        Role existingRole = repository.findById(id).get();
        if(existingRole != null){
            existingRole.setName(role.getName());
        }
        return repository.save(existingRole);
    }

    @CacheEvict(value = "roles", key = "#id")
    public void deleteRole(UUID id){
        repository.deleteById(id);
    }
}
