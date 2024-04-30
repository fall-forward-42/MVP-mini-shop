package com.tdtu.lihitiShop.service;

import com.tdtu.lihitiShop.dto.CartDto;
import com.tdtu.lihitiShop.dto.CartItemDto;
import com.tdtu.lihitiShop.dto.OrderDto;
import com.tdtu.lihitiShop.entity.CartItem;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {
    void deleteItem(CartItemDto cartItemDto);

    CartItemDto updateItem(CartItemDto cartItemDto);

    public CartItemDto addProductToCart(String userId, String productId, int quantity);


    CartItemDto updateQuantityForItem(String cartItemId, Integer quantity);

    public OrderDto submitCartToOrder(String idCart);

    public List<CartItemDto> getAllItemsOfCartByUserId(String userId);

    public CartDto getCartById(String cartId);

    public List<CartItemDto> getAllItemsOfCartByCartId(String cartId);

    //cart items
    public CartItemDto getItemOfCartById(String cartItemId);

    void removeCart(String cartItemId);





}
