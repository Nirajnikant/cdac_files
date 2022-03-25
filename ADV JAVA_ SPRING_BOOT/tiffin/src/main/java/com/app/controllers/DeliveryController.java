package com.app.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Delivery;
import com.app.model.OrderStatus;
import com.app.services.DeliveryService;

import lombok.NonNull;

@RestController
public class DeliveryController {
    private DeliveryService deliveryService;

    @Autowired
    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @PostMapping(value = "/delivery")
    public void addDelivery(@NonNull final Delivery delivery) {
        deliveryService.addDelivery(delivery);
    }

    @GetMapping(value = "/delivery/{deliveryId}")
    public Delivery getDeliveryById(@NonNull final String deliveryId) {
        return deliveryService.getDeliveryById(deliveryId);
    }

    @GetMapping(value = "/delivery/list/{deliveryBoyId}")
    public List<Delivery> getDeliveriesByDeliveryBoyId(@NonNull final String deliveryBoyId) {
        return deliveryService.getDeliveriesByDeliveryBoyId(deliveryBoyId);
    }

    @GetMapping(value = "/delivery/orderStatus/{deliveryId}")
    public OrderStatus getOrderStatus(@NonNull final String deliveryId) {
        return deliveryService.getOrderStatus(deliveryId);
    }
}
