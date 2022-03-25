package com.app.commands;


import java.util.List;

import org.springframework.stereotype.Component;

import com.app.datastore.CartData;
import com.app.model.CartCommandType;

import lombok.NonNull;

@Component
public class RemoveCartCommandExecutor extends CartCommandExecutor {
    private CartData cartData;

    public RemoveCartCommandExecutor(CartData cartData) {
        this.cartData = cartData;
    }

    @Override
    public boolean isValid(@NonNull final String userId, @NonNull final String restaurantId,
                           @NonNull final String itemId) {
        return cartData.getMenuItemIds(userId, restaurantId).contains(itemId);
    }

    @Override
    public void executeCommand(@NonNull final String userId, @NonNull final String restaurantId,
                               @NonNull final String itemId) {
        List<String> menuItemIds = cartData.getMenuItemIds(userId, restaurantId);
        menuItemIds.remove(itemId);
    }

    @Override
    public boolean isApplicable(CartCommandType cartCommandType) {
        return cartCommandType == CartCommandType.REMOVE_ITEM;
    }
}
