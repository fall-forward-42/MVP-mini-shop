package com.tdtu.lihitiShop.controller;


import com.tdtu.lihitiShop.dto.ProductDto;
import com.tdtu.lihitiShop.dto.UserDto;
import com.tdtu.lihitiShop.entity.User;
import com.tdtu.lihitiShop.exception.ResourceNotFoundException;
import com.tdtu.lihitiShop.mapper.UserMapper;
import com.tdtu.lihitiShop.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    @GetMapping("/single")
    public ResponseEntity<UserDetails> getUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        UserDto userDto = UserMapper.mapToUserDto((User) userDetails);
        System.out.println(userDto.getId_user());
        return ResponseEntity.ok(userDetails);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") String id){
        UserDto userDto = userService.getUserById(id);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> userList = userService.getAllUsers();
        return ResponseEntity.ok(userList);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") String id){
        userService.deleteUser(id);
        return ResponseEntity.accepted().body("Remove successfully");
    }

}
