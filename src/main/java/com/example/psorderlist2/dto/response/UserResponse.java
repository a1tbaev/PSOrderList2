package com.example.psorderlist2.dto.response;

import com.example.psorderlist2.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Long id;
    private String fullName;
    private LocalDate dateOfBirth;
    private String email;
    private String phoneNumber;
    private Role role;

}
