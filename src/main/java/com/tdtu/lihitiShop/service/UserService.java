package com.tdtu.lihitiShop.service;

import com.tdtu.lihitiShop.dto.UserDto;
import com.tdtu.lihitiShop.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(String  id);

    List<UserDto> getAllUsers();

    void deleteUser(String id);


}
