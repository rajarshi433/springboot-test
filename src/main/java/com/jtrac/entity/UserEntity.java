package com.jtrac.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "t_user")
@Table(name = "t_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(unique = true, nullable = false)
    private Long empId;

    @Column(nullable = false)
    private String firstName;
    private String lastName;
    private Long password;

    @ManyToOne
    @JoinColumn(name = "role_name", referencedColumnName = "roleName")
    private RoleEntity role;

    // PDNs owned by the user
    @OneToMany(mappedBy = "owner")
    private List<PDNEntity> ownedPDNs;

    // PDNs reviewed by the user
    @OneToMany(mappedBy = "reviewer")
    private List<PDNEntity> reviewedPDNs;
}
