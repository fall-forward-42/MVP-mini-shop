package com.tdtu.lihitiShop.service.impl;

import com.tdtu.lihitiShop.dto.ReqResDto;
import com.tdtu.lihitiShop.dto.UserDto;
import com.tdtu.lihitiShop.entity.User;
import com.tdtu.lihitiShop.mapper.UserMapper;
import com.tdtu.lihitiShop.repository.UserRepository;
import com.tdtu.lihitiShop.security.JWTutils;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthServiceImpl {
    private UserRepository userRepository;
    private JWTutils jwTutils;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;

    public ReqResDto register(UserDto userRegister){
        ReqResDto resp = new ReqResDto();
        try {
            User user = new User();
            user.setUsername(userRegister.getUsername());
            user.setPassword(passwordEncoder.encode(userRegister.getPassword()));
            user.setRole(userRegister.getRoles());
            user.setAddress(userRegister.getAddress());
            user.setFullName(userRegister.getFullName());

            User saved = userRepository.save(user);
            //check save
            if(user.getId_user() != null){
                resp.setUserDto(UserMapper.mapToUserDto(saved));
                resp.setMessage("Register successfully");
                resp.setStatusCode(200);
            }
        }catch (Exception e){
            resp.setStatusCode(500);
            resp.setMessage(e.getMessage());
        }
        return resp;
    }
    public ReqResDto login(ReqResDto loginRequest){
        ReqResDto resp = new ReqResDto();
        try {
            authenticationManager
                    .authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    loginRequest.getUsername(),
                                    loginRequest.getPassword()));
            User user = userRepository.findByUsername(loginRequest.getUsername()).orElseThrow(

            );
            System.out.println("LOGIN: "+user);
            String  jwt = jwTutils.generateToken(user);
            String refreshToken = jwTutils.generateRefreshToken(new HashMap<>(),user);
            resp.setStatusCode(200);
            resp.setToken(jwt);
            resp.setRefreshToken(refreshToken);
            resp.setExpirationTime("24 hours");
            resp.setMessage("Login successfully");

        }catch (Exception e){
            resp.setStatusCode(500);
            resp.setMessage(e.getMessage());
        }
        return resp;
    }
    public ReqResDto refreshToken(ReqResDto refreshToken){
        ReqResDto resp = new ReqResDto();
        String username = jwTutils.extractUsername(refreshToken.getToken());
        User user = userRepository.findByUsername(username).orElseThrow();
        if(jwTutils.isTokenValid(refreshToken.getToken(),user)){
            String jwt = jwTutils.generateToken(user);
            resp.setStatusCode(200);
            resp.setToken(jwt);
            resp.setRefreshToken(refreshToken.getRefreshToken());
            resp.setExpirationTime("24 hours");
            resp.setMessage("Refresh token successfully");
            return resp;
        }
        resp.setStatusCode(500);
        return resp;
    }
}
