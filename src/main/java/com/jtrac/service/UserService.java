package com.jtrac.service;

import com.jtrac.dto.UserRequestDTO;
import com.jtrac.dto.UserResponseDTO;
import com.jtrac.responses.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<ApiResponse<List<UserResponseDTO>>> getAllUsers();
    ResponseEntity<ApiResponse<Integer>> createUser(UserRequestDTO userDTO);
}
