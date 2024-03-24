package com.tdtu.lihitiShop.mapper;

import com.tdtu.lihitiShop.dto.UserDto;
import com.tdtu.lihitiShop.entity.User;

public class UserMapper {
    public static UserDto mapToUserDto(User user){
        return new UserDto(
                user.getId_user(),
                user.getUsername(),
                user.getPassword(),
                user.getFullName(),
                user.getAddress(),
                user.getCreatedAt(),
                user.getUpdatedAt()

        );
    }
    public  static User mapToUser(UserDto userDto){
        return new User(
                userDto.getId_user(),
                userDto.getUsername(),
                userDto.getPassword(),
                userDto.getFullName(),
                userDto.getAddress(),
                userDto.getCreatedAt(),
                userDto.getUpdatedAt()
        );
    }
}
