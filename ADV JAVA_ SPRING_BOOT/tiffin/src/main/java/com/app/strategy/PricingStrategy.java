package com.app.strategy;

import java.util.List;

import com.app.model.Bill;
import com.app.model.CouponCode;
import com.app.model.MenuItem;


public interface PricingStrategy {
    Bill generateBill(List<MenuItem> menuItemList);

    boolean isApplicable(CouponCode couponCode);
}
