package com.jtrac.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PDNRequestDTO {
    private String git;
    private String problemSource;
    private String loggedBy;
    private String developer;
    private String reviewerName;
    private Long reviewerId;
    private String description;
    private String components;
    private String problemId;
    private String product;
    private String module;
    private String subModule;
    private Integer userId;
}
