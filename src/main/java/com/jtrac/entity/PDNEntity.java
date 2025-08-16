package com.jtrac.entity;

import com.jtrac.constants.DeploymentStatusEnum;
import com.jtrac.constants.GitEnum;
import com.jtrac.constants.ProblemSourceEnum;
import com.jtrac.constants.ReviewStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "t_pdn")
@Table(name = "t_pdn")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PDNEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pdnId;

    @Column(nullable = false, unique = true)
    private String pdnNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GitEnum git;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProblemSourceEnum problemSource;

    @Column(nullable = false)
    private String loggedBy;
    private String developer;
    private String reviewerName;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdated;
    private String description;
    private String components;
    private String problemId;
    private String product;
    private String module;
    private String subModule;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReviewStatusEnum reviewStatus = ReviewStatusEnum.PENDING;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DeploymentStatusEnum deploymentStatus = DeploymentStatusEnum.PENDING;

    private String reviewedBy;
    private LocalDateTime reviewedAt;
    private String deployedBy;
    private LocalDateTime deployedAt;
    private Boolean sentBack;
    private String sentBackBy;

    @ManyToOne
    @JoinColumn(name = "reviewer_id", referencedColumnName = "userId")
    private UserEntity reviewer;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private UserEntity owner;

    @OneToMany(mappedBy = "pdn")
    private List<CommentEntity> comments;
}
