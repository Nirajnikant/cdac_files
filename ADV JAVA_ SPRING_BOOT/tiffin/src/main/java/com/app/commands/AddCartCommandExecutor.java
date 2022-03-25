package com.app.commands;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.datastore.CartData;
import com.app.model.CartCommandType;
import com.app.model.FoodMenu;
import com.app.services.FoodMenuService;

import lombok.NonNull;

@Component
public class AddCartCommandExecutor extends CartCommandExecutor {
    private FoodMenuService foodMenuService;
    private CartData cartData;

    @Autowired
    public AddCartCommandExecutor(FoodMenuService foodMenuService, CartData cartData) {
        this.foodMenuService = foodMenuService;
        this.cartData = cartData;
    }

    @Override
    public boolean isValid(@NonNull final String userId, @NonNull final String restaurantId,
                           @NonNull final String itemId) {
        FoodMenu foodMenu = foodMenuService.getMenuByRestaurantId(restaurantId);
        return foodMenu.getMenuItemList().stream()
                .filter(menuItem -> menuItem.getId().equals(itemId)).findAny().isPresent();
    }

    @Override
    public void executeCommand(@NonNull final String userId, @NonNull final String restaurantId,
                               @NonNull final String itemId) {
        Map<String, List<String>> restaurantIdToMenuItemIds =
                cartData.getUserToRestaurantIdToMenuItemIds().getOrDefault(userId, new HashMap<>());
        List<String> menuItemIds = restaurantIdToMenuItemIds.getOrDefault(restaurantId, new ArrayList<>());
        menuItemIds.add(itemId);
        restaurantIdToMenuItemIds.put(restaurantId, menuItemIds);
        cartData.getUserToRestaurantIdToMenuItemIds().put(userId, restaurantIdToMenuItemIds);
    }

    @Override
    public boolean isApplicable(CartCommandType cartCommandType) {
        return cartCommandType == CartCommandType.ADD_ITEM;
    }
}
