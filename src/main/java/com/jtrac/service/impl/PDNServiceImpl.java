package com.jtrac.service.impl;

import com.jtrac.constants.DeploymentStatusEnum;
import com.jtrac.constants.GitEnum;
import com.jtrac.constants.ProblemSourceEnum;
import com.jtrac.constants.ReviewStatusEnum;
import com.jtrac.dto.PDNRequestDTO;
import com.jtrac.repository.PDNRepository;
import com.jtrac.responses.ApiResponse;
import com.jtrac.service.PDNService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PDNServiceImpl implements PDNService {

    @Autowired
    PDNRepository pdnRepository;

    public ResponseEntity<ApiResponse<Integer>> createPDN(PDNRequestDTO pdnRequestDTO){

        /* TODO: Find reviewer by id and name and validate before storing pdn */

        int rowsInserted = pdnRepository.savePDN(
                pdnRequestDTO.getComponents(),
                LocalDateTime.now(),
                DeploymentStatusEnum.PENDING.name(),
                pdnRequestDTO.getDescription(),
                pdnRequestDTO.getDeveloper(),
                GitEnum.valueOf(pdnRequestDTO.getGit().toUpperCase()).name(),
                LocalDateTime.now(),
                pdnRequestDTO.getLoggedBy(),
                pdnRequestDTO.getModule(),
                UUID.randomUUID().toString(),
                pdnRequestDTO.getProblemId(),
                ProblemSourceEnum.valueOf(pdnRequestDTO.getProblemSource().toUpperCase()).name(),
                pdnRequestDTO.getProduct(),
                ReviewStatusEnum.PENDING.name(),
                pdnRequestDTO.getReviewerName(),
                pdnRequestDTO.getReviewerId(),
                false,
                pdnRequestDTO.getSubModule(),
                pdnRequestDTO.getUserId()
        );

        if (rowsInserted == 1)
            return new ResponseEntity<>(
                    new ApiResponse<>(
                            HttpStatus.CREATED.value(),
                            "Success",
                            rowsInserted
                    ),
                    HttpStatus.CREATED
            );

        return new ResponseEntity<>(
                new ApiResponse<>(
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        "Failed",
                        rowsInserted
                ),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
    public void updatePDN(){}
    public void fetchAllPDN(){}
    public void fetchPDNByGit(){}
    public void fetchPDNByDeveloper(){}
    public void fetchPDNByReviewer(){}
    public void fetchPDNByFilterObj(){}
}
