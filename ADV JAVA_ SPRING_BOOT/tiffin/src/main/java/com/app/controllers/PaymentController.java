package com.app.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Payment;
import com.app.services.PaymentService;

@RestController
public class PaymentController {
    private PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping(value = "/payment")
    public void addPayment(final Payment payment) {
        paymentService.addPayment(payment);
    }

    @GetMapping(value = "/payment/{paymentId}")
    public Payment getPaymentById(final String paymentId) {
        return paymentService.getPaymentById(paymentId);
    }

    @GetMapping(value = "/payment/order/{orderId}")
    public Payment getPaymentByOrderId(final String orderId) {
        return paymentService.getPaymentByOrderId(orderId);
    }
}
