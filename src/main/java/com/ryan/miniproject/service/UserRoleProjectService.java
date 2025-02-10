package com.ryan.miniproject.service;

import com.ryan.miniproject.dto.RoleProjectDto;
import com.ryan.miniproject.dto.UserRoleProjectDto;
import com.ryan.miniproject.dto.UserRoleProjectUpdateDto;
import com.ryan.miniproject.model.UserRoleProject;
import com.ryan.miniproject.repository.ProjectRepository;
import com.ryan.miniproject.repository.RoleRepository;
import com.ryan.miniproject.repository.UserRepository;
import com.ryan.miniproject.repository.UserRoleProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserRoleProjectService {
    @Autowired
    private UserRoleProjectRepository repository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserRepository userRepository;

    public void saveURP(UserRoleProject urp){
        repository.save(urp);
    }

    public void saveURPs(UserRoleProjectDto dto){
        for(RoleProjectDto roleProject : dto.getRoleProject()){
            UserRoleProject urp = new UserRoleProject();
            urp.setUserId(dto.getUserId());
            urp.setProjectId(roleProject.getProjectId());
            urp.setRoleId(roleProject.getRoleId());
            repository.save(urp);
        }
    }

    public void deleteURP(UUID id){
        repository.deleteById(id);
    }

    public UserRoleProject updateURP(UUID id, UserRoleProject urp){
        UserRoleProject existingURP = repository.findById(id).get();
        if(existingURP != null){
            existingURP.setUserId(urp.getUserId());
            existingURP.setProjectId(urp.getProjectId());
            existingURP.setRoleId(urp.getRoleId());
        }
        return repository.save(existingURP);
    }

    public void updateURPS (List<UserRoleProjectUpdateDto> dto){
        for(UserRoleProjectUpdateDto urp : dto){
            UserRoleProject existURP = repository.findById(urp.getId()).get();
            existURP.setUserId(urp.getUserId());
            existURP.setProjectId(urp.getProjectId());
            existURP.setRoleId(urp.getRoleId());
            repository.save(existURP);
        }
    }

    public UserRoleProjectDto findByUserId(UUID userId){
        List<UserRoleProject> userRoleProjects = repository.findByUserId(userId);
        List<RoleProjectDto> roleProjectDtos = userRoleProjects.stream()
                .map(userRoleProject -> RoleProjectDto.builder()
                        .roleId(userRoleProject.getRoleId())
                        .projectId(userRoleProject.getProjectId())
                        .build())
                .collect(Collectors.toList());

        return UserRoleProjectDto.builder()
                .userId(userId)
                .roleProject(roleProjectDtos)
                .build();
    }

    public List<UserRoleProject> findAll(){
        return repository.findAll();
    }

}
