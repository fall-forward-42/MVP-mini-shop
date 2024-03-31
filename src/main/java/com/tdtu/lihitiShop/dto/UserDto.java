package com.tdtu.lihitiShop.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String id_user;
    @NotNull(message = "please input username")
    private String username;
    @NotNull(message = "please input password")
    @Size(min=6, message = "min of password is 6")
    private String password;
    private String fullName;
    @NotNull(message = "please input address")
    private String address;
    private Date createdAt;
    private Date updatedAt;
    private String roles;
}
