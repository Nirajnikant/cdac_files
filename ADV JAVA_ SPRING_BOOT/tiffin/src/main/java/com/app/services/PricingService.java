package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Bill;
import com.app.model.CouponCode;
import com.app.model.MenuItem;
import com.app.strategy.PricingStrategy;

import lombok.NonNull;

@Service
public class PricingService {
    private List<PricingStrategy> pricingStrategyList;
    private CartService cartService;

    @Autowired
    public PricingService(List<PricingStrategy> pricingStrategyList, CartService cartService) {
        this.pricingStrategyList = pricingStrategyList;
        this.cartService = cartService;
    }

    public Bill getBill(@NonNull final String userId, @NonNull final String restaurantId,
                        @NonNull final CouponCode couponCode) {
        List<MenuItem> menuItemList = cartService.getAllItemsOfCart(userId, restaurantId);
        return pricingStrategyList.stream().filter(pricingStrategy -> pricingStrategy.isApplicable(couponCode))
                .findAny().get().generateBill(menuItemList);
    }
}
