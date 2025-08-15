package com.jtrac.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {
    private long empId;
    private String firstName;
    private String lastName;
    private long password;
    private String role;
}
