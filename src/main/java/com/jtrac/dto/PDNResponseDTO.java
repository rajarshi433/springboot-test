package com.jtrac.dto;

import com.jtrac.constants.DeploymentStatusEnum;
import com.jtrac.constants.GitEnum;
import com.jtrac.constants.ProblemSourceEnum;
import com.jtrac.constants.ReviewStatusEnum;
import com.jtrac.entity.CommentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PDNResponseDTO {
    private String pdnNumber;
    private String git;
    private String problemSource;
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
    private String reviewStatus;
    private String reviewedBy;
    private LocalDateTime reviewedAt;
    private String deploymentStatus;
    private String deployedBy;
    private LocalDateTime deployedAt;
    private Boolean delivered;
    private LocalDateTime deliveredAt;
    private Boolean sentBack;
    private String sentBackBy;
    private List<CommentEntity> comments;
}
