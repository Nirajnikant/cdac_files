package com.app.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Order;
import com.app.model.OrderCommandType;
import com.app.services.OrderService;

@RestController
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(value = "/user/{userId}/order/update")
    public void updateOrder(final Order order, final OrderCommandType orderCommandType) {
        orderService.updateOrder(order, orderCommandType);
    }

    @GetMapping(value = "/order/{orderId}")
    public Order getOrderById(final String orderId) {
        return orderService.getOrderById(orderId);
    }

    @GetMapping(value = "/user/{userId}/order")
    public List<Order> getAllOrders(final String userId) {
        return orderService.getAllOrders(userId);
    }

    @GetMapping(value = "/user/{userId}/order/{restaurantId}")
    public List<Order> getAllOrdersByRestaurantId(final String userId, final String restaurantId) {
        return orderService.getAllOrdersByRestaurantId(userId, restaurantId);
    }
}
