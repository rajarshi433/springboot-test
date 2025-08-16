package com.jtrac.controller;

import com.jtrac.dto.PDNRequestDTO;
import com.jtrac.dto.PDNResponseDTO;
import com.jtrac.responses.ApiResponse;
import com.jtrac.service.PDNService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pdn")
public class PDNController {

    @Autowired
    private PDNService pdnService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Integer>> createPDN(@RequestBody PDNRequestDTO pdnRequestDTO) {
        return pdnService.createPDN(pdnRequestDTO);
    }
}
