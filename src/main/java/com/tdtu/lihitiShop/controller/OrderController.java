package com.tdtu.lihitiShop.controller;

import com.tdtu.lihitiShop.dto.OrderDto;
import com.tdtu.lihitiShop.dto.OrderItemDto;
import com.tdtu.lihitiShop.dto.UserDto;
import com.tdtu.lihitiShop.entity.User;
import com.tdtu.lihitiShop.exception.ResourceNotFoundException;
import com.tdtu.lihitiShop.mapper.UserMapper;
import com.tdtu.lihitiShop.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private OrderService orderService;

    public String getCurrUserId(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        UserDto userDto = UserMapper.mapToUserDto((User) userDetails);
        return userDto.getId_user();
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders(){
        if(getCurrUserId()==null){
            throw new ResourceNotFoundException("Not found user !");
        }
        List<OrderDto> items = orderService.getAllOrdersByUserId(getCurrUserId());
        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<OrderItemDto>> getDetailsOfOrder(@PathVariable("id") String id){
//        OrderDto order = orderService.getOrderByUserId(getCurrUserId());
        List<OrderItemDto> items = orderService.getDetailsOfOrder(id);
        return ResponseEntity.ok(items);
    }


}
