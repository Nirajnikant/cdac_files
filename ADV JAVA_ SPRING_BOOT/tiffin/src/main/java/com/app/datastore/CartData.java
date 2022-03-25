package com.app.datastore;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.app.exceptions.ExceptionType;
import com.app.exceptions.FoodDeliveryException;

import lombok.Getter;
import lombok.NonNull;

@Component
@Getter
public class CartData {
    private Map<String, Map<String, List<String>>> userToRestaurantIdToMenuItemIds = new HashMap<>();

    public List<String> getMenuItemIds(@NonNull final String userId, @NonNull final String restaurantId) {
        Map<String, List<String>> restaurantIdToMenuItemIds = getRestaurantIdToMenuItemIds(userId);
        if (!restaurantIdToMenuItemIds.containsKey(restaurantId)) {
            throw new FoodDeliveryException(ExceptionType.CART_IS_EMPTY, "Cart is empty for this restaurant");
        }
        return restaurantIdToMenuItemIds.get(restaurantId);
    }

    public Map<String, List<String>> getRestaurantIdToMenuItemIds(@NonNull final String userId) {
        return userToRestaurantIdToMenuItemIds.getOrDefault(userId, new HashMap<>());
    }
}
