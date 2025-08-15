package com.jtrac.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "users")
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(unique = true, nullable = false)
    private long empId;

    @Column(nullable = false)
    private String firstName;
    private String lastName;
    private long password;

    @ManyToOne
    @JoinColumn(name = "role_name", referencedColumnName = "roleName")
    private RoleEntity role;
}
