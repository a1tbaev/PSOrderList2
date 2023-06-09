package com.example.psorderlist2.controller;

import com.example.psorderlist2.dto.request.AuthenticateRequest;
import com.example.psorderlist2.dto.request.UserRequest;
import com.example.psorderlist2.dto.response.AuthenticationResponse;
import com.example.psorderlist2.dto.response.UserResponse;
import com.example.psorderlist2.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserServices userServices;

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody AuthenticateRequest request) {
        return userServices.login(request);
    }

    @PostMapping("/save")
    public UserResponse save(@RequestBody UserRequest userRequest) {
        return userServices.saveUser(userRequest);
    }

    @GetMapping("/get/{id}")
    public UserResponse getById(@PathVariable Long id) {
        return userServices.getUserById(id);
    }

    @GetMapping("/getAll")
    public List<UserResponse> getAll() {
        return userServices.getAllUser();
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public UserResponse update(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        return userServices.updateUser(id, userRequest);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String delete(@PathVariable Long id){
        return userServices.deleteUser(id);
    }
}
