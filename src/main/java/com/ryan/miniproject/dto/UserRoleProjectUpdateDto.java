package com.ryan.miniproject.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserRoleProjectUpdateDto {
    private UUID id;
    private UUID userId;
    private UUID roleId;
    private UUID projectId;
}
