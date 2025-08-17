package com.jtrac.util;

import com.jtrac.dto.PDNResponseDTO;
import com.jtrac.entity.PDNEntity;

import java.util.ArrayList;
import java.util.List;

public class GeneratePDNResponseDTO {
    public static List<PDNResponseDTO> generateList(List<PDNEntity> pdns) {
        List<PDNResponseDTO> pdnResponseDTOList = new ArrayList<>();

        for (PDNEntity pdn : pdns) {
            PDNResponseDTO pdnResponseDTO = new PDNResponseDTO();

            pdnResponseDTO.setPdnNumber(pdn.getPdnNumber());
            pdnResponseDTO.setGit(pdn.getGit().name());
            pdnResponseDTO.setProblemSource(pdn.getProblemSource().name());
            pdnResponseDTO.setLoggedBy(pdn.getLoggedBy());
            pdnResponseDTO.setDeveloper(pdn.getDeveloper());
            pdnResponseDTO.setReviewerName(pdn.getReviewerName());
            pdnResponseDTO.setCreatedAt(pdn.getCreatedAt());
            pdnResponseDTO.setLastUpdated(pdn.getLastUpdated());
            pdnResponseDTO.setDescription(pdn.getDescription());
            pdnResponseDTO.setComponents(pdn.getComponents());
            pdnResponseDTO.setProblemId(pdn.getProblemId());
            pdnResponseDTO.setProduct(pdn.getProduct());
            pdnResponseDTO.setModule(pdn.getModule());
            pdnResponseDTO.setSubModule(pdn.getSubModule());
            pdnResponseDTO.setReviewStatus(pdn.getReviewStatus().name());
            pdnResponseDTO.setReviewedBy(pdn.getReviewedBy());
            pdnResponseDTO.setReviewedAt(pdn.getReviewedAt());
            pdnResponseDTO.setDeployedBy(pdn.getDeployedBy());
            pdnResponseDTO.setDeployedAt(pdn.getDeployedAt());
            pdnResponseDTO.setDelivered(pdn.getDelivered());
            pdnResponseDTO.setDeliveredAt(pdn.getDeliveredAt());
            pdnResponseDTO.setSentBack(pdn.getSentBack());
            pdnResponseDTO.setSentBackBy(pdn.getSentBackBy());
            pdnResponseDTO.setComments(pdn.getComments());

            pdnResponseDTOList.add(pdnResponseDTO);
        }

        return pdnResponseDTOList;
    }

    public static PDNResponseDTO generate(PDNEntity pdn) {
        PDNResponseDTO pdnResponseDTO = new PDNResponseDTO();

        pdnResponseDTO.setPdnNumber(pdn.getPdnNumber());
        pdnResponseDTO.setGit(pdn.getGit().name());
        pdnResponseDTO.setProblemSource(pdn.getProblemSource().name());
        pdnResponseDTO.setLoggedBy(pdn.getLoggedBy());
        pdnResponseDTO.setDeveloper(pdn.getDeveloper());
        pdnResponseDTO.setReviewerName(pdn.getReviewerName());
        pdnResponseDTO.setCreatedAt(pdn.getCreatedAt());
        pdnResponseDTO.setLastUpdated(pdn.getLastUpdated());
        pdnResponseDTO.setDescription(pdn.getDescription());
        pdnResponseDTO.setComponents(pdn.getComponents());
        pdnResponseDTO.setProblemId(pdn.getProblemId());
        pdnResponseDTO.setProduct(pdn.getProduct());
        pdnResponseDTO.setModule(pdn.getModule());
        pdnResponseDTO.setSubModule(pdn.getSubModule());
        pdnResponseDTO.setReviewStatus(pdn.getReviewStatus().name());
        pdnResponseDTO.setReviewedBy(pdn.getReviewedBy());
        pdnResponseDTO.setReviewedAt(pdn.getReviewedAt());
        pdnResponseDTO.setDeployedBy(pdn.getDeployedBy());
        pdnResponseDTO.setDeployedAt(pdn.getDeployedAt());
        pdnResponseDTO.setSentBack(pdn.getSentBack());
        pdnResponseDTO.setSentBackBy(pdn.getSentBackBy());
        pdnResponseDTO.setComments(pdn.getComments());

        return pdnResponseDTO;
    }
}
