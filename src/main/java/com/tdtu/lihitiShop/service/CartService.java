package com.tdtu.lihitiShop.service;

import com.tdtu.lihitiShop.dto.CartDto;
import com.tdtu.lihitiShop.dto.CartItemDto;
import com.tdtu.lihitiShop.entity.CartItem;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CartService {
    public ResponseEntity<CartItem> addProductToCart(String userId, String productId, int quantity);


    void removeProductFromCart(String cartItemId);

    CartItemDto updateQuantityForItem(String cartItemId);

    public CartDto moveToOrder(String idCart);


}
