package com.app.datastore;


import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.app.model.Payment;

import lombok.Getter;

@Component
@Getter
public class PaymentData {
    private Map<String, Payment> paymentById = new HashMap<>();
    private Map<String, String> paymentIdByOrderId = new HashMap<>();
}
