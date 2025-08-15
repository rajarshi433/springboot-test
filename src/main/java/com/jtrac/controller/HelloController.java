package com.jtrac.controller;

import com.jtrac.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/v1")
public class HelloController {

    @GetMapping("/hello")
    public ResponseEntity<ApiResponse<Integer>> hello() {
        return new ResponseEntity<>(new ApiResponse<>(HttpStatus.CREATED.value(), "UserEntity created successfully", 1000),
                HttpStatus.CREATED);
    }

    @GetMapping("/error/{id}")
    public ResponseEntity<ApiResponse<String>> getUser(@PathVariable Long id) {

        if (id == 0) {
            throw new RuntimeException("ID must not be zero");
        }
        if (id == 999) {
            throw new RuntimeException("UserEntity with id 999 does not exist");
        }
        return new ResponseEntity<>(new ApiResponse<>(HttpStatus.CREATED.value(), "UserEntity created successfully", "Data" +
                " object"),
                HttpStatus.CREATED);
    }
}
