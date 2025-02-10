package com.ryan.miniproject.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
public class UserRoleProjectDto {
    private UUID userId;
    private List<RoleProjectDto> roleProject;
}
