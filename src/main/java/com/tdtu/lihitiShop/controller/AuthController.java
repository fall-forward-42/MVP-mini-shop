package com.tdtu.lihitiShop.controller;


import com.tdtu.lihitiShop.dto.ReqResDto;
import com.tdtu.lihitiShop.dto.UserDto;
import com.tdtu.lihitiShop.entity.User;
import com.tdtu.lihitiShop.exception.ResourceNotFoundException;
import com.tdtu.lihitiShop.repository.UserRepository;
import com.tdtu.lihitiShop.service.UserService;
import com.tdtu.lihitiShop.service.impl.AuthServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/auth")
@Log
public class AuthController {
    private UserService userService;
    private AuthServiceImpl authService;

    @PostMapping("/login")
    public ResponseEntity<ReqResDto> login(@RequestBody @Valid ReqResDto loginRequest, BindingResult result){
        if(result.hasErrors()){
            Map<String, String> errors = result.getFieldErrors().stream()
                    .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

            throw new ResourceNotFoundException(errors.toString());
        }
        return ResponseEntity.ok().body(authService.login(loginRequest));

    }
    @PostMapping("/register")
    public ResponseEntity<ReqResDto> register(@Valid @RequestBody UserDto user, BindingResult result){
        //validate
        if(result.hasErrors()){
            Map<String, String> errors = result.getFieldErrors().stream()
                    .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

            throw new ResourceNotFoundException(errors.toString());
        }
        ReqResDto resp = authService.register(user);

        return ResponseEntity.ok().body(resp);
    }
    @PostMapping("/refresh")
    public ResponseEntity<ReqResDto> refreshToken(@RequestBody ReqResDto req){
        return ResponseEntity.ok().body(authService.refreshToken(req));
    }


}
