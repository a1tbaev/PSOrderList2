package com.example.psorderlist2.services;

import com.example.psorderlist2.dto.request.AuthenticateRequest;
import com.example.psorderlist2.dto.request.UserRequest;
import com.example.psorderlist2.dto.response.AuthenticationResponse;
import com.example.psorderlist2.dto.response.UserResponse;

import java.util.List;

public interface UserServices {
    UserResponse saveUser(UserRequest userRequest);
    UserResponse getUserById(Long id);
    List<UserResponse>getAllUser();
    String deleteUser(Long id);
    UserResponse updateUser(Long id,UserRequest userRequest);
    AuthenticationResponse login(AuthenticateRequest request);
}
