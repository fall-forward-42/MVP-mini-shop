package com.tdtu.lihitiShop.controller;

import com.tdtu.lihitiShop.dto.CartItemDto;
import com.tdtu.lihitiShop.dto.OrderDto;
import com.tdtu.lihitiShop.dto.UserDto;
import com.tdtu.lihitiShop.entity.CartItem;
import com.tdtu.lihitiShop.entity.User;
import com.tdtu.lihitiShop.mapper.UserMapper;
import com.tdtu.lihitiShop.service.CartService;
import com.tdtu.lihitiShop.service.ProductService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/carts")
public class CartController {
    private CartService cartService;
    private ProductService productService;

    public String getCurrUserId(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        UserDto userDto = UserMapper.mapToUserDto((User) userDetails);
        return userDto.getId_user();
    }

    @PostMapping
    public ResponseEntity<CartItemDto> addItemToCart(
            @RequestBody CartItemDto cartItemDto
    ){
        System.out.println(cartItemDto);

        CartItemDto itemCart = cartService.addProductToCart(getCurrUserId(),cartItemDto.getProduct().getId_product(),cartItemDto.getQuantity());
        return new  ResponseEntity<>(itemCart, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CartItemDto>> getAllItemsOfCartByUserId(

    ){
        List<CartItemDto> itemList = cartService.getAllItemsOfCartByUserId(getCurrUserId());
        return  new ResponseEntity<>(itemList, HttpStatusCode.valueOf(200));
    }
    @DeleteMapping
    public ResponseEntity<List<CartItemDto>> removeCart(
            @RequestParam(value = "IdCart") String idCart
    ){
        cartService.removeCart(idCart);
        List<CartItemDto> itemList = cartService.getAllItemsOfCartByUserId(getCurrUserId());
        return  new ResponseEntity<>(itemList, HttpStatusCode.valueOf(200));

    }
    @GetMapping("/submit")
    public ResponseEntity<OrderDto> submitCartToOrder(
            ){

        //find cart of user
        String idCart = cartService.getAllItemsOfCartByUserId(getCurrUserId()).get(0).getCart().getId_cart();
       OrderDto order = cartService.submitCartToOrder(idCart);
       return  new ResponseEntity<>(order, HttpStatusCode.valueOf(200));
    }



}
