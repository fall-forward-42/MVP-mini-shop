package com.tdtu.lihitiShop.service.impl;

import com.tdtu.lihitiShop.dto.UserDto;
import com.tdtu.lihitiShop.entity.User;
import com.tdtu.lihitiShop.exception.ResourceNotFoundException;
import com.tdtu.lihitiShop.mapper.UserMapper;
import com.tdtu.lihitiShop.repository.UserRepository;
import com.tdtu.lihitiShop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto userDto) {
        User savedUser = userRepository.save(UserMapper.mapToUser(userDto))
                ;

        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Can not found user with id "+id));

        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserDto> users = userRepository.findAll()
                .stream()
                .map(UserMapper::mapToUserDto)
                .toList();

        return users;
    }

    @Override
    public void deleteUser(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Can not found user with id "+id));
        userRepository.deleteById(id);
    }
}
