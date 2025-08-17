package com.jtrac.service;

import com.jtrac.dto.PDNRequestDTO;
import com.jtrac.dto.PDNResponseDTO;
import com.jtrac.responses.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PDNService {
    ResponseEntity<ApiResponse<Integer>> createPDN(PDNRequestDTO pdnRequestDTO);
    void updatePDN();
    ResponseEntity<ApiResponse<List<PDNResponseDTO>>> fetchAllPDN();
    ResponseEntity<ApiResponse<List<PDNResponseDTO>>> fetchPDNByGit(String git);
    ResponseEntity<ApiResponse<List<PDNResponseDTO>>> fetchPDNByDeveloper(Long userId);
    ResponseEntity<ApiResponse<List<PDNResponseDTO>>> fetchPDNByReviewer(Long reviewerId);
    ResponseEntity<ApiResponse<List<PDNResponseDTO>>> fetchPDNNotReviewed(Long userId);

    void fetchPDNByFilterObj();
}
