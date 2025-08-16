package com.jtrac.dto;

import com.jtrac.constants.DeploymentStatusEnum;
import com.jtrac.constants.GitEnum;
import com.jtrac.constants.ProblemSourceEnum;
import com.jtrac.constants.ReviewStatusEnum;
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
    private GitEnum git;
    private ProblemSourceEnum problemSource;
    private String loggedBy;
    private String developer;
    private String reviewer;
    private String createdAt;
    private String lastUpdated;
    private String description;
    private String components;
    private String problemId;
    private String product;
    private String module;
    private String subModule;
    private ReviewStatusEnum reviewStatus;
    private String reviewedBy;
    private LocalDateTime reviewedAt;
    private DeploymentStatusEnum deploymentStatus;
    private String deployedBy;
    private LocalDateTime deployedAt;
    private String sentBack;
    private String sentBackBy;
    private Integer userId;
    private List<Integer> comments;
}
