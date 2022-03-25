package com.app.strategy;

import java.util.List;
import java.util.UUID;

import com.app.model.Bill;
import com.app.model.CouponCode;
import com.app.model.MenuItem;

public class FiveHundredOffPricingStrategy implements PricingStrategy {
    private final double discount = 500;

    @Override
    public Bill generateBill(List<MenuItem> menuItemList) {
        double totalCost = menuItemList.stream().mapToDouble(menuItem -> menuItem.getPrice()).sum();
        return Bill.builder()
                .id(UUID.randomUUID().toString())
                .totalCost(totalCost)
                .discount(discount)
                .amountToBePaid(totalCost - discount)
                .tax((totalCost - discount) * 0.05)
                .build();
    }

    @Override
    public boolean isApplicable(CouponCode couponCode) {
        return couponCode == CouponCode.FIVE_HUNDRED_OFF;
    }
}
