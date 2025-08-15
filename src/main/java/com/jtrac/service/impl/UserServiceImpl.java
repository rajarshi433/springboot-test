package com.jtrac.service.impl;

import com.jtrac.dto.UserRequestDTO;
import com.jtrac.dto.UserResponseDTO;
import com.jtrac.entity.RoleEntity;
import com.jtrac.entity.UserEntity;
import com.jtrac.repository.RoleRepository;
import com.jtrac.repository.UserRepository;
import com.jtrac.responses.ApiResponse;
import com.jtrac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public ResponseEntity<ApiResponse<List<UserResponseDTO>>> getAllUsers() {
        List<UserEntity> users = userRepository.findAllUsers();

        if (users.isEmpty())
            return new ResponseEntity<>(new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "No Users Found", null),
                    HttpStatus.NOT_FOUND);

        List<UserResponseDTO> userResponseDTOList = new ArrayList<>();

        for (UserEntity user : users) {
            UserResponseDTO userResponseDTO = new UserResponseDTO();

            userResponseDTO.setEmpId(user.getEmpId());
            userResponseDTO.setFirstName(user.getFirstName());
            userResponseDTO.setLastName(user.getLastName());
            userResponseDTO.setRole(user.getRole().getRoleName());

            userResponseDTOList.add(userResponseDTO);
        }

        return new ResponseEntity<>(new ApiResponse<>(HttpStatus.OK.value(), "Success", userResponseDTOList),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiResponse<Integer>> createUser(UserRequestDTO userDTO) {

        RoleEntity role = roleRepository.findRoleByName(userDTO.getRole())
                .orElseThrow(() -> new RuntimeException("Role Not Found : " + userDTO.getRole()));

        int rowsInserted = userRepository.saveUser(userDTO.getEmpId(), userDTO.getFirstName(), userDTO.getLastName(),
                userDTO.getPassword(), role.getRoleName());

        if (rowsInserted == 1)
            return new ResponseEntity<>(new ApiResponse<>(HttpStatus.CREATED.value(), "Success", rowsInserted),
                    HttpStatus.CREATED);

        return new ResponseEntity<>(new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Failed",
                rowsInserted),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
