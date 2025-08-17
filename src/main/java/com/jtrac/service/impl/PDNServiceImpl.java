package com.jtrac.service.impl;

import com.jtrac.constants.DeploymentStatusEnum;
import com.jtrac.constants.GitEnum;
import com.jtrac.constants.ProblemSourceEnum;
import com.jtrac.constants.ReviewStatusEnum;
import com.jtrac.dto.PDNRequestDTO;
import com.jtrac.dto.PDNResponseDTO;
import com.jtrac.entity.PDNEntity;
import com.jtrac.repository.PDNRepository;
import com.jtrac.responses.ApiResponse;
import com.jtrac.service.PDNService;
import com.jtrac.util.GeneratePDNResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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

    public ResponseEntity<ApiResponse<List<PDNResponseDTO>>> fetchAllPDN(){
        List<PDNEntity> pdns = pdnRepository.findAllPDNs();

        if (pdns.isEmpty())
            return new ResponseEntity<>(
                    new ApiResponse<>(
                            HttpStatus.NOT_FOUND.value(),
                            "No PDN Found",
                            null
                    ),
                    HttpStatus.NOT_FOUND
            );

        List<PDNResponseDTO> pdnResponseDTOList = GeneratePDNResponseDTO.generateList(pdns);

        return new ResponseEntity<>(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Success",
                        pdnResponseDTOList
                ),
                HttpStatus.OK
        );
    }

    public ResponseEntity<ApiResponse<List<PDNResponseDTO>>> fetchPDNByGit(String git){
        List<PDNEntity> pdns = pdnRepository.findPDNsByGit(git);

        if (pdns.isEmpty())
            return new ResponseEntity<>(
                    new ApiResponse<>(
                            HttpStatus.NOT_FOUND.value(),
                            "No PDN Found",
                            null
                    ),
                    HttpStatus.NOT_FOUND
            );

        List<PDNResponseDTO> pdnResponseDTOList = GeneratePDNResponseDTO.generateList(pdns);

        return new ResponseEntity<>(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Success",
                        pdnResponseDTOList
                ),
                HttpStatus.OK
        );
    }

    public ResponseEntity<ApiResponse<List<PDNResponseDTO>>> fetchPDNByDeveloper(Long userId){
        List<PDNEntity> pdns = pdnRepository.findPDNsByDeveloper(userId);

        if (pdns.isEmpty())
            return new ResponseEntity<>(
                    new ApiResponse<>(
                            HttpStatus.NOT_FOUND.value(),
                            "No PDN Found",
                            null
                    ),
                    HttpStatus.NOT_FOUND
            );

        List<PDNResponseDTO> pdnResponseDTOList = GeneratePDNResponseDTO.generateList(pdns);

        return new ResponseEntity<>(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Success",
                        pdnResponseDTOList
                ),
                HttpStatus.OK
        );
    }

    public ResponseEntity<ApiResponse<List<PDNResponseDTO>>> fetchPDNByReviewer(Long reviewerId){
        List<PDNEntity> pdns = pdnRepository.findPDNsByReviewer(reviewerId);

            if (pdns.isEmpty())
                return new ResponseEntity<>(
                        new ApiResponse<>(
                                HttpStatus.NOT_FOUND.value(),
                                "No PDN Found",
                                null
                        ),
                        HttpStatus.NOT_FOUND
                );

            List<PDNResponseDTO> pdnResponseDTOList = GeneratePDNResponseDTO.generateList(pdns);

            return new ResponseEntity<>(
                    new ApiResponse<>(
                            HttpStatus.OK.value(),
                            "Success",
                            pdnResponseDTOList
                    ),
                    HttpStatus.OK
            );
    }

    public ResponseEntity<ApiResponse<List<PDNResponseDTO>>> fetchPDNNotReviewed(Long userId) {
        List<PDNEntity> pdns = pdnRepository.findPDNsNotReviewed(userId);

        if (pdns.isEmpty())
            return new ResponseEntity<>(
                    new ApiResponse<>(
                            HttpStatus.NOT_FOUND.value(),
                            "No PDN Found",
                            null
                    ),
                    HttpStatus.NOT_FOUND
            );

        List<PDNResponseDTO> pdnResponseDTOList = GeneratePDNResponseDTO.generateList(pdns);

        return new ResponseEntity<>(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Success",
                        pdnResponseDTOList
                ),
                HttpStatus.OK
        );
    }

    public void fetchPDNByFilterObj(){}

}
