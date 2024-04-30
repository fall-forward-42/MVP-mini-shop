package com.tdtu.lihitiShop.service.impl;

import com.tdtu.lihitiShop.dto.CartDto;
import com.tdtu.lihitiShop.dto.CartItemDto;
import com.tdtu.lihitiShop.dto.OrderDto;
import com.tdtu.lihitiShop.dto.UserDto;
import com.tdtu.lihitiShop.entity.*;
import com.tdtu.lihitiShop.entity.enumType.OrderStatus;
import com.tdtu.lihitiShop.exception.ResourceNotFoundException;
import com.tdtu.lihitiShop.mapper.*;
import com.tdtu.lihitiShop.repository.*;
import com.tdtu.lihitiShop.service.CartService;
import com.tdtu.lihitiShop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {
    private UserRepository userRepository;
    private ProductRepository productRepository;
    private CartRepository cartRepository;
    private CartItemsRepository cartItemsRepository;
    private OrderItemsRepository orderItemsRepository;
    private OrderRepository orderRepository;
    private UserService userService;

    @Override
    public void deleteItem(CartItemDto cartItemDto){
        String id = cartItemDto.getId_cart_item();
        cartItemsRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not found item in cart"));
        cartItemsRepository.deleteById(id);
    }
    @Override
    public CartItemDto updateItem(CartItemDto cartItemDto){
        String id = cartItemDto.getId_cart_item();
        CartItem item = cartItemsRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not found item in cart"));
        item.setQuantity(cartItemDto.getQuantity());
        return CartItemMapper.mapToDto(cartItemsRepository.save(item));

    }
    @Override
    public CartItemDto addProductToCart(String userId, String productId, int quantity) {
        //find user
        User user = UserMapper.mapToUser(userService.getUserById(userId));

        //find product
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new ResourceNotFoundException("can not found the product with id: " + productId)
        );


        //check cart exist
        Optional<Cart> cart = cartRepository.findAll().stream()
                .filter(cart1 -> cart1.getId_user().equals(user.getId_user())).findFirst();

        //prepare the item for cart
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);
        //exist then add new cart item to cart
        if (cart.isPresent()) {
            Cart getCart = cart.get();
            cartItem.setCart(getCart);
             cartItemsRepository.save(cartItem);
            return CartItemMapper.mapToDto(cartItem);
        }

        //not exist then create new cart
        Cart newCart = new Cart();
        newCart.setId_user(userId);
        //save the new cart
        Cart newCartEntity = cartRepository.save(newCart);
        newCartEntity.setId_user(userId);
        //put item into new cart
        cartItem.setCart(newCartEntity);
        //return  items in cart
        //save the items into cart
        cartItemsRepository.save(cartItem);
        return CartItemMapper.mapToDto(cartItem);
    }


    @Override
    public void removeCart(String cartItemId) {
        cartRepository.deleteById(cartItemId);
    }

    @Override
    public CartItemDto updateQuantityForItem(String cartItemId, Integer quantity) {
        CartItemDto cartItemDto = getItemOfCartById(cartItemId);
        cartItemDto.setQuantity(quantity);
        CartItem updateCartItem = cartItemsRepository.save(CartItemMapper.mapToEntity(cartItemDto));
        return CartItemMapper.mapToDto(updateCartItem);
    }

    @Override
    public OrderDto submitCartToOrder(String idCart) {
        System.out.println(idCart);
        //check cart
        CartDto cart = getCartById(idCart);
        //System.out.println(cart.getId_cart());
        //find user
        UserDto user = userService.getUserById(cart.getId_user());

        //cal the total
        List<CartItemDto> cartItemDtos = getAllItemsOfCartByCartId(idCart);

        Double total = cartItemDtos.stream()
                .mapToDouble(cartItem->cartItem.getProduct().getPrice())
                .sum();
        System.out.println("Total: " + total);
        //create the order and save on DB
        Order newOrder = new Order();
        newOrder.setAddress(user.getAddress());
        newOrder.setUser(UserMapper.mapToUser(user));
        newOrder.setStatus(OrderStatus.NEW);
        newOrder.setToltalPrice(total);
        Order orderEntity = orderRepository.save(newOrder);

        //move cart items into order items and remove cart items
        List<OrderItem> orderItems = cartItemDtos.stream().map(e->{
            OrderItem newItem = new OrderItem();
            newItem.setQuantity(e.getQuantity());
            newItem.setOrder(orderEntity);
            newItem.setPrice(e.getProduct().getPrice());
            newItem.setId_product(e.getProduct().getId_product());
            //remove cart item
            cartItemsRepository.deleteById(e.getId_cart_item());
            return newItem;
        }).toList();

        orderItemsRepository.saveAll(orderItems);
        //remove cart
        removeCart(idCart);
        return OrderMapper.mapToDto(orderEntity);
    }
    @Override
    public List<CartItemDto> getAllItemsOfCartByCartId(String cartId) {
        //check cart
        CartDto cart = getCartById(cartId);
        List<CartItemDto> itemsList = new ArrayList<>();
        itemsList = cartItemsRepository.findAll().stream()
                .filter((e)->e.getCart().getId_cart().equals(cart.getId_cart()))
                .map(CartItemMapper::mapToDto)
                .toList();

        return itemsList;
    }
    @Override
    public List<CartItemDto> getAllItemsOfCartByUserId(String userId) {
        //check user
        User user = UserMapper.mapToUser(userService.getUserById(userId));
        System.out.println("user: " + userId);

        //
        List<CartItemDto> itemsList = new ArrayList<>();
        Optional<Cart> cart = cartRepository.findAll().stream().
                filter((e) -> e.getId_user().equals(user.getId_user()))
                .findFirst();
        System.out.println("Cart: " + cart);

        //if cart exists
        if (!cart.isEmpty()) {
            String cartId = cart.get().getId_cart();
            //find all items by cart id
            itemsList = cartItemsRepository.findAll().stream()
                    .filter((e) -> e.getCart().getId_cart().equals(cartId))
                    .map(CartItemMapper::mapToDto).toList();
        }


        return itemsList;
    }

    @Override
    public CartDto getCartById(String cartId) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new ResourceNotFoundException("Can not found cart with id: "+cartId));
        return CartMapper.mapToDto(cart);
    }



    @Override
    public CartItemDto getItemOfCartById(String cartItemId) {
        CartItem cartItem = cartItemsRepository.findById(cartItemId)
                .orElseThrow( ()->new ResourceNotFoundException("Can not found item in cart by item id: "+cartItemId));

        return CartItemMapper.mapToDto(cartItem);
    }
}