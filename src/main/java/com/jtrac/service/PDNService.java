package com.jtrac.service;

import com.jtrac.dto.PDNRequestDTO;
import com.jtrac.responses.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface PDNService {
    ResponseEntity<ApiResponse<Integer>> createPDN(PDNRequestDTO pdnRequestDTO);
    void updatePDN();
    void fetchAllPDN();
    void fetchPDNByGit();
    void fetchPDNByDeveloper();
    void fetchPDNByReviewer();
    void fetchPDNByFilterObj();
}
