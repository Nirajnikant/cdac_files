package com.app.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.CartCommandType;
import com.app.model.MenuItem;
import com.app.services.CartService;

@RestController
public class CartController {
    private CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping(value = "/user/{userId}/cart/update")
    public void updateCart(final String userId, final String restaurantId, final String itemId,
                           final CartCommandType cartCommandType) {
        cartService.updateCart(userId, restaurantId, itemId, cartCommandType);
    }

    @PutMapping(value = "/user/{userId}/cart/clear")
    public void clearCart(final String userId, final String restaurantId) {
        cartService.clearCart(userId, restaurantId);
    }

    @GetMapping(value = "/user/{userId}/cart")
    public List<MenuItem> getAllItemsOfCart(final String userId, final String restaurantId) {
        return cartService.getAllItemsOfCart(userId, restaurantId);
    }
}
