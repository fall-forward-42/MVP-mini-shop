package com.tdtu.lihitiShop.service.impl;

import com.tdtu.lihitiShop.dto.CartDto;
import com.tdtu.lihitiShop.dto.CartItemDto;
import com.tdtu.lihitiShop.entity.Cart;
import com.tdtu.lihitiShop.entity.CartItem;
import com.tdtu.lihitiShop.entity.Product;
import com.tdtu.lihitiShop.entity.User;
import com.tdtu.lihitiShop.exception.ResourceNotFoundException;
import com.tdtu.lihitiShop.repository.CartItemsRepository;
import com.tdtu.lihitiShop.repository.CartRepository;
import com.tdtu.lihitiShop.repository.ProductRepository;
import com.tdtu.lihitiShop.repository.UserRepository;
import com.tdtu.lihitiShop.service.CartService;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class CartServiceImpl implements CartService {
    private UserRepository userRepository;
    private ProductRepository productRepository;
    private CartRepository cartRepository;
    private CartItemsRepository cartItemsRepository;
    @Override
    public ResponseEntity<CartItem> addProductToCart(String userId, String productId, int quantity) {
        //find user
        User user = userRepository.findById(userId).orElseThrow(
                ()-> new ResourceNotFoundException("cant not found user with id"+userId)
        );
        //find product
        Product product = productRepository.findById(productId).orElseThrow(
                ()-> new ResourceNotFoundException("can not found the product with id"+productId)
        );


        //check cart exist
        Optional<Cart> cart = cartRepository.findAll().stream()
                .filter(cart1 -> cart1.getId_user().equals(user.getId_user())).findFirst();

        //prepare the item for cart
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);
        //exist then add new cart item to cart
        if(cart.isPresent()){
            Cart getCart = cart.get();
            cartItem.setCart(getCart);
            cartItemsRepository.save(cartItem);
            return ResponseEntity.ok().body(cartItem);
        }

        //not exist then create new cart
        Cart newCart = new Cart();
        newCart.setId_user(userId);
        //put item into new cart
        cartItem.setCart(newCart);
        //return  items in cart

        return ResponseEntity.ok().body(cartItem);
    }


    @Override
    public void removeProductFromCart(String cartItemId) {


        //find cart item
    }

    @Override
    public CartItemDto updateQuantityForItem(String cartItemId) {
        return null;
    }

    @Override
    public CartDto moveToOrder(String idCart) {
        //find cart

        //cal the total

        //create the order

        //remove cart
        return null;
    }
}
