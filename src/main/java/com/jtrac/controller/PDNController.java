package com.jtrac.controller;

import com.jtrac.dto.PDNRequestDTO;
import com.jtrac.dto.PDNResponseDTO;
import com.jtrac.responses.ApiResponse;
import com.jtrac.service.PDNService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pdn")
public class PDNController {

    @Autowired
    private PDNService pdnService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Integer>> createPDN(@RequestBody PDNRequestDTO pdnRequestDTO) {
        return pdnService.createPDN(pdnRequestDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<PDNResponseDTO>>> fetchAllPDN() {
        return pdnService.fetchAllPDN();
    }

    @GetMapping("/git/{git}")
    public ResponseEntity<ApiResponse<List<PDNResponseDTO>>> fetchPDNByGit(@PathVariable String git) {
        return pdnService.fetchPDNByGit(git);
    }

    @GetMapping("/developer")
    public ResponseEntity<ApiResponse<List<PDNResponseDTO>>> fetchPDNByDeveloper(@RequestParam Long userId) {
        return pdnService.fetchPDNByDeveloper(userId);
    }

    @GetMapping("/reviewer")
    public ResponseEntity<ApiResponse<List<PDNResponseDTO>>> fetchPDNByReviewer(@RequestParam Long reviewerId) {
        return pdnService.fetchPDNByReviewer(reviewerId);
    }

    @GetMapping("/not-reviewed")
    public ResponseEntity<ApiResponse<List<PDNResponseDTO>>> fetchPDNNOtReviewed(@RequestParam Long userId) {
        return pdnService.fetchPDNNotReviewed(userId);
    }
}
