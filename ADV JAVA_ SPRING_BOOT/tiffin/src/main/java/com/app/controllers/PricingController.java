package com.app.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Bill;
import com.app.model.CouponCode;
import com.app.services.PricingService;

@RestController
public class PricingController {
    private PricingService pricingService;

    @Autowired
    public PricingController(PricingService pricingService) {
        this.pricingService = pricingService;
    }

    @GetMapping(value = "/user/{userId}/cart/{couponCode}")
    public Bill getBill(final String userId, final String restaurantId, final CouponCode couponCode) {
        return pricingService.getBill(userId, restaurantId, couponCode);
    }
}
