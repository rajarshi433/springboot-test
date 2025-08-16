package com.jtrac.controller;

import com.jtrac.dto.UserRequestDTO;
import com.jtrac.dto.UserResponseDTO;
import com.jtrac.responses.ApiResponse;
import com.jtrac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<UserResponseDTO>>> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Integer>> createUser(@RequestBody UserRequestDTO userDTO) {
        return userService.createUser(userDTO);
    }
}
