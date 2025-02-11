package com.ryan.miniproject.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user_role_project")
public class UserRoleProject implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @JoinColumn(name = "user_id", nullable = false)
    private UUID userId;

    @JoinColumn(name = "role_id", nullable = false)
    private UUID roleId;

    @JoinColumn(name = "project_id", nullable = false)
    private UUID projectId;
}
