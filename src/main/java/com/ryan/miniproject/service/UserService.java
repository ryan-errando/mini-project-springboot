package com.ryan.miniproject.service;

import com.ryan.miniproject.model.User;
import com.ryan.miniproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public void saveUser(User user){
        repository.save(user);
    }

    @Cacheable(value = "users")
    public List<User> findAllUser(){
        return repository.findAll();
    }

    @CachePut(value = "user", key = "#user.id")
    public User updateUser(User user, UUID id){
        User existingUser = repository.findById(id).get();
        if(existingUser != null){
            existingUser.setFullName(user.getFullName());
            existingUser.setEmail(user.getEmail());
            existingUser.setPhoneNumber(user.getPhoneNumber());
            existingUser.setUsername(user.getUsername());
        }
        return repository.save(existingUser);
    }

    @CacheEvict(value = "user", key = "#id")
    public void deleteUser(UUID id){
        repository.deleteById(id);
    }
}
