package com.ryan.miniproject.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class RoleProjectDto {
    private UUID roleId;
    private UUID projectId;
}
